package com.example.SpringBootMail.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.SpringBootMail.entity.Admin;

@Service
public interface AdminSevice {
   public void saveAdmin(Admin admin);
   
  public List<Admin> admins= null;
  
  public String AdminUpdate(int id,Admin admin);
  
}
