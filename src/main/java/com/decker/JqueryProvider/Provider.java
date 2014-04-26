package com.decker.JqueryProvider;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Provider extends org.sipc.se.plugin.PluginImpl
{

    @Override
    public void getResponse(HttpServletRequest request, HttpServletResponse response)
    {
	String url = request.getRequestURI();
	String target = url.substring(url.indexOf("Jquery") + "Jquery".length() + 1);

	try
	{
	    byte[] resource = ResourceManager.getInstance().getResource("Content/"+target);
	    OutputStream stream = response.getOutputStream();
	    
	    

	    if (resource.length == 0)
	    {
		response.setStatus(404);
	    }

	    stream.write(resource);

	} catch (IOException e)
	{
	   
	}

    }

    @Override
    public String getUrl()
    {
	return "Jquery";
    }

    @Override
    public boolean onEnable()
    {
	return true;
    }

}
