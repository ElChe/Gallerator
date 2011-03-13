package com.trit.gallerator.services;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.repackaged.org.json.JSONArray;
import com.google.appengine.repackaged.org.json.JSONObject;
import com.trit.gallerator.data.GalleryInstance;
import com.trit.gallerator.data.ImageData;
import com.trit.gallerator.data.PMF;
import com.trit.gallerator.web.utils.RequestHelper;

public class ImageService extends ServerResource
{
	String editReference;

	@Get
	public String GetImages()
	{
		this.editReference = (String) getRequestAttributes().get(RequestHelper.EditReference);
		try
		{
			this.editReference = URLDecoder.decode(this.editReference, "UTF-8");
		} catch (UnsupportedEncodingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GalleryInstance galleryInstance = new GalleryServiceImpl().getGalleryInstanceByEditReference(editReference);
		List<JSONObject> jsonList = new ArrayList<JSONObject>();

		for (ImageData img : galleryInstance.getImages()){
			jsonList.add(new JSONObject(img));
		}
		/*
		ImageData imageData = new ImageData();
		imageData.setServingUrl("http://farm6.static.flickr.com/5211/5515072779_54c76f4279_m.jpg");*/
		//test.add(new JSONObject(imageData));
		JSONArray array = new JSONArray(jsonList);
		
		return array.toString();

	}

}
