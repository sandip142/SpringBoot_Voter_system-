package com.example.SpringBootMail.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBootMail.entity.Voter;
import com.example.SpringBootMail.repository.VoterRepo;


@Service
public class VoterServiceImp implements VoterService {
	
	@Autowired
	VoterRepo voterRepo;

	@Override
	public String saveVoter(Voter voter) {
		voterRepo.save(voter);
		return "succesfully inserted";
	}

	@Override
	public List<Voter> voterlist() {
	    List<Voter> voterlList= voterRepo.findAll();
		return voterlList;
	}

	@Override
	public void deleteById(int id) {
	   Voter voter = voterRepo.findById(id).orElse(null);
	   voterRepo.delete(voter);
	}

	@Override
	public Voter findbyId(int id) {
	   Voter voter = voterRepo.findById(id).orElse(null);
	return voter;
	}

	@Override
	public Voter updateVoter(Voter voter,int id) {
		Optional<Voter> voterdatab = voterRepo.findById(id);
		if(voterdatab.isPresent()) {
			Voter newVoter=voterdatab.get();
			newVoter.setUsername(voter.getUsername());
			newVoter.setDob(voter.getDob());
			newVoter.setEmail(voter.getEmail());
			newVoter.setGender(voter.getGender());
			newVoter.setUsername(voter.getUsername());
			newVoter.setPassword(voter.getPassword());
			voterRepo.save(newVoter);
			return newVoter;
		}
		return null;
	}   
}
