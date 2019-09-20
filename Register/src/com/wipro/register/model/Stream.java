package com.wipro.register.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name="StreamTbl1")
public class Stream implements Serializable
{

	private static final long serialVersionUID = -723583058586873479L;
	


	@Override
	public String toString() {
		return "Stream [streamname=" + streamname + ", streamid=" + streamid
				+ ", streamdetails=" + streamdetails + ", comments=" + comments
				+ "]";
	}
	@Id
	@Column(name="streamid")
	private String streamid;

	@Column(name="streamname" ,length=10)
	private String streamname;
		@Column(name="streamdetails")
	private String streamdetails;
	@Column(name="comments")
	private String comments;
	public String getStreamname() {
		return streamname;
	}
	public void setStreamname(String streamname) {
		this.streamname = streamname;
	}
	public String getStreamid() {
		return streamid;
	}
	public void setStreamid(String streamid) {
		this.streamid = streamid;
	}
	public String getStreamdetails() {
		return streamdetails;
	}
	public void setStreamdetails(String streamdetails) {
		this.streamdetails = streamdetails;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
}