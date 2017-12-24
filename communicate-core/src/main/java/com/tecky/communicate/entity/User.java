package com.tecky.communicate.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import com.tecky.common.model.AbstractEntity;
import com.tecky.communicate.enums.Role;

/**
 * A class representing the application user.
 * 
 * @author mekysersoze
 *
 */
@Entity
@Table(name = "`user`")
public class User extends AbstractEntity {

	private static final long serialVersionUID = 7755116203322848971L;

	@NotNull
	@Size(min = 1, max = 16, message = "{firstname.size}")
	private String firstname;

	@NotNull
	@Size(min = 1, max = 16, message = "{lastname.size}")
	private String lastname;

	@NotNull
	@Email(message = "{email.valid}")
	private String email;

	private Role role;

	@NotNull
	@Size(min = 5, max = 16, message = "{username.size}")
	private String username;

	@NotNull
	@Size(min = 8, max = 16, message = "{password.size}")
	private String password;

	public User() {
	}

	public User(String firstname, String lastname, String username) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", role=" + role
				+ ", username=" + username + ", password=" + password + "]";
	}

}
