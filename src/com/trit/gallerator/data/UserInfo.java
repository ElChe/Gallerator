package com.trit.gallerator.data;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

/**
 * POJO describing a user
 * Is unique by combination of customerId+personId
 * @author Amund
 *
 */
@PersistenceCapable
public class UserInfo
{
	// Generate this for new by personId_customerId
	@PrimaryKey
	private Key key;
	@Persistent
	private int personId;
	@Persistent
	private int customerId;
	@Persistent
	private String country;
	@Persistent
	private int educationLevel;
	@Persistent
	private String language;
	
	public int getEducationLevel()
	{
		return educationLevel;
	}
	public void setEducationLevel(int educationLevel)
	{
		this.educationLevel = educationLevel;
	}
	public void setPersonId(int personId)
	{
		this.personId = personId;
	}
	public int getPersonId()
	{
		return personId;
	}
	public void setCustomerId(int customerId)
	{
		this.customerId = customerId;
	}
	public int getCustomerId()
	{
		return customerId;
	}
	public void setCountry(String country)
	{
		this.country = country;
	}
	public String getCountry()
	{
		return country;
	}
	public void setLanguage(String language)
	{
		this.language = language;
	}
	public String getLanguage()
	{
		return language;
	}
	public void setKey(Key key)
	{
		this.key = key;
	}
	public Key getKey()
	{
		return key;
	}
}
