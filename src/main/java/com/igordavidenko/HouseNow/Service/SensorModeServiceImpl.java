package com.igordavidenko.HouseNow.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igordavidenko.HouseNow.Models.SensorMode;
import com.igordavidenko.HouseNow.repo.SensorModeRepository;

@Service("sensorModeService")
public class SensorModeServiceImpl implements SensorModeService{
	
	@Autowired
	private SensorModeRepository sensorModeRepository;

	@Override 
	public void saveSensorMode(SensorMode sensorMode) {
		sensorModeRepository.save(sensorMode);
	}
	
	@Override 
	public void deleteSensorMode(SensorMode sensorMode) {
		sensorModeRepository.delete(sensorMode);
	}
	
	
	@Override
	public SensorMode findModeById(Long id) {
		return sensorModeRepository.findOne(id);
	}
}
