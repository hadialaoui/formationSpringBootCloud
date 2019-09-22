package com.hadialaoui.stream;

import java.util.Arrays;
import java.util.List;



import com.hadialaoui.spring.jpa10step.UserMetier;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<UserMetier> users = Arrays.asList(
		new UserMetier("Abdelhakim", "Amdin"),
		new UserMetier("Youssef", "Amdin"),
		new UserMetier("Sara", "Acountant")
				);
		
		users.stream()
		.filter(user -> user.getName().startsWith("A"))
		.forEach(user -> System.out.println(user.getRole()));

	}

}
