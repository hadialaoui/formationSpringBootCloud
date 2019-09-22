package com.hadialaoui.spring.jpa10step;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



@Component
public class UserDAOServiceCommandLineRunner implements CommandLineRunner {

	@Autowired
	UserDOAService userDaoService;
	
	 
	private static final Logger log = LoggerFactory.getLogger(UserDAOServiceCommandLineRunner.class);

	
	@Override
	public void run(String... args) throws Exception {
		UserMetier user1 = new UserMetier("Jack","Admin");
		userDaoService.insert(user1);
		log.info("user created");
	}

}
