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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data
@EqualsAndHashCode(exclude= {"mode", "rooms", "windows", "doors"})
@ToString(exclude= {"mode", "rooms", "windows", "doors"})
@AllArgsConstructor
@NoArgsConstructor
public class Sensors {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@NotNull(message = "*Введіть назву сенсора")
	@Column(name = "name", unique = true)
	private String name;
	
	@NotNull(message = "*Введіть код сеносора")
	@Column(name = "codeSensor", unique = true)
	private String codeSensor;
	
	
	@NotNull
	@Column(name = "type")
	private SensorType type;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "modeid", unique = false)
	private SensorMode mode;
	
	
	@ManyToMany(mappedBy = "sensors")
	private List<Rooms> rooms = new ArrayList<>(); 
	
	
	@ManyToMany(mappedBy = "sensor")
	private List<Windows> windows = new ArrayList<>();
	
	@ManyToMany(mappedBy = "sensor")
	private List<Door> doors = new ArrayList<>();
	
}
