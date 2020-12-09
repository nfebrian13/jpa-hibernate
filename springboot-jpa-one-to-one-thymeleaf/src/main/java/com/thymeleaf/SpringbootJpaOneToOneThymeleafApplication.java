package com.thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.thymeleaf.entity.Address;
import com.thymeleaf.entity.Users;
import com.thymeleaf.service.UserService;

@SpringBootApplication
public class SpringbootJpaOneToOneThymeleafApplication implements CommandLineRunner {
	
	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaOneToOneThymeleafApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// create a user instance
		Users user = new Users("John Doe", "john.doe@example.com", "1234abcd");

		// create an address instance
		Address address = new Address("Lake View 321", "Berlin", "Berlin", "95781", "DE");

		// set child reference
		address.setUser(user);

		// set parent reference
		user.setAddress(address);

		// save the parent
		// which will save the child (address) as well
		userService.save(user);
	}
}
