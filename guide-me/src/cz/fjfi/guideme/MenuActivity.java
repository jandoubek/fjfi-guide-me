package cz.fjfi.guideme;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MenuActivity extends Activity
{
	/***************************************************************************
     * TODO: comment
     */
    //TODO: body
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
	}

	/***************************************************************************
     * TODO: comment
     */
    //TODO: body
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}
	
	/** Called when the user clicks the Navigate button */
	public void menu_bt_navigate_onClick(View view) {
	    Intent intent = new Intent(this, NavigateActivity.class);
	    startActivity(intent);
	}
	
}
