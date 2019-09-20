package com.wipro.register.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="modules2")
public class Module implements Serializable
{
	private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@Column(name="subjectid",length=10)
//	@GeneratedValue(strategy=GenerationType.AUTO)
	//@GeneratedValue(generator="Subjectid",strategy=GenerationType.AUTO)
	private String subjectid;

	
	@Column(name="subjecttitle",length=10)
	private String subjecttitle;
	
	@Column(name = "DESCRIPTION",length=10)
	String description;
	
	@Column(name = "DURATION",length=10)
	double duration;

	@Column(name = "COMMENTS",length=10)
	String comments;

	@ManyToMany
	@JoinTable(name="cpc_phases_modules", 
	    joinColumns={@JoinColumn(name="moduleid", insertable=false)},
	    inverseJoinColumns={@JoinColumn(name="phaseid", insertable=false)})
	List<Phase> phases=new ArrayList<Phase>();
	
public Module(){
		
	}

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

public List<Phase> getPhases() {
	return phases;
}

public void setPhases(List<Phase> phases) {
	this.phases = phases;
}
	
}
