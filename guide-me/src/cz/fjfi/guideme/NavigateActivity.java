package cz.fjfi.guideme;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class NavigateActivity extends Activity {
	public TextView vypis;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_navigate);
		vypis = (TextView) findViewById(R.id.navigate_tv_vypis);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.navigate, menu);
		return true;
	}
	
	public void navigate_bt_start_OnClick(View view)
	{
		NavigateAsync navigateAsync = new NavigateAsync(this);
		navigateAsync.execute("");
	}

}
