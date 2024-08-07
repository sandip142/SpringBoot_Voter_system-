package com.example.SpringBootMail.service;

import org.springframework.stereotype.Service;

@Service
public interface userOTPService {
	public String generateOpt(String username);
}
