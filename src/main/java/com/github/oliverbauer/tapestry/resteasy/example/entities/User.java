package com.github.oliverbauer.tapestry.resteasy.example.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	
	private String mail;
	private String name;
	private String password;
	
	public User() {

	}
	
	public User(String name, String mail) {
		this.name = name;
		this.mail = mail;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
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

	public Integer getId() {
		return this.id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", mail=" + mail + ", name=" + name
				+ ", password=" + password+"]";
	}
}
