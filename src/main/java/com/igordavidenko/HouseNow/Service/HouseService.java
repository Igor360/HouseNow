package com.igordavidenko.HouseNow.Service;


import com.igordavidenko.HouseNow.Models.Floors;
import com.igordavidenko.HouseNow.Models.Houses;

public interface HouseService {

	public Houses findHouseByName(String name);
	public Houses findHouseById(Long id);
	public void saveHouse(Houses house);
	public Houses findHouseByFloor(Floors floor);
	public void deleteHouse(Houses house);
}
