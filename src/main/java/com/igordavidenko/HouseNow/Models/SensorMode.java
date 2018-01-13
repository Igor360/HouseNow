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
@EqualsAndHashCode(exclude= {"sensors", "status"})
@ToString(exclude= {"sensors", "status"})
@AllArgsConstructor
@NoArgsConstructor
public class SensorMode {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "*Введіть назву стану сенсорв")
	@Column(name = "name", unique = true)
	private String name;
	
	@NotNull(message = "*Введіть описання")
	@Column(name = "description")
	private String description;
		
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "statusid")
	private SensorStatus status;
	
	
	@OneToMany(mappedBy = "mode")
	private List<Sensors> sensors =  new ArrayList<>();
	
}
