package com.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.entity.Address;
import com.springboot.entity.Users;
import com.springboot.service.UserService;

@SpringBootApplication
public class SpringbootJpaOneToOneApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaOneToOneApplication.class, args);
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
