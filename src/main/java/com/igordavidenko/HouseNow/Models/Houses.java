package com.igordavidenko.HouseNow.Models;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@EqualsAndHashCode(exclude= {"floor", "type"})
@ToString(exclude= {"floor", "type"})
@AllArgsConstructor
@NoArgsConstructor
public class Houses {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@NotNull(message = "*Введіть имя будинку")
	@Column(name = "name")
	private String name;
	
	@NotNull(message = "*Введіть адресу будинку")
	@Column(name = "address")
	private String address;
		
	
	@OneToMany(mappedBy = "house")
	private List<Floors> floor = new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid")
	private Users user;
		
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "typeid")
	private HouseTypes type;
	
	
	
	
}	
