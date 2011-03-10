package com.trit.gallerator.data;

import javax.jdo.PersistenceManager;


public class ImagePersistenceManagerImpl implements ImagePersistenceManager {

	@Override
	public ImageData getImageById(long id) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		ImageData imageData = pm.getObjectById(ImageData.class, id);
		return imageData;
	}

	/*
	 * Stores ImageData object and returns Key
	 * @see com.trit.gallerator.data.ImagePersistenceManager#storeImageData(com.trit.gallerator.data.ImageData)
	 */
	@Override
	public long storeImageData(ImageData imageData) {
	/*	PersistenceManager pm = PMF.get().getPersistenceManager();
		pm.makePersistent(imageData);
		return imageData.getId();*/
		return -1; // TODO
	}

}
