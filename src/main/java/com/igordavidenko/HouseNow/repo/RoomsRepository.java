package com.igordavidenko.HouseNow.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igordavidenko.HouseNow.Models.Rooms;

@Repository("roomsRepository")
public interface RoomsRepository extends JpaRepository<Rooms, Long>{
	
	public List<Rooms> findRoomByName(String name);
}
