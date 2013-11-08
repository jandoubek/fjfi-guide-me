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
    public static GMMap loadMap(File fileName)
    {
        InputStream in = null;
        try
        {
            in = new FileInputStream(fileName);
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in, null);
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
                if (in != null)
                    in.close();
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
                uuid = java.util.UUID.fromString(parser.getText());
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

    private static GMEdge readEdge(XmlPullParser parser, GMMap createdMap)
    {
        return null;
    }
}
