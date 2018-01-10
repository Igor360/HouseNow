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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@EqualsAndHashCode(exclude= {"windows", "doors", "floor", "sensors"})
@ToString(exclude= {"windows", "doors", "floor", "sensors"})
@AllArgsConstructor
@NoArgsConstructor
public class Rooms {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "*Введіть назву кімнати")
	@Column(name = "name")
	private String name;
	

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "room_sensors",
     joinColumns = @JoinColumn(name = "room_id"),
     inverseJoinColumns = @JoinColumn(name = "sensor_id"))
	private List<Sensors> sensors = new ArrayList<>();
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "floorid")
	private Floors floor;


	@OneToMany(mappedBy = "room")
	private List<Windows> windows = new ArrayList<>();
	

	@OneToMany(mappedBy = "room")
	private List<Door> doors = new ArrayList<>();
}
