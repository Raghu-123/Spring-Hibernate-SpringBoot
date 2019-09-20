package com.wipro.register.bean;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

public class ModuleBean 
{

	
	
	private String subjectid;

	
	
	private String subjecttitle;
	
	
	String description;
	
	
	double duration;

	
	String comments;

	public String getSubjectid() {
		return subjectid;
	}

	public void setSubjectid(String subjectid) {
		this.subjectid = subjectid;
	}

	public String getSubjecttitle() {
		return subjecttitle;
	}

	public void setSubjecttitle(String subjecttitle) {
		this.subjecttitle = subjecttitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}



}
