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

import com.igordavidenko.HouseNow.Models.HouseTypes;
import com.igordavidenko.HouseNow.Models.Houses;
import com.igordavidenko.HouseNow.Models.Users;
import com.igordavidenko.HouseNow.Service.HouseServiceImpl;
import com.igordavidenko.HouseNow.Service.HouseTypeServiceImpl;
import com.igordavidenko.HouseNow.Service.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class HousesTest {
	
	@Autowired 
	private HouseServiceImpl houseService;
	
	@Autowired 
	private UserServiceImpl userService;
	
	@Autowired 
	private HouseTypeServiceImpl houseTypeService;

	@Before
	public void addUserToDataBase() {

		Houses house = new Houses();
		house.setName("house1");
		house.setAddress("UA");
		
		HouseTypes type = new HouseTypes();
		type.setName("House1");
		type.setDescription("only house");
		houseTypeService.save(type);
		
		Users user = new Users("user1","12344", "email@email1.com", "ivan", "ivanov");
		userService.saveUser(user);
		
		Users userSaved = userService.findUserById(1L);
		HouseTypes typeSaved = houseTypeService.findTypeById(1L);
		
		house.setUser(userSaved);
		house.setType(typeSaved);
		houseService.saveHouse(house);		
	}
	
	@Test
	public void deleteCreatedUserShoudReturnNull() {
		Assert.assertEquals("house1", houseService.findHouseById(1L).getName());	
		Houses house = houseService.findHouseById(1L);
		houseService.deleteHouse(house);
		Assert.assertEquals(houseService.findHouseById(1L), null);
	}
	
}
