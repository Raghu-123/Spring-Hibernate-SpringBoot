package com.wipro.register.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="UserCredentials")
public class ProfileBean 
{
@Id
@Column(name="username",length=10)
private String username;

@Override
public String toString()
{
	return "RegisterBean [username=" + username + ", emailid=" + emailid
			+ ", contactno=" + contactno + ", password=" + password + "]";
}
@Column(name="emailid",length=10)
private String emailid;
@Column(name="contactno",length=10)
private String contactno;
@Column(name="password",length=10)
private String password;
@Column(name="studentid",length=10)
private String studentid;

public String getStudentid() {
	return studentid;
}
public void setStudentid(String studentid) {
	this.studentid = studentid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
public String getContactno() {
	return contactno;
}
public void setContactno(String contactno) {
	this.contactno = contactno;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
