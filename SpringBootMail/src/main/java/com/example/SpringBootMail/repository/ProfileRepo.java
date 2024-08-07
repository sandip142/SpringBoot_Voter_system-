package com.example.SpringBootMail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringBootMail.entity.Profile;

@Repository
public interface ProfileRepo extends JpaRepository<Profile,Integer> {

}
