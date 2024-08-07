package com.example.SpringBootMail.service;

import java.util.List;

import com.example.SpringBootMail.entity.Voter;


public interface VoterService {
    
	public String saveVoter(Voter voter);
	public List<Voter> voterlist();
	public void deleteById(int id);
	public Voter findbyId(int id);
	public Voter updateVoter(Voter voter,int id);
}
