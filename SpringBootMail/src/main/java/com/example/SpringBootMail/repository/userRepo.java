package com.example.SpringBootMail.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBootMail.entity.User;

public interface userRepo extends JpaRepository<User,Integer> {

}
