package cz.fjfi.guideme;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cz.fjfi.guideme.core.Guide;

public class NavigateActivity extends Activity  implements SurfaceHolder.Callback {
	public TextView vypis;
	private Guide guide = Guide.getInstance();
	private boolean navigateIsRunning ;
	private long startTime=0;
	private NavigateAsync navigateAsync;
	
	private TextView actualTV,actualTimeTV,nextTV,next2TV;
	private ImageView actualIV,nextIV,next2IV;
	private SurfaceView surface;


	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_navigate);
		initWidget();
	}

	private void initWidget() {
		actualTV = (TextView) findViewById(R.id.navigate_tv_actual);
		actualTimeTV = (TextView) findViewById(R.id.navigate_tv_actual_time);
		nextTV = (TextView) findViewById(R.id.navigate_tv_next);
		next2TV = (TextView) findViewById(R.id.navigate_tv_next2);
		
		actualIV = (ImageView) findViewById(R.id.navigate_iv_actual);
		nextIV = (ImageView) findViewById(R.id.navigate_iv_next);
		next2IV = (ImageView) findViewById(R.id.navigate_iv_next2);
		
		surface = (SurfaceView) findViewById(R.id.surfaceView1);
		
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

	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
		// TODO Auto-generated method stub
		
	}

	public TextView getActualTV() {
		return actualTV;
	}

	public TextView getActualTimeTV() {
		return actualTimeTV;
	}

	public TextView getNextTV() {
		return nextTV;
	}

	public TextView getNext2TV() {
		return next2TV;
	}

	public ImageView getActualIV() {
		return actualIV;
	}

	public ImageView getNextIV() {
		return nextIV;
	}

	public ImageView getNext2IV() {
		return next2IV;
	}

	public SurfaceView getSurface() {
		return surface;
	}

	
	public void hideWidgets(){
		RelativeLayout rl = (RelativeLayout) findViewById(R.id.relativeLayout2); 
		rl.setVisibility(View.INVISIBLE);
		rl = (RelativeLayout) findViewById(R.id.relativeLayout3);
		rl.setVisibility(View.INVISIBLE);
		actualTimeTV.setVisibility(View.INVISIBLE);
		actualIV.setVisibility(View.INVISIBLE);
	}

}
