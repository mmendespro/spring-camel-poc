package net.local.poc.department.service;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.local.poc.department.service.repository.InitRepository;

@SpringBootApplication
public class Application implements ApplicationRunner {

	private final InitRepository dbInitializer;

	public Application(InitRepository dbInitializer) {
		this.dbInitializer = dbInitializer;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		dbInitializer.initMemoryDatabase();
	}

}