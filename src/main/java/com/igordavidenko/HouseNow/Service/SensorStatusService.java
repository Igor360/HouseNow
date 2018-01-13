package com.igordavidenko.HouseNow.Service;

import com.igordavidenko.HouseNow.Models.SensorStatus;

public interface SensorStatusService {

		public void saveSensorStatus(SensorStatus sensor);
		public void deleteSensorStatus(SensorStatus sensor);
		public SensorStatus findStatusById(Long id);
}
