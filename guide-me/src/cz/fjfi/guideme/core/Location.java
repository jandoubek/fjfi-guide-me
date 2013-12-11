package cz.fjfi.guideme.core;
import java.util.UUID;
/**
 * This class represents location in map of GuideMe app. It provides basic getters
 * and setters for its atributes.
 * @author
 * @version
 */
public class Location
{
//== CLASS CONSTANTS ===========================================================
//== CLASS VARIABLES ===========================================================
//== INSTANCE VARIABLES ========================================================
	private UUID guid;
	private String name;
	private String description;
	private GMMap myMap;

//==============================================================================
//== CONSTRUCTORS ==============================================================
    
    /***************************************************************************
     * TODO: comment
     */
    //TODO: constructor parameters and body
    public Location(UUID guid, String name, String description, GMMap myMap)
	{
		this.guid = guid;
		this.name = name;
		this.description = description;
		this.myMap = myMap;
	}
    
//== GETTERS AND SETTERS =======================================================
    
    /***************************************************************************
     * TODO: comment
     */
    //TODO: body
    public final UUID getGUID()
    {
    	return this.guid;
    }
    
    /***************************************************************************
     * TODO: comment
     */
    //TODO: body
    public final String getName()
    {
    	return this.name;
    }
    
    /***************************************************************************
     * TODO: comment
     */
    //TODO: body
    public final String getDescription()
    {
    	return this.description;
    }
    
    /***************************************************************************
     * TODO: comment
     */
    //TODO: body
    protected final GMMap getMyMap()
    {
    	return this.myMap;
    }
    
    /***************************************************************************
     * TODO: comment
     */
    //TODO: body
    public final void setGUID(UUID newGUID)
    {
    	this.guid = newGUID;
    }
    
    /***************************************************************************
     * TODO: comment
     */
    //TODO: body
    public final void setName(String newName)
    {
    	this.name = newName;
    }
    
    /***************************************************************************
     * TODO: comment
     */
    //TODO: body
    public final void setDescription(String newDescription)
    {
    	this.description = newDescription;
    }
    
//== OTHER METHODS =============================================================
    
    /***************************************************************************
     * TODO: comment
     */
    //TODO: body
    public StringBuilder exportXML()
    {
    	StringBuilder sb = new StringBuilder();
    	sb.append("        <location guid=\"" + this.getGUID() + "\">\n");
    	sb.append("            <name>" + this.getName() + "</name>\n");
    	sb.append("            <desc>" + this.getDescription() + "</desc>\n");
    	sb.append("        </location>\n");
    	return sb;
    }
}
