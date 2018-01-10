package com.igordavidenko.HouseNow.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igordavidenko.HouseNow.Models.Windows;

@Repository("windowsRepository")
public interface WindowsRepository extends JpaRepository<Windows, Long>{

}
