package com.trit.gallerator.services;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServletRequest;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.trit.gallerator.data.GalleryInstance;
import com.trit.gallerator.data.PMF;

public class GalleryServiceImpl
{
	private PersistenceManager pm = PMF.get().getPersistenceManager();
	public GalleryInstance createNewGalleryInstance(HttpServletRequest request){
		GalleryInstance galleryInstance = new GalleryInstance();
		String userId = "1";
		String schoolId = "2";
		String instanceId = "3";
		Key k = KeyFactory.createKey(GalleryInstance.class.getSimpleName(), String.format("%s|%s|%s", userId,schoolId,instanceId));
		galleryInstance.setKey(k);
		try{
			pm.makePersistent(galleryInstance);
		}
		finally{
			pm.close();
		}
		return galleryInstance;
	}
	
	public GalleryInstance getGalleryInstanceByEditReference(String editReference){
		String userId = "1";
		String schoolId = "2";
		String instanceId = "3";
		Key k = KeyFactory.createKey(GalleryInstance.class.getSimpleName(), String.format("%s|%s|%s", userId,schoolId,instanceId));
		GalleryInstance galleryInstance;
		try{
			galleryInstance = pm.getObjectById(GalleryInstance.class, k);
		}
		finally{
			pm.close();
		}
		
		return galleryInstance;
	}
}
