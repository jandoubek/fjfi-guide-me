package cz.fjfi.guideme.android;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import cz.fjfi.guideme.R;
import cz.fjfi.guideme.core.GMMapHeader;

public class MapsDownloadBaseAdapter extends BaseAdapter {
	private ArrayList<GMMapHeader> headers;
	private ArrayList<GMMapHeader> headersOrig;
	private LayoutInflater mInflater;

	public MapsDownloadBaseAdapter(Context context, ArrayList<GMMapHeader> headers) {
		//sortList(headers);
		this.headers = headers;
		headersOrig = new ArrayList<GMMapHeader>(headers);
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
		headersOrig.add(header);
		sortList(headers);
		sortList(headersOrig);
	}
	
	public void setOriginalHeaders(){
		sortList(headersOrig);
		headers = new ArrayList<GMMapHeader>(headersOrig);
	}

	public long getItemId(int position) {
		return position;
	}

	public ArrayList<GMMapHeader> getHeaders(){
		return headers;
	}
	public ArrayList<GMMapHeader> getHeadersOrig(){
		return headers;
	}

	public void setHeaders(ArrayList<GMMapHeader> headers){
		this.headers = headers;
		headersOrig = new ArrayList<GMMapHeader>(headers);
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) { 
			convertView = mInflater.inflate(R.layout.item_download_map, null);
			holder = new ViewHolder();
			holder.itemDescription = (TextView) convertView.findViewById(R.id.item_download_tv_description);
			holder.itemName = (TextView) convertView.findViewById(R.id.item_download_tv_name);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.itemDescription.setText(headers.get(position).getDescription()); 
		holder.itemName.setText(headers.get(position).getName());  
		return convertView;
	}

	static class ViewHolder {
		TextView itemName;
		TextView itemDescription;
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