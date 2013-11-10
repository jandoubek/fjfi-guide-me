package cz.fjfi.guideme;

import java.util.ArrayList;

import cz.fjfi.guideme.android.MapsBaseAdapter;
import cz.fjfi.guideme.core.GMMapHeader;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MapSelectionActivity extends Activity {

	private ListView mapList;
	private MapsBaseAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map_selecion);

		ArrayList<GMMapHeader> headers = new ArrayList<GMMapHeader>();

		for(int i = 1 ; i < 20 ; i++){
			GMMapHeader header = new GMMapHeader();
			header.setName("Mapa "+i);
			header.setDescription("Popis mapy " +i);
			headers.add(header);
		}

		mapList = (ListView)findViewById(R.id.select_map_lv_mapList);
		adapter = new MapsBaseAdapter(this, headers);
		mapList.setAdapter(adapter);
		mapList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView adapterView, View view, int position, long id) {

				if(adapter.getClickedItem()!=position){
					View oldView = adapterView.getChildAt(adapter.getClickedItem());
					TextView description;
					Button button1;
					Button button2;
					if (oldView != null && adapter.getClickedItem() != -1) {
						description = (TextView) oldView.findViewById(R.id.item_description);
						description.setVisibility(View.GONE);
						button1 = (Button) oldView.findViewById(R.id.button1);
						button1.setVisibility(View.GONE);
						button2 = (Button) oldView.findViewById(R.id.button2);
						button2.setVisibility(View.GONE);
					}
					description = (TextView) view.findViewById(R.id.item_description);
					description.setVisibility(View.VISIBLE);
					button1 = (Button) view.findViewById(R.id.button1);
					button1.setVisibility(View.VISIBLE);
					button2 = (Button) view.findViewById(R.id.button2);
					button2.setVisibility(View.VISIBLE);
					adapter.setClickedItem(position);
				}else{
					View oldView = adapterView.getChildAt(adapter.getClickedItem());
					TextView description;
					Button button1;
					Button button2;
					if (oldView != null && adapter.getClickedItem() != -1) {
						description = (TextView) oldView.findViewById(R.id.item_description);
						description.setVisibility(View.GONE);
						button1 = (Button) oldView.findViewById(R.id.button1);
						button1.setVisibility(View.GONE);
						button2 = (Button) oldView.findViewById(R.id.button2);
						button2.setVisibility(View.GONE);
					}
					adapter.setClickedItem(-1);
				}
			}
		});

	}

}
