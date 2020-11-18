package com.gasser.fullstackpruefung;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FullstackPruefungApplication {
	
	//server port ist 8085, weil mein 8080 bereits belegt ist
	
	public static void main(String[] args) {
		SpringApplication.run(FullstackPruefungApplication.class, args);
	}
	
}
