package com.igordavidenko.HouseNow.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igordavidenko.HouseNow.Models.Door;

@Repository("doorRepository")
public interface DoorsRepository extends  JpaRepository<Door, Long>{

}
