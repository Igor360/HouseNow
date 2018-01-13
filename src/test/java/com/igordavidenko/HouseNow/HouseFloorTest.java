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

import com.igordavidenko.HouseNow.Models.Floors;
import com.igordavidenko.HouseNow.Models.HouseTypes;
import com.igordavidenko.HouseNow.Models.Houses;
import com.igordavidenko.HouseNow.Models.Rooms;
import com.igordavidenko.HouseNow.Models.Users;
import com.igordavidenko.HouseNow.Service.FloorsServiceImpl;
import com.igordavidenko.HouseNow.Service.HouseServiceImpl;
import com.igordavidenko.HouseNow.Service.HouseTypeServiceImpl;
import com.igordavidenko.HouseNow.Service.RoomsServiceImpl;
import com.igordavidenko.HouseNow.Service.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class HouseFloorTest {

	@Autowired 
	private FloorsServiceImpl floorService;
	
	@Autowired
	private RoomsServiceImpl roomService;
	
	
	@Autowired 
	private HouseServiceImpl houseService;
	
	@Autowired 
	private UserServiceImpl userService;
	
	@Autowired 
	private HouseTypeServiceImpl houseTypeService;
	
	@Before
	public void prepeareData() {
		
		Houses house = new Houses();
		house.setName("house1");
		house.setAddress("UA");
		
		HouseTypes type = new HouseTypes();
		type.setName("House");
		type.setDescription("only house");
		houseTypeService.save(type);
		
		Users user = new Users("user","12344", "email@email.com", "ivan", "ivanov");
		userService.saveUser(user);
		
		Users userSaved = userService.findUserById(1L);
		HouseTypes typeSaved = houseTypeService.findTypeById(1L);
		
		house.setUser(userSaved);
		house.setType(typeSaved);
		houseService.saveHouse(house);	

		Floors floor = new Floors();
		floor.setHouse(houseService.findHouseById(1L));
		floor.setName("floor1");
		floorService.saveFloor(floor);

		Rooms room = new Rooms();
		room.setName("room");
		room.setFloor(floorService.findFloorById(1L));
		roomService.saveRoom(room);
	}
	
	@Test
	public void test() {
		Assert.assertEquals("floor1", floorService.findFloorById(1L).getName());
		Assert.assertEquals("room", roomService.findRoomById(1L).getName());
		//houseService.deleteHouse(houseService.findHouseById(1L));
		//houseTypeService.delete(houseTypeService.findTypeById(1L));
		//userService.deleteUser(userService.findUserById(1L));
		roomService.deleteRoom(roomService.findRoomById(1L));
		floorService.deleteFloor(floorService.findFloorById(1L));
		Assert.assertEquals(floorService.findFloorById(1L), null);
		Assert.assertEquals(roomService.findRoomById(1L), null);
		
	}
	
}
