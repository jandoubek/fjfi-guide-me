package cz.fjfi.guideme;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import cz.fjfi.guideme.android.ResourceManager;

public class DownloadHeadersAsync extends AsyncTask<String, String, Void> {
	private MapSelectionActivity context;

	public DownloadHeadersAsync(MapSelectionActivity context){
		this.context=context;
	}

	@Override
	protected Void doInBackground(String... params) {
		Log.i("ASYNC", "background");
		String result = downloadToString(context.getString(R.string.url_headers));
		Log.e("DOWNLOADASYNC", result);
		safeToFile(result, "headers.xml");
		FileInputStream fis=null;
		try {
			fis = context.openFileInput("headers.xml" );
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ResourceManager.loadMap(fis);
		return null;
	}
	
	private void safeToFile(String data, String fileName){

		FileOutputStream outputStream;

		try {
			outputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);
			outputStream.write(data.getBytes());
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	


	private String downloadToString(String urlLink){

		URL url;
		try {
			url = new URL(urlLink);
			URLConnection connection = url.openConnection();
			connection.connect();

			//int fileLength = connection.getContentLength();

			InputStream input = new BufferedInputStream(url.openStream());

			BufferedReader r = new BufferedReader(new InputStreamReader(input));
			StringBuilder total = new StringBuilder();
			String line;
			while ((line = r.readLine()) != null) {
				total.append(line);
			}
			input.close();
			return total.toString();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	protected void onProgressUpdate(String... progress) {
	}

	@Override
	protected void onPostExecute(Void result) {
		super.onPostExecute(result);
	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
	}
}