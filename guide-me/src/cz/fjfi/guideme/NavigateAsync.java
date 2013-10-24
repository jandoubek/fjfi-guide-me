package cz.fjfi.guideme;

import android.os.AsyncTask;
import android.util.Log;


public class NavigateAsync extends AsyncTask<String, String, Void> {
	private final long updateTime=2000;
	private long startTime;
	private NavigateActivity context;

	public NavigateAsync(NavigateActivity context){
		this.context=context;
	}

	@Override
	protected Void doInBackground(String... params) {
		// TODO Auto-generated method stub
		Log.i("ASYNC", "background");
		long time = 0;
		while (true) {
			synchronized (this) {
				try {

					wait(updateTime);
					time += updateTime;
					publishProgress(""+time);
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

		super.onPreExecute();
	}

}
