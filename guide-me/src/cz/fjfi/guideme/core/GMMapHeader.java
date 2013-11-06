package cz.fjfi.guideme.core;

import java.util.UUID;

/**
 * This class represents the header of a map in the GuideMe app.
 * @author  Martin Sochor
 */
public class GMMapHeader
{
    private UUID guid;
    private String name;
    private String authorName;
    private String authorEmail;
    private String description;
    private String filename;

    /**
     * TODO: Comment
     */
    public GMMapHeader()
    {
    }

    /**
     * TODO: Comment
     * @return the guid
     */
    public UUID getGuid()
    {
        return guid;
    }

    /**
     * TODO: Comment
     * @param guid the guid to set
     */
    public void setGuid(UUID guid)
    {
        this.guid = guid;
    }

    /**
     * TODO: Comment
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * TODO: Comment
     * @param name the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * TODO: Comment
     * @return the authorName
     */
    public String getAuthorName()
    {
        return authorName;
    }

    /**
     * TODO: Comment
     * @param authorName the authorName to set
     */
    public void setAuthorName(String authorName)
    {
        this.authorName = authorName;
    }

    /**
     * TODO: Comment
     * @return the authorEmail
     */
    public String getAuthorEmail()
    {
        return authorEmail;
    }

    /**
     * TODO: Comment
     * @param authorEmail the authorEmail to set
     */
    public void setAuthorEmail(String authorEmail)
    {
        this.authorEmail = authorEmail;
    }

    /**
     * TODO: Comment
     * @return the description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * TODO: Comment
     * @param description the description to set
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * TODO: Comment
     * @return the filename
     */
    public String getFilename()
    {
        return filename;
    }

    /**
     * TODO: Comment
     * @param filename the filename to set
     */
    public void setFilename(String filename)
    {
        this.filename = filename;
    }
}