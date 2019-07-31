package com.hms.user.manage.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * UsermanagementApplication class includes
 * the main. By running this class we can
 * start the web service. Since this class
 * is in a separate package(boot) we had to
 * import other packages as follows.
 *
 * @version 1.8
 * @author Vinodya Samarasinghe
 */
@SpringBootApplication(scanBasePackages = { "com.hms.user.manage.domain", "com.hms.user.manage.rest","com.hms.user.manage.repository"})
public class UsermanagementApplication {

	/**
	 * main method to start the web service.
	 */
	public static void main(String[] args) {

		SpringApplication.run(UsermanagementApplication.class, args);
	}

}
