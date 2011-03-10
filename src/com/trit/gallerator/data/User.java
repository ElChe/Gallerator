package com.trit.gallerator.data;

public class User
{
	private int userId;
	private int schoolId;
	private int EducationLevel;
	
	public int getUserId()
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	public int getSchoolId()
	{
		return schoolId;
	}
	public void setSchoolId(int schoolId)
	{
		this.schoolId = schoolId;
	}
	public int getEducationLevel()
	{
		return EducationLevel;
	}
	public void setEducationLevel(int educationLevel)
	{
		EducationLevel = educationLevel;
	}
}
