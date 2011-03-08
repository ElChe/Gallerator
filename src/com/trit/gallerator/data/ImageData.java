package com.trit.gallerator.data;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


public class ImageData {
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;
	
	private String servingUrl;

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

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
