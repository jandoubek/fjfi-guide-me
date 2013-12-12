package cz.fjfi.guideme;

import android.graphics.Canvas;
import android.os.AsyncTask;
import android.view.SurfaceHolder;
import android.view.View;
import cz.fjfi.guideme.core.Direction;
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
	private GMEdge previousEdge;

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
		context.setStartTime(startTime);
		RoutePoint point = guide.getCurrentRoutePoint(System.currentTimeMillis()-startTime);
		RouteIterator currentPosition = point.getIterator();
		GMEdge edge = currentPosition.get();

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
			if(previousEdge!=null)
				context.getActualIV().setImageResource( getDirectionImage(previousEdge.getDirection().subtract(edge.getDirection())));
			SurfaceHolder holder = context.getSurface().getHolder();
			Canvas canvas = holder.lockCanvas();
			canvas.drawRGB(255, 255, 255);


			if (currentPosition.hasNext())
			{


				GMEdge nextEdge = currentPosition.next();
				Direction.Relative direction = edge.getDirection().subtract(nextEdge.getDirection());
				if(direction == Direction.Relative.Straight )
				{
					context.tryDrawingStart(canvas, edge, false, Direction.Relative.Straight);
					context.tryDrawing(canvas, nextEdge, true, Direction.Relative.Straight);	
				}else if(direction == Direction.Relative.SharpRight | direction == Direction.Relative.SlightRight| direction == Direction.Relative.Right)
				{
					context.tryDrawingStart(canvas, edge, false, Direction.Relative.Right);
					context.tryDrawing(canvas, nextEdge, true, Direction.Relative.Right);
				}else if(direction == Direction.Relative.SharpLeft | direction == Direction.Relative.SlightLeft | direction == Direction.Relative.Left){
					context.tryDrawingStart(canvas, edge, false, Direction.Relative.Left);
					context.tryDrawing(canvas, nextEdge, true, Direction.Relative.Left);
				}else{
					context.tryDrawingStart(canvas, edge, false, Direction.Relative.Left);
					context.tryDrawing(canvas, nextEdge, true, Direction.Relative.Back);
				}

				context.getNextTV().setText(nextEdge.getDescription());
				context.getNextIV().setImageResource(getDirectionImage(direction));
				if (currentPosition.hasNext())
				{
					//currentPosition.copy().get();
					GMEdge nextEdge2 = currentPosition.next();
					Direction.Relative direction2 = nextEdge2.getDirection().subtract(nextEdge2.getDirection());
					if(direction2 == Direction.Relative.Straight )
					{
						context.tryDrawing(canvas, nextEdge2, true, Direction.Relative.Straight);
					}
					else if(direction2 == Direction.Relative.SharpRight | direction == Direction.Relative.SlightRight| direction == Direction.Relative.Right)
					{
						context.tryDrawing(canvas, nextEdge2, true, Direction.Relative.Right);
					}
					else if(direction2 == Direction.Relative.SharpLeft | direction == Direction.Relative.SlightLeft | direction == Direction.Relative.Left)
					{
						context.tryDrawing(canvas, nextEdge2, true, Direction.Relative.Left);
					}

					context.getNext2TV().setText(nextEdge2.getDescription());
					//context.tryDrawing(canvas, nextEdge, true, Direction.Relative.Back);
					context.getNext2IV().setImageResource(getDirectionImage( nextEdge.getDirection().subtract(nextEdge2.getDirection())));
				}else{
					context.getNext2TV().setText("");
					context.getNext2IV().setVisibility(View.INVISIBLE);
				}
			}else{
				context.getNextTV().setText("");
				context.getNextIV().setVisibility(View.INVISIBLE);
				//context.tryDrawingStart(canvas, edge, false, Direction.Relative.Back);				
			}
			holder.unlockCanvasAndPost(canvas);
			
			if(previousEdge==null) previousEdge=edge;
			if(previousEdge.getGUID()!=edge.getGUID())
				previousEdge = edge;
			
		}
	}

	private int getDirectionImage(Direction.Relative direction) {

		switch (direction) {
		case Back:
			return R.drawable.back_1;

		case Right:
			return R.drawable.left_2;

		case SharpRight:
			return R.drawable.left_3;

		case SlightRight:
			return R.drawable.left_1;

		case Left:
			return R.drawable.right_2;

		case SharpLeft:
			return R.drawable.right_3;

		case SlightLeft:
			return R.drawable.right_1;

		case Straight:
			return R.drawable.straight_1;

		default:
			return R.drawable.unknown;
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

}
