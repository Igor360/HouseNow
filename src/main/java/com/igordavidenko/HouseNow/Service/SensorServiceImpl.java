package com.igordavidenko.HouseNow.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igordavidenko.HouseNow.Models.SensorType;
import com.igordavidenko.HouseNow.Models.Sensors;
import com.igordavidenko.HouseNow.repo.SensorsRepository;

@Service("sensorService")
public class SensorServiceImpl implements SensorsService{

	@Autowired
	private SensorsRepository sensorRepository;
	
	@Override
	public void saveSensor(Sensors sensor) {
		sensorRepository.save(sensor);
	}

	@Override
	public List<Sensors> findSensorByType(SensorType type){
		return sensorRepository.findSensorByType(type);
	}
	
	@Override
	public List<Sensors> findAll(){
		return sensorRepository.findAll();
	}
	
	@Override
	public void deleteSensor(Sensors sensor) {
		sensorRepository.delete(sensor);
	}
	
	@Override
	public Sensors findSensorById(Long id) {
		return sensorRepository.findOne(id);
	}
}
