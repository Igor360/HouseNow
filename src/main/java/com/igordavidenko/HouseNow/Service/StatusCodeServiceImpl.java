package com.igordavidenko.HouseNow.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igordavidenko.HouseNow.Models.StatusCode;
import com.igordavidenko.HouseNow.repo.StatusCodeRepository;

@Service("statusCodeService")
public class StatusCodeServiceImpl implements StatusCodeService{
	
	@Autowired
	private StatusCodeRepository statusCodeRepository; 
	
	
	@Override
	public void saveStatusCode(StatusCode statusCode) {
		statusCodeRepository.save(statusCode);
	}
	
	@Override
	public void deleteStatusCode(StatusCode statusCode) {
		statusCodeRepository.delete(statusCode);
	}
	
	

}

