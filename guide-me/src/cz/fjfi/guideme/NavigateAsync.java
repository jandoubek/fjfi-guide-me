package cz.fjfi.guideme;

import android.os.AsyncTask;
import android.util.Log;
import cz.fjfi.guideme.core.GMEdge;
import cz.fjfi.guideme.core.GMNode;
import cz.fjfi.guideme.core.Guide;
import cz.fjfi.guideme.core.Route;
import cz.fjfi.guideme.core.RouteIterator;
import cz.fjfi.guideme.core.RoutePoint;
import cz.fjfi.guideme.core.RouteSegment;


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
		context.vypis.setText(progress[0]);
		context.setStartTime(startTime);
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
	    RouteSegment segment = currentPosition.getSegment();
	    String label;
	    GMNode endpoint = guide.getCurrentRoute().getEnd();
	    if (guide.reachedDestination())
	    {
	        label = "Dosazen cil: " + endpoint.getDescription();
	    }
	    else
	    {
	        label = "Mirite k cili: " + endpoint.getDescription() + "\n" +
                    "Dalsiho bodu " + segment.getEnd().getDescription() +
                    " dosahnete za: " + (segment.getTimeDistance() - point.getSegmentDistancePassed())/1000 + "s" + "\n\n" +
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
	        if (previousPosition.hasPreviousSegment())
	        {
	            RouteSegment prevSegment = previousPosition.previousSegment();
	            label += prevSegment.getStart().getName() + " -- " + prevSegment.getEnd().getName() + "\n";
	        }
	        currentPosition = point.getIterator();
	        label += segment.getStart().getName() + " -- " + segment.getEnd().getName() + " <--\n";
	        if (currentPosition.hasNextSegment())
	        {
	            RouteSegment nextSegment = currentPosition.nextSegment();
	            label += nextSegment.getStart().getName() + " -- " + nextSegment.getEnd().getName();
	        }
	        
	    }
	    return label;
	}

}
