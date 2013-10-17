package cz.fjfi.guideme.android;

import android.util.Xml;
import cz.fjfi.guideme.core.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/******************************************************************************
 * This class works with file resources of GuideMe app. Its main goal is to 
 * load and save XML files containing GuideMe map.
 * @author
 * @version
 */
public class ResourceManager
{
	/***************************************************************************
     * TODO: comment
     */
    //TODO: body
	public static Map loadMap(String fileName)
	{
		Map createdMap = new Map();
		List<Node> nodeList = new ArrayList<Node>();
		List<Edge> edgeList = new ArrayList<Edge>();
		List<Location> locationList = new ArrayList<Location>();
		
		try
		{
			InputStream in = new FileInputStream(fileName);
			
			XmlPullParser parser = Xml.newPullParser();
			parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in, null);
            parser.nextTag();
            
            in.close();
		}
		catch(FileNotFoundException fileException)
		{
			//TODO: Catch
		}
		catch(XmlPullParserException xmlException)
		{
			//TODO: Catch
		}
		catch(IOException ioException)
		{
			//TODO: Catch
		}
	
		return createdMap;
	}
}
