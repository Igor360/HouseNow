package com.igordavidenko.HouseNow.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igordavidenko.HouseNow.Models.SensorMode;

@Repository("sensorModeRepository")
public interface SensorModeRepository extends JpaRepository<SensorMode, Long>{

}
