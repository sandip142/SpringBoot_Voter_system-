package com.example.SpringBootMail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringBootMail.entity.Election;


@Repository
public interface ElectionRepo extends JpaRepository<Election,Integer> {

}
