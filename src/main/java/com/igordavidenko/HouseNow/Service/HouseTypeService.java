package com.igordavidenko.HouseNow.Service;

import java.util.List;

import com.igordavidenko.HouseNow.Models.HouseTypes;

public interface HouseTypeService {
	
	public void save(HouseTypes type);
	public void delete(HouseTypes type);
	public List<HouseTypes> findAll();
	public HouseTypes findTypeById(Long id);
}
