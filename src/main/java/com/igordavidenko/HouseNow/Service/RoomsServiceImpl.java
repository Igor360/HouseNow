package com.igordavidenko.HouseNow.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igordavidenko.HouseNow.Models.Rooms;
import com.igordavidenko.HouseNow.repo.RoomsRepository;


@Service("roomService")
public class RoomsServiceImpl implements RoomsService{
	
	@Autowired
	private RoomsRepository roomRepository; 
		
	@Override
	public void saveRoom(Rooms room) {
		roomRepository.save(room);
	}
	
	@Override
	public Rooms findRoomByName(String name) {
		return roomRepository.findRoomByName(name).get(0);
	}
	
	@Override
	public List<Rooms> getAll(){
		return roomRepository.findAll();
	}
	
	@Override
	public Rooms findRoomById(Long id) {
		return roomRepository.findOne(id); 
	} 
	
	
	@Override
	public void updateRoom(Rooms room) {
		roomRepository.save(room);
	}
	
	@Override
	public void deleteRoom(Rooms room) {
		roomRepository.delete(room);
	}
	
	
}
