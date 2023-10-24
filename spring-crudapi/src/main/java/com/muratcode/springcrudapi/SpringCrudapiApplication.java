package com.muratcode.springcrudapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringCrudapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCrudapiApplication.class, args);
	}

}
