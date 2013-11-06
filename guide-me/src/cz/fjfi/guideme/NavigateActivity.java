package cz.fjfi.guideme;

import android.os.Bundle;
import android.app.Activity;
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
	private boolean navigateIsRunning = false;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
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
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.navigate, menu);
		return true;
	}
	
	public void navigate_bt_start_OnClick(View view)
	{
		if (!navigateIsRunning)
		{
			NavigateAsync navigateAsync = new NavigateAsync(this);
			navigateAsync.execute("");
			navigateIsRunning = true;
		}
	}
	
	public Route getRoute()
	{
		return route;
	}

}
