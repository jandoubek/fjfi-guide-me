package cz.fjfi.guideme;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import cz.fjfi.guideme.android.MapsBaseAdapter;
import cz.fjfi.guideme.android.MapsDownloadBaseAdapter;
import cz.fjfi.guideme.android.MapsPointBaseAdapter;
import cz.fjfi.guideme.core.GMMap;
import cz.fjfi.guideme.core.GMMapHeader;
import cz.fjfi.guideme.core.GMNode;
import cz.fjfi.guideme.core.Guide;
import cz.fjfi.guideme.core.Utility;
import cz.fjfi.guideme.core.tst2;

public class MapSelectionActivity extends Activity {

	private ListView mapList;
	private MapsBaseAdapter adapter;
	private int clickedItem=-1;
	public MapsDownloadBaseAdapter adpaterDownload;
	private MapsPointBaseAdapter adapterNodes;
	private Guide guide;
	protected GMNode from;
	protected GMNode to;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map_selecion);

		initWidgets();
		initData();
		loadMap();



	}
	private void loadMap() {
		guide = Guide.getInstance();
		GMMap gmMap = new GMMap();
		UUID guid1 = Utility.generateGUID();
		UUID guid2 = Utility.generateGUID();
		gmMap = tst2.testmap2(guid1,guid2);
		guide.setMap(gmMap);
	}

	private void initWidgets() {
		Button downloadBT = (Button) findViewById(R.id.select_map_bt_download);
		downloadBT.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				setDialogDownloadMap();
			}
		});

		mapList = (ListView)findViewById(R.id.select_map_lv_mapList);
		mapList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
				if(clickedItem!=position){
					View oldView = adapterView.getChildAt(clickedItem);
					TextView description;
					Button play;
					Button delete;
					if (oldView != null && adapter.getClickedItem() != -1) {
						description = (TextView) oldView.findViewById(R.id.item_description);
						description.setVisibility(View.GONE);
						play = (Button) oldView.findViewById(R.id.navigate_bt_next);
						play.setVisibility(View.GONE);
						delete = (Button) oldView.findViewById(R.id.button2);
						delete.setVisibility(View.GONE);

					}
					description = (TextView) view.findViewById(R.id.item_description);
					description.setVisibility(View.VISIBLE);
					play = (Button) view.findViewById(R.id.navigate_bt_next);
					play.setVisibility(View.VISIBLE);
					delete = (Button) view.findViewById(R.id.button2);
					delete.setVisibility(View.GONE);
					adapter.setClickedItem(position);
				}else{
					View oldView = adapterView.getChildAt(adapter.getClickedItem());
					TextView description;
					Button button1;
					Button button2;
					if (oldView != null && clickedItem != -1) {
						description = (TextView) oldView.findViewById(R.id.item_description);
						description.setVisibility(View.GONE);
						button1 = (Button) oldView.findViewById(R.id.navigate_bt_next);
						button1.setVisibility(View.GONE);
						button2 = (Button) oldView.findViewById(R.id.button2);
						button2.setVisibility(View.GONE);
					}
					adapter.setClickedItem(-1);
				}
				adapter.notifyDataSetChanged();
			}
		});
	}

	private void initData() {
		ArrayList<GMMapHeader> headers = new ArrayList<GMMapHeader>();

		for(int i = 1 ; i < 20 ; i++){
			GMMapHeader header = new GMMapHeader();
			header.setName("Mapa "+i);
			header.setDescription("Popis mapy " +i);
			headers.add(header);
		}


		adapter = new MapsBaseAdapter(this, headers);
		mapList.setAdapter(adapter);
	}



	private void setDialogDownloadMap(){
		final Dialog dialog1 = new Dialog(MapSelectionActivity.this);
		dialog1.setContentView(R.layout.dialog_download_map);
		dialog1.setTitle(getString(R.string.map_selection_d_title));
		dialog1.setCancelable(true);


		WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
		lp.copyFrom(dialog1.getWindow().getAttributes());
		lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
		lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
		ListView maps = (ListView) dialog1.findViewById(R.id.dialog_download_lv_maps);
		EditText searchET = (EditText) dialog1.findViewById(R.id.dialog_download_et_search);
		ArrayList<GMMapHeader> headers = new ArrayList<GMMapHeader>();
		ArrayList<GMMapHeader> headers2 = new ArrayList<GMMapHeader>();

		maps.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
				//Log.w("MAPSELECTION", "guid: "+adpaterDownload.getItem(position).getGuid() + "  ,name:" +adpaterDownload.getItem(position).getName());
				new DownloadMapAsync(MapSelectionActivity.this).execute(""+adpaterDownload.getItem(position).getGuid(),adpaterDownload.getItem(position).getName());
				dialog1.cancel();
			}
		});

		adpaterDownload = new MapsDownloadBaseAdapter(MapSelectionActivity.this, headers, headers2);
		maps.setAdapter(adpaterDownload);
		new DownloadHeadersAsync(MapSelectionActivity.this).execute("");
		searchET.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				if (s.equals("")) {
					adpaterDownload.setOriginalHeaders();
					adpaterDownload.notifyDataSetChanged();
				}else {   
					adpaterDownload.setHeaders(searchList(adpaterDownload.getHeadersOrig(), s.toString()));
					adpaterDownload.notifyDataSetChanged();
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {

			}
		});

		dialog1.show();
		dialog1.getWindow().setAttributes(lp);
	}

	public void setDialogSelectPoint(boolean firstPoint){
		final boolean firstNode = firstPoint;
		final Dialog dialog1 = new Dialog(MapSelectionActivity.this);
		dialog1.setContentView(R.layout.dialog_download_map);
		if(firstNode)
			dialog1.setTitle(getString(R.string.map_selection_point_a_title));
		else
			dialog1.setTitle(getString(R.string.map_selection_point_b_title));
		dialog1.setCancelable(true);


		WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
		lp.copyFrom(dialog1.getWindow().getAttributes());
		lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
		lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
		ListView maps = (ListView) dialog1.findViewById(R.id.dialog_download_lv_maps);
		EditText searchET = (EditText) dialog1.findViewById(R.id.dialog_download_et_search);
		searchET.setHint(MapSelectionActivity.this.getString(R.string.dialog_download_et_search_hint2));
		maps.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
				if(firstNode){
					setDialogSelectPoint(false);
					from = adapterNodes.getNode(position);
					dialog1.cancel();
				}
				else{
					to = adapterNodes.getNode(position);
					setConfirmDialog();
					dialog1.cancel();
				}
			}
		});


		adapterNodes = new MapsPointBaseAdapter(MapSelectionActivity.this, new ArrayList<GMNode>(guide.getCurrentMap().getNodes()));
		maps.setAdapter(adapterNodes);

		searchET.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				if (s.equals("")) {
					adapterNodes.setOriginalNodes();
					adapterNodes.notifyDataSetChanged();
				}else {   
					adapterNodes.setNodes(searchListNodes(adapterNodes.getNodesOrig(), s.toString()));
					adapterNodes.notifyDataSetChanged();
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {

			}
		});

		dialog1.show();
		dialog1.getWindow().setAttributes(lp);
	}

	public void setConfirmDialog(){
		final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
		alertDialog.setTitle(R.string.map_selection_alert_title);
		String msg = MapSelectionActivity.this.getText(R.string.map_selection_alert_msg).toString() + " " + guide.getCurrentMap().getName() + " " +
				MapSelectionActivity.this.getText(R.string.map_selection_alert_msg2) + " " + from.getDescription() + " " +
				MapSelectionActivity.this.getText(R.string.map_selection_alert_msg3) + " " + to.getDescription() + "?";

		alertDialog.setMessage(msg);
		alertDialog.setButton(Dialog.BUTTON_POSITIVE,MapSelectionActivity.this.getText(R.string.map_selection_alert_yes), new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				List<GMNode> nodeList = new ArrayList<GMNode>();
				nodeList.add(from);
				nodeList.add(to);
				guide.setRoute(guide.findRouteBetween(nodeList));
				Intent intent = new Intent(MapSelectionActivity.this, NavigateActivity.class); 
				startActivity(intent);
				alertDialog.cancel();

			}
		});
		alertDialog.setButton(Dialog.BUTTON_NEGATIVE,MapSelectionActivity.this.getText(R.string.map_selection_alert_no), new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				alertDialog.cancel();
			}
		});
		alertDialog.setCancelable(true);
		alertDialog.show();
	}

	public ArrayList<GMMapHeader> searchList(ArrayList<GMMapHeader> seznam, String compare){
		ArrayList<GMMapHeader> seznamNal = new ArrayList<GMMapHeader>();

		for(GMMapHeader polozka : seznam){
			if(org.apache.commons.lang3.StringUtils.containsIgnoreCase(polozka.getName(), compare)){
				seznamNal.add(polozka);				
			}
		}
		sortList(seznamNal);
		return seznamNal;
	}

	public ArrayList<GMNode> searchListNodes(ArrayList<GMNode> seznam, String compare){
		ArrayList<GMNode> seznamNal = new ArrayList<GMNode>();

		for(GMNode polozka : seznam){
			if(org.apache.commons.lang3.StringUtils.containsIgnoreCase(polozka.getDescription(), compare)){
				seznamNal.add(polozka);				
			}
		}
		sortListNodes(seznamNal);
		return seznamNal;
	}
	public static String removeDiacritics(String text) {
		return  org.apache.commons.lang3.StringUtils.stripAccents(text);
	}

	private static void sortList(ArrayList<GMMapHeader> aItems){
		Collections.sort(aItems, new NameComparator());
	}
	private static void sortListNodes(ArrayList<GMNode> aItems){
		Collections.sort(aItems, new NameComparatorNodes());
	}

	static class NameComparator implements Comparator<Object> {
		public int compare(Object obj1, Object obj2)
		{
			GMMapHeader o1 = (GMMapHeader) obj1;
			GMMapHeader o2 = (GMMapHeader) obj2;
			return o1.getName().compareToIgnoreCase(o2.getName());
		}
	}

	static class NameComparatorNodes implements Comparator<Object> {
		public int compare(Object obj1, Object obj2)
		{
			GMNode o1 = (GMNode) obj1;
			GMNode o2 = (GMNode) obj2;
			return o1.getDescription().compareToIgnoreCase(o2.getDescription());
		}
	}
}
