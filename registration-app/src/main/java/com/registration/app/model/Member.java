package com.registration.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import com.sun.istack.NotNull;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = "email") })
public class Member {

	@Id
	@Column(length = 36)
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(strategy = "uuid", name = "uuid2")
	private String id;

	@NotEmpty
	@Size(min = 2, max = 255)
	private String name;

	@NotEmpty
	@Size(min = 2, max = 255)
	@Email
	private String email;

	@NotNull
	private Boolean emailVerification = false;

	public Member() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEmailVerification() {
		return emailVerification;
	}

	public void setEmailVerification(Boolean emailVerification) {
		this.emailVerification = emailVerification;
	}
}
