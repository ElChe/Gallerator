package com.trit.gallerator.data;

/**
 * POJO describing a user
 * Is unique by combination of customerId+personId
 * @author Amund
 *
 */
public class UserInfo
{
	private int personId;
	private int customerId;
	private String country;
	private int educationLevel;
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
}
