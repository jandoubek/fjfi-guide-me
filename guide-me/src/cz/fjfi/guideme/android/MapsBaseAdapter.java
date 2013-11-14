package cz.fjfi.guideme.android;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import cz.fjfi.guideme.R;
import cz.fjfi.guideme.core.GMMapHeader;
/**
 * This class is adapter for listview
 * 
 * @author Vladislav Klima
 */
public class MapsBaseAdapter  extends BaseAdapter {
	private ArrayList<GMMapHeader> headers;

	private int clickedItem = -1;
	private LayoutInflater mInflater;

	public MapsBaseAdapter(Context context, ArrayList<GMMapHeader> headers) {
		this.headers = headers;

		mInflater = LayoutInflater.from(context);
	}

	/**
	 * Number of item in arraylist
	 */
	public int getCount() { 
		return headers.size();
	}

	/**
	 * Return header by given position
	 * @param position position of item in arraylist
	 */
	public GMMapHeader getItem(int position) {
		return headers.get(position);
	}

	/**
	 * Add new header to arraylist
	 * @param header header to add
	 */
	public void add(GMMapHeader header){
		headers.add(header);
	}

	public long getItemId(int position) {
		return position;
	}

	public ArrayList<GMMapHeader> getFiles(){
		return headers;
	}

	public void setFiles(ArrayList<GMMapHeader> headers){
		this.headers = headers;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) { 
			convertView = mInflater.inflate(R.layout.item_map_selection, null);
			holder = new ViewHolder();
			holder.itemDescription = (TextView) convertView.findViewById(R.id.item_description);
			holder.itemName = (TextView) convertView.findViewById(R.id.item_name);
			holder.button1 = (Button) convertView.findViewById(R.id.navigate_bt_next);
			holder.button2 = (Button) convertView.findViewById(R.id.button2);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.itemDescription.setText(headers.get(position).getDescription()); 
		if(clickedItem!=position){
			holder.itemDescription.setVisibility(View.GONE);
			holder.button1.setVisibility(View.GONE);
			holder.button2.setVisibility(View.GONE);
		}
		holder.button1.setClickable(true);
		holder.button2.setClickable(true);
		holder.button1.setFocusable(true);
		holder.button2.setFocusable(true);  
		holder.itemName.setText(headers.get(position).getName());  
		holder.button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.i("ADAPTER", "clicked button1 ");
			}
		});
		holder.button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.i("ADAPTER", "clicked button2 ");
			}
		});

		return convertView;
	}

	static class ViewHolder {
		TextView itemName;
		TextView itemDescription;
		Button button1;
		Button button2;
	}

	public int getClickedItem(){
		return clickedItem;
	}

	public void setClickedItem(int position){
		clickedItem = position;
	}


}