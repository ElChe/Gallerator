package com.trit.gallerator.services;

import javax.servlet.http.HttpServletRequest;

import com.trit.gallerator.data.GalleryInstance;

public interface GalleryService
{

	public abstract GalleryInstance createNewGalleryInstance(
			HttpServletRequest request);

	public abstract GalleryInstance getGalleryInstanceByEditReference(
			String editReference);

	public abstract void persist(Object o);
	
	public abstract void InitializeSession(HttpServletRequest request);

}