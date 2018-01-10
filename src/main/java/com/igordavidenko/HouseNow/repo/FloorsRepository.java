package com.igordavidenko.HouseNow.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igordavidenko.HouseNow.Models.Floors;
import com.igordavidenko.HouseNow.Models.Houses;

@Repository("floorsRepository")
public interface FloorsRepository extends JpaRepository<Floors, Long>{
	
	public List<Floors> findFloorByName(String name);
	public List<Floors> findFloorByHouse(Houses house);
	public List<Floors> findFloorById(Long id);
}
