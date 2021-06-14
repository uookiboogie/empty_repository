package com.yedom;

import java.sql.Date;

public class Employee {
	private String birthdate;
	private String lastname;
	private String firstname;
	private String title;
	
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Employee() {}
	public Employee(String birthdate, String lastname, String firstname, String title) {
		super();
		this.birthdate = birthdate;
		this.lastname = lastname;
		this.firstname = firstname;
		this.title = title;
	}
	@Override
	public String toString() {
		return "Employees [birthdate=" + birthdate + ", lastname=" + lastname + ", firstname=" + firstname + ", title="
				+ title + "]";
	}
	
}
