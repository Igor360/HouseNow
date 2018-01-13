package com.igordavidenko.HouseNow;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.igordavidenko.HouseNow.Models.SensorMode;
import com.igordavidenko.HouseNow.Models.SensorStatus;
import com.igordavidenko.HouseNow.Models.SensorType;
import com.igordavidenko.HouseNow.Models.Sensors;
import com.igordavidenko.HouseNow.Models.StatusCode;
import com.igordavidenko.HouseNow.Service.SensorModeServiceImpl;
import com.igordavidenko.HouseNow.Service.SensorServiceImpl;
import com.igordavidenko.HouseNow.Service.SensorStatusServiceImplmpl;
import com.igordavidenko.HouseNow.Service.StatusCodeServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class SensorsTest {
	
	@Autowired 
	private SensorServiceImpl sensorService;
	
	@Autowired
	private SensorModeServiceImpl sensorModeService;
	
	@Autowired
	private SensorStatusServiceImplmpl sensorStatusService;
	
	@Autowired
	private StatusCodeServiceImpl statusCodeService; 
	
	@Before
	public void createSensor() {
		
		StatusCode statusCode = new StatusCode();
		statusCode.setCode(212112);
		statusCode.setDescription("null");
		statusCode.setName("code1");
		statusCodeService.saveStatusCode(statusCode);
		
		SensorStatus sensorStatus = new SensorStatus();
		sensorStatus.setDascription("null");
		sensorStatus.setName("Status2");
		sensorStatus.setCode(statusCodeService.findCodeById(1L));
		sensorStatusService.saveSensorStatus(sensorStatus);
		
		SensorMode sensorMode = new SensorMode();
		sensorMode.setDescription("null");
		sensorMode.setName("Mode1");
		sensorMode.setStatus(sensorStatusService.findStatusById(1L));
		
		sensorModeService.saveSensorMode(sensorMode);
		
		
		Sensors sensor = new Sensors();
		sensor.setName("sensor1");
		sensor.setType(SensorType.DOOR);
		sensor.setCodeSensor("3233424");
		sensor.setMode(sensorModeService.findModeById(1L));
		
		sensorService.saveSensor(sensor);
	
	}
	
	@Test
	public void test() {
		Assert.assertEquals(sensorService.findSensorById(1L).getName(), "sensor1");
		Assert.assertEquals(sensorModeService.findModeById(1L).getName(), "Mode1");
		Assert.assertEquals(sensorStatusService.findStatusById(1L).getName(), "Status2");
		Assert.assertEquals(statusCodeService.findCodeById(1L).getName(), "code1");
		sensorService.deleteSensor(sensorService.findSensorById(1L));
		sensorModeService.deleteSensorMode(sensorModeService.findModeById(1L));
		sensorStatusService.deleteSensorStatus(sensorStatusService.findStatusById(1L));
		statusCodeService.deleteStatusCode(statusCodeService.findCodeById(1L));
		Assert.assertNull(sensorService.findSensorById(1L));
		Assert.assertNull(sensorModeService.findModeById(1L));
		Assert.assertNull(sensorStatusService.findStatusById(1L));
		Assert.assertNull(statusCodeService.findCodeById(1L));
	}
	
	

}
