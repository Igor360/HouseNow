package com.igordavidenko.HouseNow.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igordavidenko.HouseNow.Models.SensorStatus;
import com.igordavidenko.HouseNow.repo.SensorStatusRepository;

@Service("sensorStatusService")
public class SensorStatusServiceImplmpl implements SensorStatusService{
	
	@Autowired
	private SensorStatusRepository sensorStatusRepository; 
	
	@Override
	public void saveSensorStatus(SensorStatus sensorStatus) {
		sensorStatusRepository.save(sensorStatus);
	}
	
	@Override
	public void deleteSensorStatus(SensorStatus sensorStatus) {
		sensorStatusRepository.delete(sensorStatus);
	}
	
	@Override
	public SensorStatus findStatusById(Long id) {
		return sensorStatusRepository.findOne(id);
	}
}
