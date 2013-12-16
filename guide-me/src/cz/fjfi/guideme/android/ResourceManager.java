package cz.fjfi.guideme.android;

import android.util.Xml;
import cz.fjfi.guideme.core.*;
import cz.fjfi.guideme.core.Direction.Compass;
import cz.fjfi.guideme.core.Direction.Vertical;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/******************************************************************************
 * <p>This class works with file resources of GuideMe app. Its main goal is to load
 * and save XML files containing GuideMe map. It requires strict 
 * XML structure for successful load of map or headers.</p> 
 * 
 * <p>No check of data consistency are made. If the structures
 * of the XML is not held, than the returned structures can be partially
 * empty.</p>
 * 
 * @author Matìj Antoš & Martin Fous
 * @version 0.0.5
 */
public class ResourceManager
{
    /***************************************************************************
     * <p>Loads Guide.me map from given {@link FileInputStream}.</p> 
     * 
     * <p>It does not check any data consistency. If the XML is not according
     * Guide.me structure some parts of the map structure can be null.</p>
     * 
     * @param    fis Input stream of XML, which should be read.
     * @return   {@link GMMap} loaded from given stream. If error occurs null is
     *           returned. If the XML is not consistent, some structures within 
     *           the map can be empty.
     */
    public static GMMap loadMap(InputStream fis)
    {
    	GMMap map = new GMMap();
        List<GMMapHeader> header = null;
        List<GMNode> nodes = null;
        List<GMEdge> edges = null;
        List<Location> locations = null;
        
        try
        {
        	//read header
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(fis, null);
            header = readHeadersFromXMLFile(parser);
            
            //read nodes
            parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(fis, null);
            nodes = readNodesFromXMLFile(parser, map);
            map.setNodes(nodes);
            
            //read edges
            parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(fis, null);
            edges = readEdgesFromXMLFile(parser, map);
            map.setEdges(edges);
            
            //read locations
            parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(fis, null);
            locations = readLocationsFromXMLFile(parser, map);
            map.setLocations(locations);
        }
        catch (XmlPullParserException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (fis != null)
                    fis.close();
            }
            catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return map;
    }
    
    /***************************************************************************
     * Returns list containing all map headers in XML file of given 
     * @FileInputStream. If not successful, than returns null.
     * 
     * @param    fis Input stream of XML file in which map headers are found.
     * @return List of headers from given stream, or when unsuccessful null.
     */
    public static List<GMMapHeader> loadHeaders(FileInputStream fis)
    {
       
        try
        {
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(fis, null);
            return readHeadersFromXMLFile(parser);
        }
        catch (XmlPullParserException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (fis != null)
                    fis.close();
            }
            catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }

    
    /***************************************************************************
     * Returns list containing all Guide.me map headers by using given parser.
     * 
     * @param    parser {@link XmlPullParser} used to parse XML file containing
     *                  single Guide.me map header or it´s list.
     
     * @return List of Guide.me headers parsed by given parser, or when unsuccessful null.
     */
    private static List<GMMapHeader> readHeadersFromXMLFile(XmlPullParser parser)
            throws XmlPullParserException, IOException
    {
    	List<GMMapHeader> headers = null;
        int eventType = parser.getEventType();
        GMMapHeader currentHeader = null;

        while (eventType != XmlPullParser.END_DOCUMENT)
        {
            String name = null;
            switch (eventType)
            {
                case XmlPullParser.START_DOCUMENT:
                	headers = new ArrayList<GMMapHeader>();
                    break;
                case XmlPullParser.START_TAG:
                    name = parser.getName();
                    if (name.equalsIgnoreCase("map"))
                    {
                        currentHeader = new GMMapHeader();
                        if(parser.getAttributeName(0).equalsIgnoreCase("guid") && currentHeader != null)
                    	{
                    		currentHeader.setGuid(UUID.fromString(parser.getAttributeValue(0)));
                    	}
                    } 
                    else if (currentHeader != null)
                    {
                        if (name.equalsIgnoreCase("name"))
                        {
                            currentHeader.setName(parser.nextText());
                        }
                        else if (name.equalsIgnoreCase("description"))
                        {
                        	currentHeader.setDescription(parser.nextText());
                        }
                        else if (name.equalsIgnoreCase("gpscoords"))
                        {
                            //TODO: Do something
                        }
                        else if (name.equalsIgnoreCase("author"))
                        {
                        	if(parser.getAttributeName(0).equalsIgnoreCase("name"))
        	                {
        	                    currentHeader.setAuthorName(parser.getAttributeValue(0));
        	                }
        	            	if(parser.getAttributeName(1).equalsIgnoreCase("email"))
        	                {
        	            		currentHeader.setAuthorEmail(parser.getAttributeValue(1));
        	                }
                        }
                    }
                    break;
                case XmlPullParser.END_TAG:
                    name = parser.getName();
                    if (name.equalsIgnoreCase("map") && currentHeader != null)
                    {
                    	headers.add(currentHeader);
                    	currentHeader = null;
                    } 
            }
            eventType = parser.next();
        }
        return headers;
    }
       
    /***************************************************************************
     * Returns list containing all Guide.me nodes by using given parser.
     * 
     * @param    parser {@link XmlPullParser} used to parse XML file containing
     *                  list of Guide.me nodes or null if something goes wrong.
     *           myMap  {@link GMMap} to which Guide.me nodes are linked.
     * @return List of Guide.me nodes parsed by given, or when unsuccessful null.
     */
    private static List<GMNode> readNodesFromXMLFile(XmlPullParser parser, GMMap myMap)
            throws XmlPullParserException, IOException
    {
    	List<GMNode> nodes = null;
        int eventType = parser.getEventType();
        GMNode currentNode = null;
        
        UUID guid = null;
        List<UUID> locations = null;
        String nodeName = null;
        String desc = null;

        loop: while (eventType != XmlPullParser.END_DOCUMENT)
        {
            String name = null;
            switch (eventType)
            {
                case XmlPullParser.START_DOCUMENT:
                	//DO NOTHING
                    break;
                case XmlPullParser.START_TAG:
                    name = parser.getName();
                    if (name.equalsIgnoreCase("nodelist"))
                    {
                        nodes = new ArrayList<GMNode>();
                    } 
                    else if (nodes != null)
                    {
                        if (name.equalsIgnoreCase("node"))
                        {
                        	if(parser.getAttributeName(0).equalsIgnoreCase("guid"))
                        	{
                        		guid = UUID.fromString(parser.getAttributeValue(0));
                        	}
                        }
                        else if (guid != null)
                        {
                            if (name.equalsIgnoreCase("locs"))
                            {
                                locations = new ArrayList<UUID>();
                            }
                            else if (locations != null)
                            {
                            	if (name.equalsIgnoreCase("loc"))
                                {
                            		if(parser.getAttributeName(0).equalsIgnoreCase("guid"))
                                	{
                                		locations.add(UUID.fromString(parser.getAttributeValue(0)));
                                	}
                                }
                            }
                            else if (name.equalsIgnoreCase("name"))
                            {
                            	nodeName = parser.nextText();
                            }
                            else if (name.equalsIgnoreCase("desc"))
                            {
                            	desc = parser.nextText();
                            }
                        }
                    }
                    break;
                case XmlPullParser.END_TAG:
                    name = parser.getName();
                    if (name.equalsIgnoreCase("node") && guid != null)
                    {
                    	currentNode = new GMNode(guid, nodeName, locations, desc, myMap);
                    	nodes.add(currentNode);
                    	
                        guid = null;
                        locations = null;
                        nodeName = null;
                        desc = null;
                    }
                    else if (name.equalsIgnoreCase("nodelist") && nodes != null)
                    {
                    	break loop;
                    }
                    else if (name.equalsIgnoreCase("locs") && nodes != null)
                    {
                    	locations = null;
                    }
            }
            eventType = parser.next();
        }
        return nodes;
    }
    
    /***************************************************************************
     * Returns list containing all Guide.me edges by using given parser.
     * 
     * @param    parser {@link XmlPullParser} used to parse XML file containing
     *                  list of Guide.me edges or null if something goes wrong.
     *           myMap  {@link GMMap} to which Guide.me nodes are linked.
     * @return List of Guide.me edges parsed by given, or when unsuccessful null.
     */
    private static List<GMEdge> readEdgesFromXMLFile(XmlPullParser parser, GMMap myMap)
            throws XmlPullParserException, IOException
    {
    	List<GMEdge> edges = null;
        int eventType = parser.getEventType();
        GMEdge currentEdge = null;
        
        UUID guid = null;
        String edgeName = null;
        long distance = 0L;
        GMNode start = null;
        GMNode end = null;
        Direction direction = null;
        UUID locGUID = null;
        String desc = null;

        loop: while (eventType != XmlPullParser.END_DOCUMENT)
        {
            String name = null;
            switch (eventType)
            {
                case XmlPullParser.START_DOCUMENT:
                	//DO NOTHING
                    break;
                case XmlPullParser.START_TAG:
                    name = parser.getName();
                    if (name.equalsIgnoreCase("edgelist"))
                    {
                        edges = new ArrayList<GMEdge>();
                    } 
                    else if (edges != null)
                    {
                        if (name.equalsIgnoreCase("edge"))
                        {
                        	if(parser.getAttributeName(0).equalsIgnoreCase("guid"))
                        	{
                        		guid = UUID.fromString(parser.getAttributeValue(0));
                        	}
                        }
                        else if (guid != null)
                        {
                            if (name.equalsIgnoreCase("name"))
                            {
                            	edgeName = parser.nextText();
                            }
                            else if (name.equalsIgnoreCase("distance"))
                            {
                            	if(parser.getAttributeName(0).equalsIgnoreCase("time"))
                            	{
                            		distance = Long.parseLong(parser.getAttributeValue(0));
                            	}
                            }
                            else if (name.equalsIgnoreCase("start"))
                            {
                            	if(parser.getAttributeName(0).equalsIgnoreCase("guid"))
                            	{
                            		start = myMap.getNode(UUID.fromString(parser.getAttributeValue(0)));
                            	}
                            }
                            else if (name.equalsIgnoreCase("end"))
                            {
                            	if(parser.getAttributeName(0).equalsIgnoreCase("guid"))
                            	{
                            		end = myMap.getNode(UUID.fromString(parser.getAttributeValue(0)));
                            	}
                            }
                            else if (name.equalsIgnoreCase("direction"))
                            {
                            	direction = new Direction(Enum.valueOf(Compass.class, parser.getAttributeValue(0)), Enum.valueOf(Vertical.class, parser.getAttributeValue(1)));
                            }
                            else if (name.equalsIgnoreCase("location"))
                            {
                            	if(parser.getAttributeName(0).equalsIgnoreCase("guid"))
                            	{
                            		locGUID = UUID.fromString(parser.getAttributeValue(0));
                            	}
                            }
                            else if (name.equalsIgnoreCase("desc"))
                            {
                            	desc = parser.nextText();
                            }
                        }
                    }
                    break;
                case XmlPullParser.END_TAG:
                    name = parser.getName();
                    if (name.equalsIgnoreCase("edge") && guid != null)
                    {
                    	currentEdge = new GMEdge(locGUID, edgeName, distance, start, end, direction, desc, myMap);
                    	edges.add(currentEdge);
                    	
                        guid = null;
                        edgeName = null;
                        distance = 0L;
                        start = null;
                        end = null;
                        locGUID = null;
                        desc = null;
                    }
                    else if (name.equalsIgnoreCase("edgelist") && edges != null)
                    {
                    	break loop;
                    }
            }
            eventType = parser.next();
        }
        return edges;
    }
    
    /***************************************************************************
     * Returns list containing all Guide.me locations by using given parser.
     * 
     * @param    parser {@link XmlPullParser} used to parse XML file containing
     *                  list of Guide.me locations or null if something goes wrong.
     *           myMap  {@link GMMap} to which Guide.me locations are linked.
     * @return List of Guide.me locations parsed by given, or when unsuccessful null.
     */
    private static List<Location> readLocationsFromXMLFile(XmlPullParser parser, GMMap myMap)
            throws XmlPullParserException, IOException
    {
    	List<Location> locations = null;
        int eventType = parser.getEventType();
        Location currentLocation = null;
        
        UUID guid = null;
        String locationName = null;
        String desc = null;

        loop: while (eventType != XmlPullParser.END_DOCUMENT)
        {
            String name = null;
            switch (eventType)
            {
                case XmlPullParser.START_DOCUMENT:
                	//DO NOTHING
                    break;
                case XmlPullParser.START_TAG:
                    name = parser.getName();
                    if (name.equalsIgnoreCase("locationlist"))
                    {
                        locations = new ArrayList<Location>();
                    } 
                    else if (locations != null)
                    {
                        if (name.equalsIgnoreCase("location"))
                        {
                        	if(parser.getAttributeName(0).equalsIgnoreCase("guid"))
                        	{
                        		guid = UUID.fromString(parser.getAttributeValue(0));
                        	}
                        }
                        else if (guid != null)
                        {
                            if (name.equalsIgnoreCase("name"))
                            {
                            	locationName = parser.nextText();
                            }
                            else if (name.equalsIgnoreCase("desc"))
                            {
                            	desc = parser.nextText();
                            }
                        }
                    }
                    break;
                case XmlPullParser.END_TAG:
                    name = parser.getName();
                    if (name.equalsIgnoreCase("location") && guid != null)
                    {
                    	currentLocation = new Location(guid, locationName, desc, myMap);
                    	locations.add(currentLocation);
                    	
                        guid = null;
                        locationName = null;
                        desc = null;
                    }
                    else if (name.equalsIgnoreCase("locationlist") && locations != null)
                    {
                    	break loop;
                    }
            }
            eventType = parser.next();
        }
        return locations;
    }
}
