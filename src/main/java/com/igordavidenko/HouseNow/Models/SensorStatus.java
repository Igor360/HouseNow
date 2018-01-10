package com.igordavidenko.HouseNow.Models;

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
@EqualsAndHashCode(exclude= {"code", "sensorModes"})
@ToString(exclude= {"code", "sensorModes"})
@AllArgsConstructor
@NoArgsConstructor
public class SensorStatus {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "*Введіть назву статуса сенсора")
	@Column(name = "name", unique = true)
	private String name;
	
	@NotNull(message = "*Введіть описання")
	@Column(name = "description")
	private String dascription;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codeid")
	private StatusCode code;
	
	
	@OneToMany(mappedBy = "status")
	private List<SensorMode> sensorModes;
	
}
