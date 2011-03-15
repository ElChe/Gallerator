package com.trit.gallerator.data;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

/**
 * The data of one gallerysession, i.e. the add/edit of the plugin instance
 * @author Amund
 *
 */
@PersistenceCapable
public class GalleryInstance {

	// Generate this for new, use in EditReference to lookup existing instances.
	@PrimaryKey
	private Key key;
	
	// List of imageData
	@Persistent
	private List<ImageData> images = new ArrayList<ImageData>();
	
	@Persistent
	private UserInfo user;
	/**
	 * Returns editReference for use on the post
	 * @return
	 */
	public String GetEditReference(){
		return getKey().getName();
	}

	/**
	 * @param images the images to set
	 */
	public void setImages(List<ImageData> images) {
		this.images = images;
	}

	/**
	 * @return the images
	 */
	public List<ImageData> getImages() {
		return images;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(Key key) {
		this.key = key;
	}

	/**
	 * @return the key
	 */
	public Key getKey() {
		return key;
	}

	public void setUser(UserInfo user)
	{
		this.user = user;
	}

	public UserInfo getUser()
	{
		return user;
	}
}
