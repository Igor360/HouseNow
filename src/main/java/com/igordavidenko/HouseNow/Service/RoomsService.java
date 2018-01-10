package com.igordavidenko.HouseNow.Service;

import java.util.List;

import com.igordavidenko.HouseNow.Models.Rooms;

public interface RoomsService {
	
	public void saveRoom(Rooms room);
	
	public Rooms findRoomByName(String name);
	
	public List<Rooms> getAll();
	
	public Rooms findRoomById(Long id);
	
	public void updateRoom (Rooms room);
	
	public void deleteRoom (Rooms room);
}
