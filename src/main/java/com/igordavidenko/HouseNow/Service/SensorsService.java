package com.igordavidenko.HouseNow.Service;

import java.util.List;

import com.igordavidenko.HouseNow.Models.SensorType;
import com.igordavidenko.HouseNow.Models.Sensors;

public interface SensorsService {
	public void saveSensor(Sensors sensor);
	public List<Sensors> findSensorByType(SensorType type);
	public List<Sensors> findAll();
	public void deleteSensor(Sensors sensor);
	public Sensors findSensorById (Long id);
 }
