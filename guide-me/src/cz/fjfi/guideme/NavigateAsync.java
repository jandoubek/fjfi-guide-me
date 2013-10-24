package cz.fjfi.guideme;

import android.os.AsyncTask;
import android.util.Log;
import cz.fjfi.guideme.core.Navigator;
import cz.fjfi.guideme.core.Route;


public class NavigateAsync extends AsyncTask<String, String, Void> {
	private final long updateTime=2000;
	private long startTime;
	private NavigateActivity context;
	private Route route;
	private Navigator navigator;

	public NavigateAsync(NavigateActivity context){
		this.context=context;
	}

	@Override
	protected Void doInBackground(String... params) {
		Log.i("ASYNC", "background");
		startTime=System.currentTimeMillis();
		long time = 0;
		String label;
		while (true) {
			synchronized (this) {
				try {

					wait(updateTime);
					time += updateTime;
					label = navigator.getCurrentLabel(System.currentTimeMillis()-startTime);
					publishProgress(label);
					if(time>20000){
						return null;
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}	
		}
	}

	@Override
	protected void onProgressUpdate(String... progress) {
		Log.i("ASYNC", progress[0]);
		context.vypis.setText(progress[0]);
	}

	@Override
	protected void onPostExecute(Void result) {
		Log.i("ASYNC", "on post");

		super.onPostExecute(result);
	}

	@Override
	protected void onPreExecute() {
		Log.i("ASYNC", "on pre");
		
		route = context.getRoute();
		navigator = new Navigator(route);
		super.onPreExecute();
	}

}
