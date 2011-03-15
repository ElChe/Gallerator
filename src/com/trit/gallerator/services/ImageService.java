package com.trit.gallerator.services;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import com.google.appengine.repackaged.org.json.JSONArray;
import com.google.appengine.repackaged.org.json.JSONObject;
import com.trit.gallerator.data.GalleryInstance;
import com.trit.gallerator.data.ImageData;
import com.trit.gallerator.web.utils.RequestHelper;

/**
 * ImageService is a service to retrieve images by GalleryInstances. Used
 * internally by the page to get it through ajax after each upload click since
 * we don't do a reload of the page when uploading
 * 
 * @author Amund
 * 
 */
public class ImageService extends ServerResource
{
	String editReference;

	@Get
	public String GetImages()
	{
		this.editReference = (String) getRequestAttributes().get(
				RequestHelper.EditReference);
		try
		{
			this.editReference = URLDecoder.decode(this.editReference, "UTF-8");
		} catch (UnsupportedEncodingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try
		{
			GalleryInstance galleryInstance = new GalleryServiceImpl()
					.getGalleryInstanceByEditReference(editReference);
			List<JSONObject> jsonList = new ArrayList<JSONObject>();

			for (ImageData img : galleryInstance.getImages())
			{
				jsonList.add(new JSONObject(img));
			}
			JSONArray array = new JSONArray(jsonList);

			return array.toString();
		} catch (Exception e)
		{
			// TODO
		}
		return "";

	}

}
