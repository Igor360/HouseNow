package com.igordavidenko.HouseNow.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igordavidenko.HouseNow.Models.Floors;
import com.igordavidenko.HouseNow.Models.Houses;
import com.igordavidenko.HouseNow.repo.HousesRepository;

@Service("houseService")
public class HouseServiceImpl implements HouseService{
		
	@Autowired
	public HousesRepository houseRepository;
	
	@Override
	public Houses findHouseByName(String name) {
		return houseRepository.findByName(name).get(0); 
	}
	
	@Override
	public void saveHouse(Houses house) {
		System.out.println(house);
		houseRepository.save(house);
	}
	
	@Override
	public Houses findHouseById(Long id) {
		return houseRepository.findOne(id);
	}
	
	@Override
	public Houses findHouseByFloor(Floors floor) {
		return houseRepository.findOneByFloor(floor);
	}
	
	@Override 
	public void deleteHouse(Houses house) {
		houseRepository.delete(house);
	}
	
	@Override
	public List<Houses> findAll(){
		return houseRepository.findAll();
	}
}
