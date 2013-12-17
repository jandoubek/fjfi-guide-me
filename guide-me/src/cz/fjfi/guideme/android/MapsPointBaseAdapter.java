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
import cz.fjfi.guideme.core.GMNode;

public class MapsPointBaseAdapter extends BaseAdapter {
	private ArrayList<GMNode> nodes;
	private ArrayList<GMNode> nodesOrig;
	private LayoutInflater mInflater;

	public MapsPointBaseAdapter(Context context, ArrayList<GMNode> nodes) {
		//sortList(headers);
		this.nodes = nodes;
		this.nodesOrig = new ArrayList<GMNode>(nodes);
		mInflater = LayoutInflater.from(context);
	}

	/**
	 * Number of item in arraylist
	 */
	public int getCount() { 
		return nodes.size();
	}

	/**
	 * Return header by given position
	 * @param position position of item in arraylist
	 */
	public GMNode getItem(int position) {
		return nodes.get(position);
	}

	/**
	 * Add new node to arraylist
	 * @param header header to add
	 */
	public void add(GMNode header){
		nodes.add(header);
		nodesOrig.add(header);
		sortList(nodes);
		sortList(nodesOrig);
	}
	
	public void setOriginalNodes(){
		sortList(nodesOrig);
		nodes = new ArrayList<GMNode>(nodesOrig);
	}

	public long getItemId(int position) {
		return position;
	}

	public ArrayList<GMNode> getNodes(){
		return nodes;
	}
	public ArrayList<GMNode> getNodesOrig(){
		return nodesOrig;
	}

	public void setNodes(ArrayList<GMNode> nodes){
		this.nodes = nodes;
	}
	public GMNode getNode(int position){
		return nodes.get(position);
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) { 
			convertView = mInflater.inflate(R.layout.item_select_point, null);
			holder = new ViewHolder();
			holder.itemName = (TextView) convertView.findViewById(R.id.select_point_tv);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.itemName.setText(nodes.get(position).getDescription());  
		return convertView;
	}

	static class ViewHolder {
		TextView itemName;
	}
	
	private static void sortList(ArrayList<GMNode> aItems){
		Collections.sort(aItems, new NameComparator());
	}
	
	static class NameComparator implements Comparator<Object> {
		 public int compare(Object obj1, Object obj2)
	      {
	            GMMapHeader o1 = (GMMapHeader) obj1;
	            GMMapHeader o2 = (GMMapHeader) obj2;
	            return o1.getDescription().compareToIgnoreCase(o2.getDescription());
	      }
	}
}