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
@EqualsAndHashCode(exclude= {"rooms", "house"})
@ToString(exclude= {"rooms", "house"})
@AllArgsConstructor
@NoArgsConstructor
public class Floors {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "*Введіть имя поверха")
	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "floor")
	private List<Rooms> rooms = new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "houseid") 
	private Houses house;
	
	
}
