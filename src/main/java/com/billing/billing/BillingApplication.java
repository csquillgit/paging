package com.billing.billing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BillingApplication implements CommandLineRunner {

	@Autowired
	TransService tranService;

	public static void main(String[] args) {
		SpringApplication.run(BillingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		tranService.process();

		// tranService.process();
		// for (int i = 0; i < 10000; i++) {
		// Transaction t = new Transaction();
		// t.setName("test");
		// tranService.add(t);
		//
		// }

	}

}
