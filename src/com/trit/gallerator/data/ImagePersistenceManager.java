package com.trit.gallerator.data;

/**
 * Interface for persisting images
 * @author Amund
 *
 */
public interface ImagePersistenceManager {

	public ImageData getImageById(long id);
	public long storeImageData(ImageData imageData);
}
