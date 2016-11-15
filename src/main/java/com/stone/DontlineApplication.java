package com.stone;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DontlineApplication {

	public static void main(String[] args) {
		SpringApplication.run(DontlineApplication.class, args);

		System.out.println("Press 'Enter' to terminate");
		new Scanner(System.in).nextLine();
		System.out.println("Exiting");
		System.exit(1);
	}
}
