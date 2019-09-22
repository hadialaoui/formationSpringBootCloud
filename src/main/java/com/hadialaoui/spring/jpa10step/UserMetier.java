package com.hadialaoui.spring.jpa10step;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserMetier {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String role;
	
	
	
	public UserMetier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserMetier(String role) {
		super();
			this.role = role;
	}
	public UserMetier(Long id, String role) {
		super();
		this.id = id;
		this.role = role;
	}
	
	public UserMetier(String name, String role) {
		super();
		this.name = name;
		this.role = role;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
