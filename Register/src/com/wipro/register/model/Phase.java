package com.wipro.register.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="CPC_Phases")
public class Phase implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="phaseid")
	String phaseid;
	
	@Column(name="phaseDescription")
	String phaseDescription;
	
	@Column(name="duration")
	int duration;
	
	@Column(name="assessmentDate")
	Date assessmentDate;
	
	@Column(name="remarks")
	String remarks;
	
	@ManyToMany
	@JoinTable(name = "cpc_phases_modules", 
			joinColumns = @JoinColumn(name = "phaseid"), 
			inverseJoinColumns = @JoinColumn(name = "moduleid"))
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	Set<Module> modules=new HashSet<Module>();
	
	
//	@ManyToMany
//	@JoinTable(name = "cpc_phases_projects", 
//			joinColumns = @JoinColumn(name = "phaseid"), 
//			inverseJoinColumns = @JoinColumn(name = "projectid"))
//	@Cascade(org.hibernate.annotations.CascadeType.ALL)
//	Set<Project> projects=new HashSet<Project>();

	
//	@ManyToMany
//	@JoinTable(name="cpc_streams_phases", 
//	    joinColumns={@JoinColumn(name="phaseid")},
//	    inverseJoinColumns={@JoinColumn(name="streamid")})
//	List<Stream> streams=new ArrayList<Stream>();
	public Phase(){
		
	}
	
//	 @OneToMany(mappedBy = "phase",
//	            cascade = CascadeType.ALL)
//	 @Column
//	    @ElementCollection(targetClass=CPC_Report.class)
//	Set<CPC_Report> cpcReports=new HashSet<CPC_Report>();
//	
//	public Set<CPC_Report> getCpcReports() {
//		return cpcReports;
//	}
//
//
//
//	public void setCpcReports(Set<CPC_Report> cpcReports) {
//		this.cpcReports = cpcReports;
//	}
//	

	public Phase(String phaseDescription, int duration, Date assessmentDate,
			String remarks, Set<Module> modules) {
		super();
		this.phaseDescription = phaseDescription;
		this.duration = duration;
		this.assessmentDate = assessmentDate;
		this.remarks = remarks;
		this.modules = modules;
	}



	public String getPhaseid() {
		return phaseid;
	}

	public void setPhaseid(String phaseid) {
		this.phaseid = phaseid;
	}

	public String getPhaseDescription() {
		return phaseDescription;
	}

	public void setPhaseDescription(String phaseDescription) {
		this.phaseDescription = phaseDescription;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Date getAssessmentDate() {
		return assessmentDate;
	}

	public void setAssessmentDate(Date assessmentDate) {
		this.assessmentDate = assessmentDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Set<Module> getModules() {
		return modules;
	}

	public void setModules(Set<Module> modules) {
		this.modules = modules;
	}



//	public List<Stream> getStreams() {
//		return streams;
//	}
//
//
//
//	public void setStreams(List<Stream> streams) {
//		this.streams = streams;
//	}
//
//
//
//	public Set<Project> getProjects() {
//		return projects;
//	}
//
//
//
//	public void setProjects(Set<Project> projects) {
//		this.projects = projects;
//	}
//
//
	public Phase(String phaseid) {
		super();
		this.phaseid = phaseid;
	}



	

}
