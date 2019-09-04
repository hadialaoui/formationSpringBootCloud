package com.hadialaoui.spring.versioning;

public class Name {
    private String firstName;
    private String lastname;
    
	public Name() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Name(String firstName, String lastname) {
		super();
		this.firstName = firstName;
		this.lastname = lastname;
	}


	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
    
    
}
