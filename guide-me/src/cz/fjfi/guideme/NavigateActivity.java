package cz.fjfi.guideme;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cz.fjfi.guideme.core.GMEdge;
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
	private int width;
	private int height;


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
	public void surfaceChanged(SurfaceHolder holder, int frmt, int w, int h) {
		tryDrawing(holder);
		width  = w;
		height = h;

	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub

	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub

	}
	private void tryDrawing(SurfaceHolder holder) {
		Canvas canvas = holder.lockCanvas();
		if (canvas != null) {
			drawMyStuff(canvas);
			holder.unlockCanvasAndPost(canvas);
		}
	}

	private void drawMyStuff(final Canvas canvas) {
	
		canvas.drawRGB(255, 255, 255);
		Paint paint = new Paint();
		paint.setColor(Color.GREEN);
		int w = width/8;
		int h = height/8;
		//vychozi pozice
		canvas.drawCircle(3*w, 5*h, 20, paint);
		canvas.drawLine(3*w, 4*h, 3*w, 5*h, paint);
		//nasledujici bod (uprostred)

		canvas.drawLine(2*w, 4*h, 3*w, 4*h, new Paint());  //vlevo
		canvas.drawLine(3*w, 4*h, 4*w, 4*h, paint); //napravo
		canvas.drawLine(3*w, 4*h, 3*w, 3*h, new Paint());//nahoru
		canvas.drawCircle(3*w, 4*h, 20, new Paint());

		//bod nalevo od nasledujiciho
		canvas.drawText("chodba", 2*w, 4*h, new Paint());
		canvas.drawCircle(2*w, 4*h, 20, new Paint());

		canvas.drawLine(2*w, 4*h, 1*w, 4*h, paint);//nalevo
		canvas.drawText("vlevo", 1*w, 4*h, new Paint());
		canvas.drawLine(2*w, 4*h, 2*w, 3*h, paint);//nahoru
		canvas.drawText("nahore", 2*w, 3*h, new Paint());
		canvas.drawLine(2*w, 4*h, 2*w, 5*h, paint);//dolu
		canvas.drawText("dole", 2*w, 5*h, new Paint());

		//bod napravo od nasledujiciho
		canvas.drawText("T-211", 4*w, 4*h, new Paint());
		canvas.drawCircle(4*w, 4*h, 20, new Paint());
		
		canvas.drawLine(4*w, 4*h, 5*w, 4*h, paint);//napravo
		canvas.drawText("vpravo", 5*w, 4*h, new Paint());		
		
		canvas.drawLine(4*w, 4*h, 4*w, 3*h, new Paint());//nahoru
		canvas.drawText("nahore", 4*w, 3*h, new Paint());	
		
		canvas.drawLine(4*w, 4*h, 4*w, 5*h, new Paint());//dolu
		canvas.drawText("dole", 4*w, 5*h, new Paint());	
		
		//bod nahoru od nasledujiciho
		canvas.drawText("T-211", 3*w, 3*h, new Paint());
		canvas.drawCircle(3*w, 3*h, 20, new Paint());
		

		canvas.drawLine(3*w, 3*h, 3*w, 2*h, new Paint());//naohru
		canvas.drawText("nahore", 3*w, 2*h, new Paint());

		canvas.drawLine(3*w, 3*h, 2*w, 3*h, new Paint());//doleva
		canvas.drawText("vlevo", 2*w, 3*h, new Paint());

		canvas.drawLine(3*w, 3*h, 4*w, 3*h, new Paint());//doprava
		canvas.drawText("vpravo", 4*w, 3*h, new Paint());
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
