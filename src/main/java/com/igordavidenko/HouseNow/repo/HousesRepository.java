package com.igordavidenko.HouseNow.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igordavidenko.HouseNow.Models.Floors;
import com.igordavidenko.HouseNow.Models.Houses;
import com.igordavidenko.HouseNow.Models.Users;

@Repository("housesRepository")
public interface HousesRepository extends JpaRepository<Houses, Long> {
	public List<Houses> findByName(String name);
	public List<Houses> findByUser(Users user);
	public Houses findOneByFloor(Floors floor);
}
