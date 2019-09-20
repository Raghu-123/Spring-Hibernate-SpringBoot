package com.wipro.register.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



public class ParticipantsBean 
{
	

	private String empid;
	
	

	
	private String name;
	

	private String basl;
	
	

	

	
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
