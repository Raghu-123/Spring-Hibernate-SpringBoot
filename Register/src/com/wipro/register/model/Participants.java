package com.wipro.register.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Participants")

public class Participants  implements Serializable
{
	
	private static final long serialVersionUID = -723583058586873479L;
	

	@Id
	@Column(name="empid")
	private String empid;
	
	

	@Column(name="name")
	private String name;
	
	
	@Column(name="basl")
	private String basl;
	
	

	

	@Column(name="email")
	private String email;


	public String getEmpid() {
		return empid;
	}


	public void setEmpid(String empid) {
		this.empid = empid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}





	public String getBasl() {
		return basl;
	}


	public void setBasl(String basl) {
		this.basl = basl;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
	


}
