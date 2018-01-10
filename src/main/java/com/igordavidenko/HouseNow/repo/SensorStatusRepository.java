package com.igordavidenko.HouseNow.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igordavidenko.HouseNow.Models.SensorStatus;

@Repository("sensorStatusRepository")
public interface SensorStatusRepository extends JpaRepository<SensorStatus, Long>{

}
