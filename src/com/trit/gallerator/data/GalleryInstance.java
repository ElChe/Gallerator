package com.trit.gallerator.data;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * The data of one gallerysession, i.e. the add/edit of the plugin instance
 * @author Amund
 *
 */
public class GalleryInstance {

	// Generate this for new, use in EditReference to lookup existing instances.
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@PrimaryKey
	private Long instanceId;
	
	// List of imageData
	private List<ImageData> images = new ArrayList<ImageData>();
	
	/**
	 * Returns editReference for use on the post
	 * @return
	 */
	public String GetEditReference(){
		return "instanceId="+instanceId;
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
}
