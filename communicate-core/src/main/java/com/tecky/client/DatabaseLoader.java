package com.tecky.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tecky.communicate.entity.User;
import com.tecky.communicate.enums.Role;
import com.tecky.communicate.repository.UserRepository;

@Component
public class DatabaseLoader implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setEmail("ss@gmail.com");
		user.setFirstname("malek");
		user.setLastname("majouli");
		user.setUsername("sssslkjl");
		user.setRole(Role.ADMIN);
		user.setPassword("passmllddd");
		userRepository.save(user);

		List<User> list = userRepository.findAll();

		for (User currUser : list) {
			System.out.println("user: " + currUser.toString());
		}

	}

}
