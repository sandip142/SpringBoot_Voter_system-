package com.example.SpringBootMail.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBootMail.entity.Admin;
import com.example.SpringBootMail.entity.Voter;
import com.example.SpringBootMail.repository.AdminRepo;

@Service
public class AdminServiceImp implements AdminSevice {
    @Autowired
    AdminRepo adminRepo;

	@Override
	public void saveAdmin(Admin admin) {
			adminRepo.save(admin);	
	}

	@Override
	public String AdminUpdate(int id, Admin admin) {
		Optional<Admin> adminbyid = adminRepo.findById(id);
		if(adminbyid.isPresent()) {
			Admin newAdmin=adminbyid.get();
			newAdmin.setUsername(admin.getUsername());
			newAdmin.setDob(admin.getDob());
			newAdmin.setEmail(admin.getEmail());
			newAdmin.setGender(admin.getGender());
			newAdmin.setAddress(admin.getAddress());
			newAdmin.setPassword(admin.getPassword());
			adminRepo.save(newAdmin);
			return "succesfully update";
		}
		return "not update try again";	
	}
    
    
}
