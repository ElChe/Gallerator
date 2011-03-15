package com.trit.gallerator.services;

import java.util.UUID;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServletRequest;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.trit.gallerator.data.GalleryInstance;
import com.trit.gallerator.data.PMF;
import com.trit.gallerator.data.UserInfo;
import com.trit.gallerator.web.utils.RequestHelper;

public class GalleryServiceImpl implements GalleryService
{
	private PersistenceManager pm;

	public GalleryServiceImpl()
	{
		pm = PMF.get().getPersistenceManager();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.trit.gallerator.services.GallerySercive#createNewGalleryInstance(
	 * javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public GalleryInstance createNewGalleryInstance(HttpServletRequest request)
	{
		GalleryInstance galleryInstance = new GalleryInstance();
		
		UserInfo user = new UserInfo();
		user.setPersonId( Integer.parseInt(request.getParameter(RequestHelper.PersonId)));
		user.setCustomerId( Integer.parseInt(request.getParameter(RequestHelper.CustomerId)));
		Key userKey = KeyFactory.createKey(UserInfo.class.getSimpleName(),
				String.format("%s|%s", user.getCustomerId(), user.getPersonId()));
		user.setKey(userKey);
		
		galleryInstance.setUser(user);
		// TODO more properties for user
		
		
		Key k = KeyFactory.createKey(GalleryInstance.class.getSimpleName(),
				String.format("%s|%s|%s", user.getCustomerId(), user.getPersonId(), UUID.randomUUID().toString()));
		galleryInstance.setKey(k);
		pm.makePersistent(galleryInstance);

		return galleryInstance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.trit.gallerator.services.GallerySercive#getGalleryInstanceByEditReference
	 * (java.lang.String)
	 */
	@Override
	public GalleryInstance getGalleryInstanceByEditReference(
			String editReference)
	{
		Key k = KeyFactory.createKey(GalleryInstance.class.getSimpleName(), editReference);
		GalleryInstance galleryInstance;
		try
		{
			galleryInstance = pm.getObjectById(GalleryInstance.class, k);
		} finally
		{
			// pm.close();
		}

		return galleryInstance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.trit.gallerator.services.GallerySercive#persist(java.lang.Object)
	 */
	@Override
	public void persist(Object o)
	{
		pm.makePersistent(o);
	}

	public void InitializeSession(HttpServletRequest request)
	{
		String editReference = request
				.getParameter(RequestHelper.EditReference);
		if (editReference != null && !editReference.isEmpty())
		{
			// We have a previous stored GalleryInstance
			getGalleryInstanceByEditReference(editReference);
		} else
		{
			// Create a new GalleryInstance, and get the reference
			GalleryInstance instance = createNewGalleryInstance(request);
			editReference = instance.GetEditReference();
		}
		request.getSession().setAttribute(RequestHelper.EditReference, editReference);
	}
}
