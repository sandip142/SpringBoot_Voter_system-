package com.example.SpringBootMail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.SpringBootMail.entity.Admin;
import com.example.SpringBootMail.entity.Election;
import com.example.SpringBootMail.entity.Voter;
import com.example.SpringBootMail.repository.AdminRepo;
import com.example.SpringBootMail.service.AdminSevice;
import com.example.SpringBootMail.service.VoterService;
import com.example.SpringBootMail.service.emailService;
import com.example.SpringBootMail.service.userOTPService;

import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class AdminController {
	@Autowired
	private emailService emailService;
  
	@Autowired
	AdminRepo adminRepo;
	
	@Autowired
	AdminSevice adminSevice;
	
	@Autowired
	userOTPService userOTPService;
	
	@Autowired
	VoterService voterService;
	
	String oldememail;
	Admin oldAdmin;
	String otp;
	int id;
	
	
	@GetMapping("/Home")
	public String HomePage(Model model) {
		model.addAttribute("home", model);
		return "HomePage";
	}
	
	@GetMapping("/saveAdmin")
	public String SaveAdmin(Model model) {
		model.addAttribute("admin",new Admin());
		return "AdminSignup";
	}
	
	@GetMapping("/loginApi")
	public String loginpage(Model model) {
		model.addAttribute("admin",new Admin());
		return "AdminLogin";
	}
	
	@GetMapping("/welcomepage")
	public String welcomepage(Model model) {
		model.addAttribute("home", model);
		return "welcome";
	}
	
	@GetMapping("/updateAdmin")
	public String UpdateAdmin(Model model) {
		model.addAttribute("admin",new Admin());
		return "AdminUpdate";
	}
	
	@GetMapping("/OwnDetails")
	public String OwnDetails(Model model) {
		model.addAttribute("home", model);
		return "AdminDetail";
	}
	

	
	@PostMapping("/Register")
	public String getAdminStatus(@ModelAttribute("admin") Admin admin) {
		oldAdmin=admin;
		String email=admin.getEmail();
		System.out.println(email);
		otp=userOTPService.generateOpt(email);
		System.out.println(otp);
		emailService.sendEmail(email,"this is your OTP", otp);
		
//		adminSevice.saveAdmin(admin);	
		return "OTPpage";
	}
	
	@PostMapping("/verifyregis")
	public String getOTPverify(@RequestParam("otp") String sotp) {
		if(sotp.equals(otp)&&oldAdmin!=null){
			adminSevice.saveAdmin(oldAdmin);
			oldAdmin=null;
			System.out.println("your email is verify succesfully");
			return "AdminLogin";	
		}
		
		return "OTPpage";
	}
	
	
   @PostMapping("/adminlogin")
   public String AdminLogin(@RequestParam("email") String Aemail,@RequestParam("password") String Apassword,Model model) {
	   int count=0;
	   System.out.println(Aemail+" "+Apassword);
	  List<Admin> adminlist= adminRepo.findAll();
	  for(Admin admin:adminlist) {
		  if(admin.getEmail().equals(Aemail)&&admin.getPassword().equals(Apassword)) {
			  count++;
		      id = admin.getId();
		  }
	  }
	  
	  System.out.println(count);
	  if(count>0) {
//		   List<Voter> voterlist= voterService.voterlist();
//		   System.out.println(voterlist);
//	       model.addAttribute("voters",voterlist);
	       return "redirect:/welcomepage";
	  }
	  return "AdminLogin"; 
   }
   
   @GetMapping("/dashboard")
   public String showDashboard(Model model) {
	   List<Voter> voterlist= voterService.voterlist();
	   System.out.println(voterlist);
       model.addAttribute("voters",voterlist);
       return "AdminDashBoard";
   }
   
   @PostMapping("/deleteVoterfromAdmin")
   public String deleteVoter(@RequestParam("id") Integer id) {
	   Voter voter = voterService.findbyId(id);
	   String email= voter.getEmail();
	   System.out.println(email);
	   emailService.sendEmail(email,"Update Regarding Your Profile","because of some issue regarding your Profile Your not eligible for Voting please fill It again with Appropriat details");
       voterService.deleteById(id);
       return "redirect:/dashboard";
   }
   
   @PostMapping("/VerifyfromAdmin")
   public String verifyVoters(@RequestParam("id") Integer id) {
	   Voter voter = voterService.findbyId(id);
	   String email= voter.getEmail();
	   System.out.println(email);
	   emailService.sendEmail(email,"Update Regarding Your Profile","We check You your Verified user");
	   System.out.println("your verified Voter");
	   return "redirect:/dashboard";
   }
   
   @GetMapping("/displayadmin")
   public String AdminDetails(Model model) {
	   Admin admin = adminRepo.findById(id).orElse(null);
	   if(admin!=null) {
		   model.addAttribute("admin", admin);
		   return "AdminDetail";
	   }
	   return "welcome";
   }
   
   
   //update Admin Api
   @PostMapping("/AdminReload")
   public String updateadmin(@ModelAttribute("admin") Admin admin) {
       adminSevice.AdminUpdate(id, admin);
       return "redirect:/displayadmin";
   }
   
}
