package com.igordavidenko.HouseNow.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igordavidenko.HouseNow.Models.HouseTypes;
import com.igordavidenko.HouseNow.repo.HouseTypesRepository;

@Service("houseTypeService")
public class HouseTypeServiceImpl implements HouseTypeService{
		
	@Autowired 
	private HouseTypesRepository houseTypeRepository;
	
	@Override
	public void save(HouseTypes type) {
		houseTypeRepository.save(type);
	}
	
	@Override
	public void delete(HouseTypes type) {
		houseTypeRepository.delete(type);
	}
	
	@Override
	public List<HouseTypes> findAll(){
		return houseTypeRepository.findAll();
	}
	
	@Override 
	public HouseTypes findTypeById(Long id) {
		return houseTypeRepository.findOne(id);
	}
}
