package com.example.SpringBootMail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.SpringBootMail.entity.Election;
import com.example.SpringBootMail.entity.Voter;
import com.example.SpringBootMail.repository.ElectionRepo;
import com.example.SpringBootMail.service.VoterService;
import com.example.SpringBootMail.service.emailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ElectionController {
 
	@Autowired
	ElectionRepo electionRepo;
	
	@Autowired
	private emailService emailService;
	
	@Autowired
	VoterService voterService;

	
	@GetMapping("/SceduleElection")
	public String scheduleElection(Model model) {
		model.addAttribute("election",new Election());
		return "ElectionForm";
	}
	
	@GetMapping("/electionDetails")
	public String electionDetails(Model model) {
		model.addAttribute("home", model);
		return "Election";
	}
	
	@PostMapping("/setElection")
	public String createElection(@ModelAttribute("election") Election election) {
		System.out.println(election);
		String date=election.geteDate().toString();
		String description= election.getDescription();
		List<Voter> voters = voterService.voterlist();
		if(election!=null) {
		  electionRepo.save(election);
		  for(Voter voter:voters) {
				String email = voter.getEmail();
				emailService.sendEmail(email,"Update Regarding Election of Date:-"+date,description+"\n"+"date:-"+date);
			}
			return "welcome";
		}	else {
			return "ElectionForm";
		}
	}
	
}
