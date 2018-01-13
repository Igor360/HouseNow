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
@EqualsAndHashCode(exclude= {"sensorStatus"})
@ToString(exclude= {"sensorStatus"})
@AllArgsConstructor
@NoArgsConstructor
public class StatusCode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@NotNull(message = "*Введіть назву коду")
	@Column(name = "name", unique = true)
	private String name;
	
	@NotNull(message = "*Введіть описання")
	@Column(name = "description")
	private String description;
	
	@NotNull(message = "*Введіть код статусу")
	@Column(name = "code")
	private Integer code;
	
	
	@OneToMany(mappedBy = "code")
	private  List<SensorStatus> sensorStatus = new ArrayList<>();
	
}
