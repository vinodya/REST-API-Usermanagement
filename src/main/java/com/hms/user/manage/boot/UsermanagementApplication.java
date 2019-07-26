package com.hms.user.manage.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.hms.user.manage.domain", "com.hms.user.manage.rest","com.hms.user.manage.repository"})
public class UsermanagementApplication {

	public static void main(String[] args) {

		SpringApplication.run(UsermanagementApplication.class, args);
	}

}
