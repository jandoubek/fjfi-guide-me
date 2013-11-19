package cz.fjfi.guideme;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import cz.fjfi.guideme.core.Guide;

public class NavigateActivity extends Activity {
	public TextView vypis;
	private Guide guide = Guide.getInstance();
	private boolean navigateIsRunning ;
	private long startTime=0;
	private NavigateAsync navigateAsync;


	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_navigate);
		vypis = (TextView) findViewById(R.id.navigate_tv_vypis);
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
			Button startBT = (Button) findViewById(R.id.navigate_bt_start);
			startBT.setEnabled(false);
			startAsync();
		}
	}
	
	public void navigate_bt_next_OnClick(View view)
	{
		guide.goToNextStretch(System.currentTimeMillis()-startTime);
	}
	
	public void navigate_bt_previous_OnClick(View view)
	{
		guide.goToPreviousStretch(System.currentTimeMillis()-startTime);
	}

	private void startAsync() 
	{
		navigateAsync = new NavigateAsync(this, startTime);
		navigateAsync.execute("");
		navigateIsRunning = true;
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
			Button startBT = (Button) findViewById(R.id.navigate_bt_start);
			startBT.setEnabled(false);
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
