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
import cz.fjfi.guideme.MapSelectionActivity;
import cz.fjfi.guideme.R;
import cz.fjfi.guideme.core.GMMapHeader;
/**
 * This class is adapter for listview
 * 
 * @author Vladislav Klima
 */
public class MapsBaseAdapter  extends BaseAdapter {
	private ArrayList<GMMapHeader> headers;
	private MapSelectionActivity context;
	private int clickedItem = -1;
	private LayoutInflater mInflater;

	public MapsBaseAdapter(MapSelectionActivity context, ArrayList<GMMapHeader> headers) {
		this.headers = headers;
		this.context=context;
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
			holder.play = (Button) convertView.findViewById(R.id.navigate_bt_next);
			holder.delete = (Button) convertView.findViewById(R.id.button2);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.itemDescription.setText(headers.get(position).getDescription()); 
		if(clickedItem!=position){
			holder.itemDescription.setVisibility(View.GONE);
			holder.play.setVisibility(View.GONE);
			holder.delete.setVisibility(View.GONE);
		}
		holder.play.setClickable(true);
		holder.delete.setClickable(true);
		holder.play.setFocusable(true);
		holder.delete.setFocusable(true);  
		holder.itemName.setText(headers.get(position).getName());  
		holder.play.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.i("ADAPTER", "clicked play button ");
				context.setDialogSelectPoint(true);
			}
		});
		holder.delete.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.i("ADAPTER", "clicked delete button ");
			}
		});

		return convertView;
	}

	static class ViewHolder {
		TextView itemName;
		TextView itemDescription;
		Button play;
		Button delete;
	}

	public int getClickedItem(){
		return clickedItem;
	}

	public void setClickedItem(int position){
		clickedItem = position;
	}


}