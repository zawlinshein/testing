package com.user;

public class User {
	private int id;
	private String name;
	private String password;
	private String location;
	private String email;
	
	public User(int id, String name, String password, String location, String email) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.location = location;
		this.email = email;
	}
	public User(String name, String password, String location, String email) {
		this.name = name;
		this.password = password;
		this.location = location;
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", location=" + location + ", email="
				+ email + "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
