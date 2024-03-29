package com.shep.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository repository;


	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Student id 101 -> {}", repository.findById(101L));
		logger.info("All users 1 -> {}", repository.findAll());
		logger.info("Inserting -> {}", repository.save(new Student("Johnny", "PD123453534")));
		logger.info("Update 101 -> {}", repository.save(new Student(1001L, "Name-Updated", "New-Passport")));
		logger.info("All users 2 -> {}", repository.findAll());
	}

	public void addPerson(){

	}
}
