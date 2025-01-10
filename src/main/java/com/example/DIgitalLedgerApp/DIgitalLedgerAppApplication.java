package com.example.DIgitalLedgerApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class DIgitalLedgerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DIgitalLedgerAppApplication.class, args);
	}

}
