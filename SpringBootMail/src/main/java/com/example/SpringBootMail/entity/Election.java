package com.example.SpringBootMail.entity;

import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "election_table")
public class Election {
	@Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int eid;
   private String ename;
   private String state;
   private Date eDate;
   private String description;
public Election(int eid, String ename, String state, Date eDate, String description) {
	super();
	this.eid = eid;
	this.ename = ename;
	this.state = state;
	this.eDate = eDate;
	this.description = description;
}
public Election() {
	super();
	// TODO Auto-generated constructor stub
}
public int getEid() {
	return eid;
}
public void setEid(int eid) {
	this.eid = eid;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public Date geteDate() {
	return eDate;
}
public void seteDate(Date eDate) {
	this.eDate = eDate;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
@Override
public String toString() {
	return "Election [eid=" + eid + ", ename=" + ename + ", state=" + state + ", eDate=" + eDate + ", description="
			+ description + "]";
}
   
   
   
   
}
