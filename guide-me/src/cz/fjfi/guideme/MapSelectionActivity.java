package cz.fjfi.guideme;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
import cz.fjfi.guideme.core.GMMapHeader;

public class MapSelectionActivity extends Activity {

	private ListView mapList;
	private MapsBaseAdapter adapter;
	private int clickedItem=-1;
	private MapsDownloadBaseAdapter adpaterDownload;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map_selecion);

		initWidgets();
		initData();



	}
	private void initWidgets() {
		Button downloadBT = (Button) findViewById(R.id.select_map_bt_download);
		downloadBT.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				setDialog();
			}
		});
		
		mapList = (ListView)findViewById(R.id.select_map_lv_mapList);
		mapList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
				if(clickedItem!=position){
					View oldView = adapterView.getChildAt(clickedItem);
					TextView description;
					Button button1;
					Button button2;
					if (oldView != null && adapter.getClickedItem() != -1) {
						description = (TextView) oldView.findViewById(R.id.item_description);
						description.setVisibility(View.GONE);
						button1 = (Button) oldView.findViewById(R.id.navigate_bt_next);
						button1.setVisibility(View.GONE);
						button2 = (Button) oldView.findViewById(R.id.button2);
						button2.setVisibility(View.GONE);

					}
					description = (TextView) view.findViewById(R.id.item_description);
					description.setVisibility(View.VISIBLE);
					button1 = (Button) view.findViewById(R.id.navigate_bt_next);
					button1.setVisibility(View.VISIBLE);
					button2 = (Button) view.findViewById(R.id.button2);
					button2.setVisibility(View.VISIBLE);
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



	private void setDialog(){
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

		adpaterDownload = new MapsDownloadBaseAdapter(MapSelectionActivity.this, headers);
		maps.setAdapter(adpaterDownload);

		searchET.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				if (s.equals("")) {
					adpaterDownload.setOriginalHeaders();
					adpaterDownload.notifyDataSetChanged();
				} else {   	
					adpaterDownload.setHeaders(searchSeznam(adpaterDownload.getHeadersOrig(), s.toString()));
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

	public ArrayList<GMMapHeader> searchSeznam(ArrayList<GMMapHeader> seznam, String compare){
		ArrayList<GMMapHeader> seznamNal = new ArrayList<GMMapHeader>();

		for(GMMapHeader polozka : seznam){
			if(org.apache.commons.lang3.StringUtils.containsIgnoreCase(removeDiacritics(polozka.getName()), removeDiacritics(compare))){
				seznamNal.add(polozka);				
			}
		}
		sortList(seznamNal);
		return seznamNal;
	}
	public static String removeDiacritics(String text) {
		return  org.apache.commons.lang3.StringUtils.stripAccents(text);
	}

	private static void sortList(ArrayList<GMMapHeader> aItems){
		Collections.sort(aItems, new NameComparator());
	}

	static class NameComparator implements Comparator<Object> {
		public int compare(Object obj1, Object obj2)
		{
			GMMapHeader o1 = (GMMapHeader) obj1;
			GMMapHeader o2 = (GMMapHeader) obj2;
			return o1.getName().compareToIgnoreCase(o2.getName());
		}
	}
}
