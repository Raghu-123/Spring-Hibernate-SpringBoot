package com.wipro.register.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



public class PhaseBean 
{
	
	private String phaseid;
	private String phasedescription;
	Date assessmentDate;
	private int duration;
	private String remarks;
	
	
	

	public String getPhaseid() 
	{
		return phaseid;
	}

	public void setPhaseid(String phaseid)
	{
		this.phaseid = phaseid;
	}

	public String getPhasedescription()
	{
		return phasedescription;
	}

	public void setPhasedescription(String phasedescription) 
	{
		this.phasedescription = phasedescription;
	}

	public Date getAssessmentDate() 
	{
		return assessmentDate;
	}

	public void setAssessmentDate(Date assessmentDate)
	{
		this.assessmentDate = assessmentDate;
	}

	public int getDuration()
	{
		return duration;
	}

	public void setDuration(int duration)
	{
		this.duration = duration;
	}

	public String getRemarks()
	{
		return remarks;
	}

	public void setRemarks(String remarks) 
	{
		this.remarks = remarks;
	}

}
