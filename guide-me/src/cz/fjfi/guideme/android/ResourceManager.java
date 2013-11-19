package cz.fjfi.guideme.android;

import android.util.Xml;
import cz.fjfi.guideme.core.*;

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
 * This class works with file resources of GuideMe app. Its main goal is to load
 * and save XML files containing GuideMe map.
 * 
 * @author
 * @version
 */
public class ResourceManager
{
    /***************************************************************************
     * TODO: comment
     */
    // TODO: body
    public static GMMap loadMap(FileInputStream fis)
    {
       
        try
        {
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(fis, null);
            parser.nextTag();
            return readXMLFile(parser);
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
     * Returns list containing all map headers in XML file of given 
     * @FileInputStream. If not successful, than returns null.
     * 
     * @param fis Input stream of XML file in which Mapheaders should
     *            be found.
     * @return List of headers from given stream, or when unsuccessful null.
     */
    public static List<GMMapHeader> loadHeaders(FileInputStream fis)
    {
       
        try
        {
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(fis, null);
            parser.nextTag();
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

    private static GMMap readXMLFile(XmlPullParser parser)
            throws XmlPullParserException, IOException
    {
        GMMap createdMap = new GMMap();
        parser.require(XmlPullParser.START_TAG, "", "map");
        while (parser.next() != XmlPullParser.END_DOCUMENT)
        {
            if (parser.getEventType() != XmlPullParser.START_TAG)
            {
                continue;
            }
            String name = parser.getName();
            if (name.equals("map"))
            {
                createdMap.setGuid(java.util.UUID.fromString(parser
                        .getAttributeValue(0)));
            }
            else if (name.equals("name"))
            {
                createdMap.setName(parser.getText());
            }
            else if (name.equals("author"))
            {
                createdMap.setAuthorName(parser.getAttributeValue(0));
                createdMap.setAuthorEmail(parser.getAttributeValue(1));
            }
            else if (name.equals("description"))
            {
                createdMap.setDescription(parser.getText());
            }
            else if (name.equals("nodelist"))
            {
                createdMap.setNodes(parseNodeList(parser, createdMap));
            }
            else if (name.equals("edgelist"))
            {
                createdMap.setEdges(parseEdgeList(parser, createdMap));
            }
            else if (name.equals("locationlist"))
            {
                createdMap.setLocations(parseLocationList(parser, createdMap));
            }
        }
        return createdMap;
    }
    
    private static List<GMMapHeader> readHeadersFromXMLFile(XmlPullParser parser)
            throws XmlPullParserException, IOException
    {
    	List<GMMapHeader> headers = new ArrayList<GMMapHeader>();
        parser.require(XmlPullParser.START_TAG, "", "headers");
        parser.next();
        while (parser.getName() != "headers")
        {
            if (parser.getName() == "map")
            {
                headers.add(readHeader(parser));
            }
            else
                parser.next();
        }
        parser.require(XmlPullParser.END_TAG, "", "headers");
        parser.next();
        return headers;
    }
    
    private static GMMapHeader readHeader(XmlPullParser parser) 
    		throws XmlPullParserException, IOException
    {
    	        UUID uuid = null;
    	        String name = "";
    	        String description = "";
    	        String authorName = "";
    	        String authorEmail = "";
    	        String filename = "";
    	        
    	        parser.require(XmlPullParser.START_TAG, "", "map");
    	        filename = parser.getAttributeValue(0);
                uuid = java.util.UUID.fromString(filename);
    	        while (parser.getName() != "map")
    	        {
    	            if (parser.getEventType() != XmlPullParser.START_TAG)
    	            {
    	            	parser.next();
    	            }
    	            else if (parser.getName() == "name")
    	            {
    	                name = parser.getText();
    	            }
    	            else if (parser.getName() == "author")
    	            {
    	            	if(parser.getAttributeName(0) == "name")
    	                {
    	                    authorName = parser.getAttributeValue(0);
    	                }
    	            	if(parser.getAttributeName(1) == "email")
    	                {
    	                    authorEmail = parser.getAttributeValue(1);
    	                }
    	            }
    	            else if (parser.getName() == "desc")
    	            {
    	                description = parser.getText();
    	            }
    	        }
    	        
    	        parser.require(XmlPullParser.END_TAG, "", "map");
    	        parser.next();
    	        
    	        GMMapHeader header = new GMMapHeader();
    	        header.setGuid(uuid);
    	        header.setName(name);
    	        header.setAuthorName(authorName);
    	        header.setAuthorEmail(authorEmail);
    	        header.setFilename(filename);
    	        header.setDescription(description);
    	        return header;
    }

    private static List<GMNode> parseNodeList(XmlPullParser parser,
            GMMap createdMap) throws XmlPullParserException, IOException
    {
        List<GMNode> nodes = new ArrayList<GMNode>();
        parser.require(XmlPullParser.START_TAG, "", "nodelist");
        parser.next();
        while (parser.getName() != "nodelist")
        {
            if (parser.getName() == "node")
            {
                nodes.add(readNode(parser, createdMap));
            }
            else
                parser.next();
        }
        parser.require(XmlPullParser.END_TAG, "", "nodelist");
        parser.next();
        return nodes;
    }

    private static List<GMEdge> parseEdgeList(XmlPullParser parser,
            GMMap createdMap) throws XmlPullParserException, IOException
    {
        List<GMEdge> edges = new ArrayList<GMEdge>();
        parser.require(XmlPullParser.START_TAG, "", "edgelist");
        parser.next();
        while (parser.getName() != "edgelist")
        {
            if (parser.getName() == "edge")
            {
                edges.add(readEdge(parser, createdMap));
            }
            else
                parser.next();
        }
        parser.require(XmlPullParser.END_TAG, "", "edgelist");
        parser.next();
        return edges;
    }

    private static List<Location> parseLocationList(XmlPullParser parser,
            GMMap createdMap) throws XmlPullParserException, IOException
    {
        List<Location> locations = new ArrayList<Location>();
        parser.require(XmlPullParser.START_TAG, "", "locationlist");
        parser.next();
        while (parser.getName() != "locationlist")
        {
            if (parser.getName() == "location")
            {
                locations.add(readLocation(parser, createdMap));
            }
            else
                parser.next();
        }
        parser.require(XmlPullParser.END_TAG, "", "locationlist");
        parser.next();
        return locations;
    }

    private static GMNode readNode(XmlPullParser parser, GMMap createdMap)
            throws XmlPullParserException, IOException
    {
        UUID uuid = null;
        String name = "";
        List<UUID> locations = new ArrayList<UUID>();
        String description = "";

        parser.require(XmlPullParser.START_TAG, "", "node");
        uuid = java.util.UUID.fromString(parser.getAttributeValue(0));
        while (parser.getName() != "node")
        {
            if (parser.getEventType() != XmlPullParser.START_TAG)
            {
                parser.next();
            }
            else if (parser.getName() == "name")
            {
                name = parser.getText();
            }
            else if (parser.getName() == "locs")
            {
                parser.next();
                while (parser.getName() != "locs")
                {
                    parser.require(XmlPullParser.START_TAG, "", "loc");
                    locations.add(java.util.UUID.fromString(parser
                            .getAttributeValue(0)));
                    parser.next();
                }
            }
            else if (parser.getName() == "desc")
            {
                description = parser.getText();
            }
        }
        parser.require(XmlPullParser.END_TAG, "", "nodelist");
        parser.next();
        GMNode node = new GMNode(uuid, name, locations, description, createdMap);
        return node;
    }

    private static Location readLocation(XmlPullParser parser, GMMap createdMap)
            throws XmlPullParserException, IOException
    {
        UUID uuid = null;
        String name = "";
        String description = "";
        parser.require(XmlPullParser.START_TAG, "", "location");
        while (parser.getName() != "locationlist")
        {
            if (parser.getEventType() != XmlPullParser.START_TAG)
            {
                parser.next();
            }
            else if (parser.getName() == "location")
            {
                if(parser.getAttributeName(0) == "guid")
                {
                    uuid = java.util.UUID.fromString(parser.getAttributeValue(0));
                }
            }
            else if (parser.getName() == "name")
            {
                name = parser.getText();
            }
            else if (parser.getName() == "desc")
            {
                description = parser.getText();
            }
        }

        parser.require(XmlPullParser.END_TAG, "", "locationlist");
        parser.next();
        Location location = new Location(uuid, name, description, createdMap);
        return location;
    }

    private static GMEdge readEdge(XmlPullParser parser, GMMap createdMap) throws XmlPullParserException, IOException
    {
        UUID uuid = null;
        String name = "";
        long distance = 0;
        GMNode start = null;
        GMNode end = null;
        Direction direction = null;
        String description = "";
        
        parser.require(XmlPullParser.START_TAG, "", "edge");
        while (parser.getName() != "edgelist")
        {
            if (parser.getEventType() != XmlPullParser.START_TAG)
            {
                parser.next();
            }
            else if (parser.getName() == "edge")
            {
                if(parser.getAttributeName(0) == "guid")
                {
                    uuid = java.util.UUID.fromString(parser.getAttributeValue(0));
                }
            }
            else if (parser.getName() == "name")
            {
                name = parser.getText();
            }
            else if (parser.getName() == "distance")
            {
                if(parser.getAttributeName(0) == "time")
                {
                    distance = Long.parseLong(parser.getAttributeValue(0));
                }
            }
            else if (parser.getName() == "start")
            {
                if(parser.getAttributeName(0) == "guid")
                {
                    start = createdMap.getNode(java.util.UUID.fromString(parser.getAttributeValue(0)));
                }
            }
            else if (parser.getName() == "end")
            {
                if(parser.getAttributeName(0) == "guid")
                {
                    end = createdMap.getNode(java.util.UUID.fromString(parser.getAttributeValue(0)));
                }
            }
            else if (parser.getName() == "direction")
            {
                direction = Direction.valueOf(parser.getText());
            }
            else if (parser.getName() == "desc")
            {
                description = parser.getText();
            }
        }
        
        parser.require(XmlPullParser.END_TAG, "", "edgelist");
        parser.next();
        GMEdge edge = new GMEdge(uuid, name, distance, start, end, direction, description, createdMap);
        return edge;
    }
}
