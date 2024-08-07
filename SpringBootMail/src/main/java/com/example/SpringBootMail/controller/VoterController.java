package com.example.SpringBootMail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.SpringBootMail.entity.Voter;
import com.example.SpringBootMail.repository.VoterRepo;
import com.example.SpringBootMail.service.AdminSevice;
import com.example.SpringBootMail.service.VoterService;
import com.example.SpringBootMail.service.emailService;
import com.example.SpringBootMail.service.userOTPService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class VoterController {
	@Autowired
    private VoterService voterService; 
	
	@Autowired
	private emailService emailService;
	
	@Autowired
	private userOTPService userOTPService;
	
	@Autowired
	private VoterRepo voterRepo;
	
	int id;
	Voter oldVoter;
	String otp;
	String email;
	@GetMapping("/voter")
	public String postMethodName(Model model) {
		model.addAttribute("voter",new Voter());
		return "VoterSignup";
	}
	
	
	@GetMapping("/Vlogin")
	public String voter(Model model) {
		model.addAttribute("voter",new Voter());
		return "VoterLogin";
	}
	
	
	
	@PostMapping("/votersignup")
	public String VoterSignup(@ModelAttribute("voter") Voter voter,Model model) {
		oldVoter =voter;
		email= voter.getEmail();
		System.out.println(email);
		otp=userOTPService.generateOpt(email);
		System.out.println(otp);
		emailService.sendEmail(email,"Hey Applicant","OTP:- "+otp);
	
		model.addAttribute("voter",new Voter());
		id=voter.getId();
		return "voterotp";
	}
	
	@PostMapping("/verifyotp")
	public String VerifyOtpAndRegis(@RequestParam("otp") String sopt ){
		System.out.println("template otp:-"+sopt);
		if(sopt.equals(otp)) {
			voterService.saveVoter(oldVoter);
			return "VoterLogin";
		}
		else {
			return "voterotp";
		}
	}	
	
	@PostMapping("/voterlogin")
	public String voterLogin(@RequestParam("email") String Vemail, @RequestParam("password") String Vpassword, Model model) {
	    List<Voter> voters = voterService.voterlist();
	    for (Voter voter : voters) {
	        if (voter.getEmail().equals(Vemail) && voter.getPassword().equals(Vpassword)) {
	            id = voter.getId(); // Ensure 'id' is properly initialized and accessible
	            model.addAttribute("voter", voter);
	            System.out.println("Successfully logged in: " + voter);
	            return "VoterDashBord"; // Make sure this matches the template name
	        }
	    }
	    return "VoterLogin"; // Return to the login page if authentication fails
	}

//	@GetMapping("/voterdashbord")
//	public String VoterDashbord(Model model) {
//	    Voter voter = voterService.findbyId(id);
//	    if (voter == null) {
//	        System.out.println("Voter not found with id: " + id);
//	        return "VoterLogin";
//	    }
//	    model.addAttribute("voter", voter);
//	    System.out.println("Voter dashboard loaded for: " + voter);
//	    return "VoterDashBord"; // Make sure this matches the template name
//	}
	@GetMapping("/updatePage")
	public String onupdatepage(Model model) {
		model.addAttribute("voter",new Voter());
		return "VoterUpdate";
	}
	
	
	@PostMapping("/updateVoter")
    public String updateVoter(@ModelAttribute("voter") Voter voter, Model model) {
        voterService.updateVoter(voter, id);
        model.addAttribute("voter", voter);
        return "VoterDashBord";
    }

    @GetMapping("/deleteVoter")
    public String deleteVoter() {
        voterService.deleteById(id);
        return "VoterLogin";
    }
	
   

}
	   	
	

