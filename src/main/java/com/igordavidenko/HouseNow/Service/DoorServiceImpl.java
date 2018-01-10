package com.igordavidenko.HouseNow.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igordavidenko.HouseNow.Models.Door;
import com.igordavidenko.HouseNow.repo.DoorsRepository;

@Service("doorService")
public class DoorServiceImpl implements  DoorService{
	
	@Autowired 
	private DoorsRepository doorRepository;
	
	@Override
	public void saveDoor(Door door) {
		doorRepository.save(door);
	}
	
	@Override
	public void deleteDoor(Door door) {
		doorRepository.delete(door);
	}
	
}
