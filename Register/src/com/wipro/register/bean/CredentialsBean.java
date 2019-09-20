package com.wipro.register.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

//import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="credentials")
public class CredentialsBean 
{

	@Id
	@Column(name="userid")
	//@NotEmpty(message="UserID cannot be null")
	private String userid;

	@Column(name="password")
	//@NotEmpty(message="password cannot be null")
	private String password;

	@Column(name="usertype")
	private String usertype;

	@Column(name = "Loginstatus")
	private int loginStatus;
	
	@Transient
	//@NotEmpty(message="new password cannot be null")
	private String newpassword;


	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public int getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(int loginStatus) {
		this.loginStatus = loginStatus;
	}



	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	@Override
	public String toString()
	{
		return "LoginBean [username=" + userid + ", password=" + password
				+ ", usertype=" + usertype + "]";
	}
}
