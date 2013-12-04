package cz.fjfi.guideme;

import java.util.List;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import cz.fjfi.guideme.core.GMEdge;
import cz.fjfi.guideme.core.GMNode;
import cz.fjfi.guideme.core.Guide;
import cz.fjfi.guideme.core.RouteIterator;
import cz.fjfi.guideme.core.RoutePoint;
import cz.fjfi.guideme.core.RouteStretch;


public class NavigateAsync extends AsyncTask<String, String, Void> {
	private final long updateTime=1000;
	private long startTime;
	private NavigateActivity context;
	private Guide guide = Guide.getInstance();

	public NavigateAsync(NavigateActivity context, long timeStart){
		this.context=context;
		if(timeStart>0){

			this.startTime=timeStart;	
		}
		else 
			startTime=System.currentTimeMillis();


	}

	@Override
	protected Void doInBackground(String... params) {

		long time = 0;
		String label;
		while (!isCancelled()) {
			synchronized (this) {
				try {

					wait(updateTime);
					time += updateTime;
					label = generateLabel(guide.getCurrentRoutePoint(System.currentTimeMillis()-startTime));
					//Log.d("NAVIGATEASYNC", generatTestLAbel(guide.getCurrentRoutePoint(System.currentTimeMillis()-startTime)));
					publishProgress(label);
					if(time>60000){
						return null;
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}	
		}
		return null;
	}

	@Override
	protected void onProgressUpdate(String... progress) {
		//context.vypis.setText(progress[0]);
		context.setStartTime(startTime);

		RoutePoint point = guide.getCurrentRoutePoint(System.currentTimeMillis()-startTime);
		RouteIterator currentPosition = point.getIterator();
		GMEdge edge = currentPosition.get();
		List<GMNode> nodes = guide.getCurrentMap().getNeighborsOf(edge.getEnd());
		for(GMNode node : nodes)
			Log.e("ASYNC", "map " + node.getName() + " --> " + node.getDescription());
		GMNode endpoint = guide.getCurrentRoute().getEnd();
		if (guide.reachedDestination())
		{
			context.getActualTV().setText("Dosažen cíl: " + endpoint.getDescription());
			context.hideWidgets();
		}
		else
		{
			context.getActualTV().setText(edge.getDescription()); 
			context.getActualTimeTV().setText((edge.getTimeDistance() - point.getEdgeDistancePassed())/1000 + " s");

			//context.getActualIV().setImageResource(getDirectionImage(edge));

			if (currentPosition.hasNext())
			{
				GMEdge nextEdge = currentPosition.next();
				context.getNextTV().setText(nextEdge.getDescription());
				//context.getNextIV().setImageResource(getDirectionImage(nextEdge));
				if (currentPosition.hasNext())
				{
					nextEdge = currentPosition.next();
					context.getNext2TV().setText(nextEdge.getDescription());
					//context.getNext2IV().setImageResource(getDirectionImage(nextEdge));
				}else{
					context.getNext2TV().setText("");
					context.getNext2IV().setVisibility(View.INVISIBLE);
				}
			}else{
				context.getNextTV().setText("");
				context.getNextIV().setVisibility(View.VISIBLE);
			}

		}
	}

	private int getDirectionImage(GMEdge edge) {

		switch (edge.getDirection()) {
		case East:
			return 1;
		case North:

			return 1;
		case Northeast:

			return 1;
		case Northwest:

			return 1;
		case South:

			return 1;
		case Southeast:

			return 1;
		case Southwest:

			return 1;
		case West:

			return 1;

		default:
			return 0;
		}
	}

	@Override
	protected void onPostExecute(Void result) {
		super.onPostExecute(result);
	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
	}

	private String generateLabel(RoutePoint point)
	{
		RouteIterator currentPosition = point.getIterator();
		GMEdge edge = currentPosition.get();
		RouteStretch stretch = currentPosition.getStretch();
		String label;
		GMNode endpoint = guide.getCurrentRoute().getEnd();
		if (guide.reachedDestination())
		{
			label = "Dosazen cil: " + endpoint.getDescription();
		}
		else
		{
			label = "Mirite k cili: " + endpoint.getDescription() + "\n" +
					"Dalsiho bodu " + stretch.getEnd().getDescription() +
					" dosahnete za: " + (stretch.getTimeDistance() - point.getStretchDistancePassed())/1000 + "s" + "\n\n" +
					"Nyni se nachazite na: " + edge.getDescription() + "\n";
			RouteIterator previousPosition = point.getIterator();
			previousPosition.previous();
			if (previousPosition.hasPrevious())
			{
				GMEdge prevEdge = previousPosition.previous();
				label += prevEdge.getStart().getName() + " -> "; 
			}
			label += edge.getStart().getName() + " -- " + edge.getEnd().getName() + "(" +
					(edge.getTimeDistance() - point.getEdgeDistancePassed())/1000 + "s)";
			if (currentPosition.hasNext())
			{
				GMEdge nextEdge = currentPosition.next();
				label += " -> " + nextEdge.getEnd().getName();
			}
			label += "\n\n";
			previousPosition = point.getIterator();
			previousPosition.previous();
			if (previousPosition.hasPreviousStretch())
			{
				RouteStretch prevStretch = previousPosition.previousStretch();
				label += prevStretch.getStart().getName() + " -- " + prevStretch.getEnd().getName() + "\n";
			}
			currentPosition = point.getIterator();
			label += stretch.getStart().getName() + " -- " + stretch.getEnd().getName() + " <--\n";
			if (currentPosition.hasNextStretch())
			{
				RouteStretch nextStretch = currentPosition.nextStretch();
				label += nextStretch.getStart().getName() + " -- " + nextStretch.getEnd().getName();
			}

		}
		return label;
	}

	private String generatTestLAbel(RoutePoint point){
		RouteIterator currentPosition = point.getIterator();
		GMEdge edge = currentPosition.get();
		String label;
		GMNode endpoint = guide.getCurrentRoute().getEnd();
		if (guide.reachedDestination())
		{
			label = "Dosazen cil: " + endpoint.getDescription();
		}
		else
		{
			label = 
					"Nyni se nachazite na: " + edge.getDescription()  + "(" +
							(edge.getTimeDistance() - point.getEdgeDistancePassed())/1000 + "s) \n";


			if (currentPosition.hasNext())
			{
				GMEdge nextEdge = currentPosition.next();
				label+="dalsi: " + nextEdge.getDescription();
				if (currentPosition.hasNext())
				{
					nextEdge = currentPosition.next();
					label+="dalsi: " + nextEdge.getDescription();
				}
			}

		}
		return label;
	}

}
