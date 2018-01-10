package com.igordavidenko.HouseNow.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igordavidenko.HouseNow.Models.StatusCode;

@Repository("statusCodeRepository")
public interface StatusCodeRepository extends JpaRepository<StatusCode, Long>{

}
