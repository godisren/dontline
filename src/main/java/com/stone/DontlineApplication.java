package com.stone;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DontlineApplication {
	
	@RequestMapping("/")
    String home() {
        return "hello dont line";
    }

	public static void main(String[] args) {
		SpringApplication.run(DontlineApplication.class, args);
		
		System.out.println("Press 'Enter' to terminate");
        new Scanner(System.in).nextLine();
        System.out.println("Exiting");
        System.exit(1);
	}
}
