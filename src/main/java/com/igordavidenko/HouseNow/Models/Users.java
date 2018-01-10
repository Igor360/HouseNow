package com.igordavidenko.HouseNow.Models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data
@EqualsAndHashCode(exclude= {"houses"})
@ToString(exclude= {"houses"})
@AllArgsConstructor
@NoArgsConstructor
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "*Введіть логін")
	@Column(name = "username", unique = true)
	private String username;
	
	@NotNull(message = "*Введіть пароль")
	@Column(name = "password") 
	private String password;
	
	@NotNull(message = "*Введіь електрону адресу")
	@Column(name  = "email", unique = true)
	private String email;
	
	@NotNull(message = "*Введіть ім'я користувача")
	@Column(name = "firstName")
	private String firstName;
	
	@NotNull(message = "*Введіть прізвище користвача")
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "role")
	private Role role;
		
	
	@OneToMany(mappedBy = "user")
	private List<Houses> houses = new ArrayList<>();

	
	public Users(String username, String password, String email, String firstName, String lastName) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
}
