package com.hms.user.manage.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.hms"})
public class UsermanagementApplication {

	public static void main(String[] args) {

		SpringApplication.run(UsermanagementApplication.class, args);
	}

}
