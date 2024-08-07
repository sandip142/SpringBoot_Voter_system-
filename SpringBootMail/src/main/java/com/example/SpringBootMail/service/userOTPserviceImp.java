package com.example.SpringBootMail.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class userOTPserviceImp implements userOTPService {

	@Override
	public String generateOpt(String username) {
		
		 Random random = new Random();
	       int otp =100000+random.nextInt(999999);
	       String value =String.valueOf(otp);
			return value;
	}

}
