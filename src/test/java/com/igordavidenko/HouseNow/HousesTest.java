package com.igordavidenko.HouseNow;



import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.igordavidenko.HouseNow.Models.HouseTypes;
import com.igordavidenko.HouseNow.Models.Houses;
import com.igordavidenko.HouseNow.Service.HouseServiceImpl;

@RunWith(SpringRunner.class)
@DataJpaTest
public class HousesTest {
	
	@Autowired 
	private HouseServiceImpl houseService;
	
	
	@Test
	public void addUserToDataBase() {
		Houses house = new Houses();
		house.setName("house1");
		house.setAddress("UA");
		HouseTypes type = new HouseTypes();
		type.setName("House");
		type.setDescription("only house");
		house.setType(type);
		houseService.saveHouse(house);		
		Assert.assertEquals("house1", houseService.findHouseByName(house.getName()).getName());	
	}
	
	@Test 
	public void deleteCreatedUserShoudReturnNull() {
		Houses house = houseService.findHouseByName("house1");
		houseService.deleteHouse(house);
		Assert.assertEquals(houseService.findHouseByName("house1"), null);
	}
	
}
