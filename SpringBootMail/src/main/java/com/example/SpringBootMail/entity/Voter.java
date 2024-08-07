package com.example.SpringBootMail.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


@Entity
public class Voter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	@NotBlank(message = "Name cannot be empty")
	@Size(min=4,max=8,message = "Name should have 4 to 8 character")
	@Pattern(regexp = "^[a-zA-z]+$",message = "only character is allowed")
    private String voterName;
    private Date dob;
    private String gender;
    private String username;
    @Email
    private String email;
    private String password;
    
    
	public Voter() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Voter(int id,
			@NotBlank(message = "Name cannot be empty") @Size(min = 4, max = 8, message = "Name should have 4 to 8 character") @Pattern(regexp = "^[a-zA-z]+$", message = "only character is allowed") String voterName,
			Date dob, String gender, String username, @Email String email, String password) {
		super();
		this.id = id;
		this.voterName = voterName;
		this.dob = dob;
		this.gender = gender;
		this.username = username;
		this.email = email;
		this.password = password;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getVoterName() {
		return voterName;
	}


	public void setVoterName(String voterName) {
		this.voterName = voterName;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
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


	@Override
	public String toString() {
		return "Voter [id=" + id + ", voterName=" + voterName + ", dob=" + dob + ", gender=" + gender + ", username="
				+ username + ", email=" + email + ", password=" + password + "]";
	}
    
    
    
    
}
