package cz.fjfi.guideme;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import cz.fjfi.guideme.core.*;
import java.util.UUID;

public class NavigateActivity extends Activity {
	public TextView vypis;
	private Guide guide = Guide.getInstance();
	private Route route;
	private GMMap gmMap;
	private GMNode from, to;
	private boolean navigateIsRunning ;
	private long startTime=0;
	private NavigateAsync navigateAsync;


	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_navigate);
		vypis = (TextView) findViewById(R.id.navigate_tv_vypis);

		gmMap = new GMMap();
		UUID guid1 = Utility.generateGUID();
		UUID guid2 = Utility.generateGUID();
		gmMap = tst.testmap(guid1,guid2);
		from = gmMap.getNode(guid1); // 
		to = gmMap.getNode(guid2); //
		guide.setMap(gmMap);
		route = guide.findRouteBetween(from, to);
		guide.setRoute(route);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.navigate, menu);
		return true;
	}

	public void navigate_bt_start_OnClick(View view)
	{
		if (!navigateIsRunning)
		{
			startAsync();
		}
	}

	private void startAsync() 
	{
		navigateAsync = new NavigateAsync(this, startTime);
		navigateAsync.execute("");
		navigateIsRunning = true;
	}

	public Route getRoute()
	{
		return route;
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) 
	{
		super.onSaveInstanceState(savedInstanceState);
		savedInstanceState.putString("vypis", vypis.getText()+"");
		savedInstanceState.putLong("startTime", startTime);
		savedInstanceState.putBoolean("running", navigateIsRunning);
	}

	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) 
	{
		super.onRestoreInstanceState(savedInstanceState);
		startTime = savedInstanceState.getLong("startTime");
		vypis.setText(savedInstanceState.getString("vypis"));
		navigateIsRunning = savedInstanceState.getBoolean("running");
		if(navigateIsRunning)
		{
			startAsync();
		}
	}

	public void setStartTime(long startTime){
		this.startTime=startTime;
	}

	@Override
	protected void onStop() {
		if(navigateAsync!=null)
			navigateAsync.cancel(false);
		super.onStop();
	}


}
