package com.example.SpringBootMail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringBootMail.entity.Voter;

@Repository
public interface VoterRepo extends JpaRepository<Voter,Integer> {

}
