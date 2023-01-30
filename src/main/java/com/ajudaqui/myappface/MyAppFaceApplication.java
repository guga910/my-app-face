package com.ajudaqui.myappface;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyAppFaceApplication {

	public static void main(String[] args) {
		/*
		 * regstro com roles esta ok, agora ach que falta configura o jwtokenpara poder
		 * fazer o ligin.
		 */
		SpringApplication.run(MyAppFaceApplication.class, args);
		System.err.println("\nfoi!");
		
		
	}

}
