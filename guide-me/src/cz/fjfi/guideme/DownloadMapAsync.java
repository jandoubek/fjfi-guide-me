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
import android.widget.Toast;
import cz.fjfi.guideme.android.ResourceManager;
import cz.fjfi.guideme.core.GMMap;

public class DownloadMapAsync extends AsyncTask<String, String, String> {
	private MapSelectionActivity context;

	public DownloadMapAsync(MapSelectionActivity context){
		this.context=context;
	}

	@Override
	protected String doInBackground(String... params) {
		Log.i("ASYNC", "downloading map " + params[0]);
		String result = downloadToString("http://kmlinux.fjfi.cvut.cz/~fortpet2/guideme/maps/"+params[0]+".xml");
		Log.e("DOWNLOADASYNC", "map downloaded: " + result);
		safeToFile(result, params[0]+".xml");
		/*FileInputStream fis=null;
		try {
			fis = context.openFileInput(params[0]+".xml" );
			GMMap map  = ResourceManager.loadMap(fis);
			Log.w("DOWNLOAD MAP", "" + map.getDescription() + "  ," + map.getNodes().size()) ;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}*/
		for(String file : context.fileList())
			Log.w("DOWNLOAD MAP2", "" +file);
		return params[1];
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
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		Toast.makeText(context, context.getString(R.string.map_selection_toast_download)+" "+result, Toast.LENGTH_LONG).show();
	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
	}
}