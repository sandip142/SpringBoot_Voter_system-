package com.example.SpringBootMail.entity;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="admin_table")
public class Admin {
	
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  
  @NotBlank(message = "Name cannot be empty")
  @Size(min=4,max=8,message = "Name should have 4 to 8 character")
  @Pattern(regexp = "^[a-zA-z]+$",message = "only character is allowed")
  private String username;
  private String email;
  private String gender;
  private String address;
  private Date dob; 
  private String password;

  public Admin() {
	super();
  }

  public Admin(int id, String username, String gender, String address, Date dob, String password, String email) {
	super();
	this.id = id;
	this.username = username;
	this.gender = gender;
	this.address = address;
	this.dob = dob;
	this.password = password;
	this.email = email;
  }

  public String getEmail() {
	return email;
  }

  public void setEmail(String email) {
	this.email = email;
  }

  public String getPassword() {
	return password;
  }

  public void setPassword(String password) {
	this.password = password;
  }

  public int getId() {
	return id;
  }

  public void setId(int id) {
	this.id = id;
  }

  public String getUsername() {
	return username;
  }

  public void setUsername(String username) {
	this.username = username;
  }

  public String getGender() {
	return gender;
  }

  public void setGender(String gender) {
	this.gender = gender;
  }

  public String getAddress() {
	return address;
  }

  public void setAddress(String address) {
	this.address = address;
  }

  public Date getDob() {
	return dob;
  }

  public void setDob(Date dob) {
	this.dob = dob;
  }
  
  
}
