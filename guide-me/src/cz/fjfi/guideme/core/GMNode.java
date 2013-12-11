package cz.fjfi.guideme.core;

import java.util.UUID;
import java.util.List;

/**
 * This class represents node in map of GuideMe app. It provides getters and
 * setters for its attributes.
 * 
 * @author
 * @version
 */
public class GMNode
{
    // == CLASS CONSTANTS
    // ===========================================================
    // == CLASS VARIABLES
    // ===========================================================
    // == INSTANCE VARIABLES
    // ========================================================
    private UUID guid;
    private String name;
    private List<UUID> locations;
    private String description;
    private GMMap myMap;

    // ==============================================================================
    // == CONSTRUCTORS
    // ==============================================================

    /***************************************************************************
     * TODO: comment
     */
    // TODO: constructor parameters and body
    public GMNode(UUID guid, String name, List<UUID> locations,
            String description, GMMap myMap)
    {
        this.guid = guid;
        this.name = name;
        this.locations = locations;
        this.description = description;
        this.myMap = myMap;
    }

    // == GETTERS AND SETTERS
    // =======================================================

    /***************************************************************************
     * Getter of guid
     */
    public final UUID getGUID()
    {
        return this.guid;
    }

    /***************************************************************************
     * Getter of name
     */
    public final String getName()
    {
        return this.name;
    }

    /***************************************************************************
     * Getter of locations
     */
    public final List<UUID> getLocations()
    {
        return this.locations;
    }

    /***************************************************************************
     * Getter of description
     */
    public final String getDescription()
    {
        return this.description;
    }

    /***************************************************************************
     * Getter of map
     */
    final GMMap getMyMap()
    {
        return this.myMap;
    }

    /***************************************************************************
     * Setter of guid
     */
    public final void setGUID(UUID newGUID)
    {
        this.guid = newGUID;
    }

    /***************************************************************************
     * Setter of name
     */
    public final void setName(String newName)
    {
        this.name = newName;
    }

    /***************************************************************************
     * Setter of locations
     */
    public final void setLocations(List<UUID> newLocations)
    {
        this.locations = newLocations;
    }

    /***************************************************************************
     * Setter of description
     */
    public final void setDescription(String newDescription)
    {
        this.description = newDescription;
    }

    // == OTHER METHODS
    // =============================================================
    /***************************************************************************
     * Function for exporting all Node parameters into XML format
     */
    public StringBuilder exportXML()
    {
    	StringBuilder sb = new StringBuilder();
        sb.append("        <node guid=\"" + this.getGUID() + "\">\n");
        sb.append("            <name>" + this.getName() + "</name>\n");
        sb.append("            <desc>" + this.getDescription() + "</desc>\n");
        sb.append("            <locs>\n");
        for (UUID loc : this.locations)
        {
        	sb.append("                <loc guid=\"" + loc.toString() + "\" />\n");
        }
        sb.append("            </locs>\n" + "</node>\n");
        return sb;
    }
}
