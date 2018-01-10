package com.igordavidenko.HouseNow.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igordavidenko.HouseNow.Models.HouseTypes;

@Repository("houseTypesRepository")
public interface HouseTypesRepository extends JpaRepository<HouseTypes, Long>{
	public HouseTypes findHouseTypeById(Integer id);
}
