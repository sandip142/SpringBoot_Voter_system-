package com.example.SpringBootMail.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBootMail.entity.Admin;

public interface AdminRepo extends JpaRepository<Admin,Integer>{
   
}
