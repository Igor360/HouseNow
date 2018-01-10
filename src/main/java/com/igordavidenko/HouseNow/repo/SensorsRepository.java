package com.igordavidenko.HouseNow.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igordavidenko.HouseNow.Models.SensorType;
import com.igordavidenko.HouseNow.Models.Sensors;

@Repository("sensorsRepository")
public interface SensorsRepository extends JpaRepository<Sensors, Long>{
	
	public List<Sensors> findSensorByType(SensorType type);
}
