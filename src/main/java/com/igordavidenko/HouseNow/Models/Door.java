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
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data
@EqualsAndHashCode(exclude= {"sensor", "room"})
@ToString(exclude= {"sensor", "room"})
@AllArgsConstructor
@NoArgsConstructor
public class Door {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "*Введіть назву двері")
	@Column(name = "name")
	private String name;
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "door_sensors",
     joinColumns = @JoinColumn(name = "door_id"),
     inverseJoinColumns = @JoinColumn(name = "sensor_id"))
	private List<Sensors> sensor = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roomid")
	private Rooms room;
}
	