package com.decker.JqueryProvider;

import java.io.InputStream;

public class ResourceManager
{

    private ResourceManager()
    {

    }

    public static ResourceManager _Instance;

    public static ResourceManager getInstance()
    {
	if (_Instance == null)
	{
	    _Instance = new ResourceManager();
	}
	return _Instance;
    }

    public byte[] getResource(String resourceName) 
    {
	InputStream is = this.getClass().getResourceAsStream("/" + resourceName);

	try
	{
	    return sun.misc.IOUtils.readFully(is, -1, true);
	} catch (Exception e)
	{	    
	    return new byte [0];
	}

    }

}