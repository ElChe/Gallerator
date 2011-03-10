package com.trit.gallerator.data;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class ImageData {
	
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;

	@Persistent
	private String servingUrl;

	/**
	 * @param servingUrl the servingUrl to set
	 */
	public void setServingUrl(String servingUrl) {
		this.servingUrl = servingUrl;
	}

	/**
	 * @return the servingUrl
	 */
	public String getServingUrl() {
		return servingUrl;
	}
}
