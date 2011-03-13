package com.trit.gallerator.services;

import javax.servlet.http.HttpServletRequest;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.trit.gallerator.data.GalleryInstance;
import com.trit.gallerator.data.PMF;

public class GalleryServiceImpl
{
	public GalleryInstance createNewGalleryInstance(HttpServletRequest request){
		GalleryInstance galleryInstance = new GalleryInstance();
		String userId = "1";
		String schoolId = "2";
		String instanceId = "3";
		Key k = KeyFactory.createKey(GalleryInstance.class.getSimpleName(), String.format("%s|%s|%s", userId,schoolId,instanceId));
		galleryInstance.setKey(k);
		PMF.get().getPersistenceManager().makePersistent(galleryInstance);
		return galleryInstance;
	}
	
	public GalleryInstance getGalleryInstanceByEditReference(String editReference){
		String userId = "1";
		String schoolId = "2";
		String instanceId = "3";
		Key k = KeyFactory.createKey(GalleryInstance.class.getSimpleName(), String.format("%s|%s|%s", userId,schoolId,instanceId));

		GalleryInstance galleryInstance = PMF.get().getPersistenceManager().getObjectById(GalleryInstance.class, k);
		return galleryInstance;
	}
}
