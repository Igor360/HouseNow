package com.igordavidenko.HouseNow.Service;

import java.util.List;

import com.igordavidenko.HouseNow.Models.Floors;
import com.igordavidenko.HouseNow.Models.Houses;

public interface FloorService {

	public Floors findFloorByName(String name);
	public List<Floors> getAll();
	public void saveFloor(Floors floor);
	public Floors findFloorById(Long id);
	public List<Floors> getFloorByHouse(Houses house);
	public void deleteFloor(Floors floor); 

}
