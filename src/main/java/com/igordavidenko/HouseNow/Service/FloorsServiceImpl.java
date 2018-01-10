package com.igordavidenko.HouseNow.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igordavidenko.HouseNow.Models.Floors;
import com.igordavidenko.HouseNow.Models.Houses;
import com.igordavidenko.HouseNow.repo.FloorsRepository;

@Service("floorsService")
public class FloorsServiceImpl implements FloorService{
		
	@Autowired
	FloorsRepository floorRepository;
	
	
	@Override
	public void saveFloor(Floors floor) {
		floorRepository.save(floor);
	}
	
	@Override 
	public Floors findFloorByName(String name) {
		return floorRepository.findFloorByName(name).get(0);
	}
	
	@Override
	public List<Floors> getAll(){
		return floorRepository.findAll();
	}
	
	
	@Override
	public Floors findFloorById(Long id) {
		return floorRepository.findOne(id);
	}
	
	@Override 
	public List<Floors> getFloorByHouse(Houses house){
		return floorRepository.findFloorByHouse(house);
	}
	
	
	@Override 
	public void deleteFloor(Floors floor) {
		floorRepository.delete(floor);
	}
}
