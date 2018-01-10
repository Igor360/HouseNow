package com.igordavidenko.HouseNow.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igordavidenko.HouseNow.Models.Windows;
import com.igordavidenko.HouseNow.repo.WindowsRepository;

@Service("windowsService")
public class WindowsServiceImpl implements WindowsService{
		
	@Autowired
	private WindowsRepository windowRepository;
	
	@Override
	public void saveWindow(Windows window) {
		windowRepository.save(window);
	}
	
	@Override
	public void deleteWindow(Windows window) {
		windowRepository.delete(window);
	}
	
}
