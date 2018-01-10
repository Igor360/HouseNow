package com.igordavidenko.HouseNow.Models;

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
public class HouseTypes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "*Введіть тип будинку")
	@Column(name = "name", unique = true)
	private String name;
	
	@NotNull(message = "*Введіть описання")
	@Column(name = "description")
	private String description;
	
	
	@OneToMany(mappedBy = "type")
	private List<Houses> houses;
	

}
