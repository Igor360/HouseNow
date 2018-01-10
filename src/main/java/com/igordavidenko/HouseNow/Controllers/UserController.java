package com.igordavidenko.HouseNow.Controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.igordavidenko.HouseNow.Models.Door;
import com.igordavidenko.HouseNow.Models.Floors;
import com.igordavidenko.HouseNow.Models.Houses;
import com.igordavidenko.HouseNow.Models.Rooms;
import com.igordavidenko.HouseNow.Models.SensorType;
import com.igordavidenko.HouseNow.Models.Sensors;
import com.igordavidenko.HouseNow.Models.Users;
import com.igordavidenko.HouseNow.Models.Windows;
import com.igordavidenko.HouseNow.Service.DoorServiceImpl;
import com.igordavidenko.HouseNow.Service.FloorsServiceImpl;
import com.igordavidenko.HouseNow.Service.HouseServiceImpl;
import com.igordavidenko.HouseNow.Service.RoomsServiceImpl;
import com.igordavidenko.HouseNow.Service.SensorServiceImpl;
import com.igordavidenko.HouseNow.Service.UserServiceImpl;
import com.igordavidenko.HouseNow.Service.WindowsServiceImpl;
import com.igordavidenko.HouseNow.repo.HouseTypesRepository;

@Controller
@RequestMapping("/user")
public class UserController {
		
	
	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private HouseServiceImpl houseService;
	
	@Autowired
	private FloorsServiceImpl floorService;
	
	
	@Autowired 
	private HouseTypesRepository houseTypesRepository;
	
	
	@Autowired
	private SensorServiceImpl sensorService;
	
	
	@Autowired 
	private RoomsServiceImpl roomsService;
	
	@Autowired
	private WindowsServiceImpl windowService;
	
	@Autowired
	private DoorServiceImpl doorService;
	
	@RequestMapping("/house/info")
	public ModelAndView houseInfo(@RequestParam("house") Long id) {
		ModelAndView modelAndView = new ModelAndView("user/house_info");
		modelAndView.addObject("house", houseService.findHouseById((id))); 
		return modelAndView;
	}
	
	

	@RequestMapping("/house/floor/info")
	public ModelAndView floorInfo(@RequestParam("floor") Long id, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("user/floor_info");
		modelAndView.addObject("floor", floorService.findFloorById(id)); 
		modelAndView.addObject("previous", request.getHeader("Referer")); 	
		return modelAndView;
	}
	
	

	@RequestMapping("/house/room/info")
	public ModelAndView roomInfo(@RequestParam("room") Long id,  HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("user/room_info");
		modelAndView.addObject("room", roomsService.findRoomById(id)); 
		modelAndView.addObject("previous", request.getHeader("Referer")); 	
		return modelAndView;
	}
	
	@RequestMapping(value = "/houses/add", method = RequestMethod.GET)
	public ModelAndView addHousePage() {
		ModelAndView modelAndView = new ModelAndView("user/house_add");
		modelAndView.addObject("house", new Houses());
		modelAndView.addObject("typesHouse", houseTypesRepository.findAll());
		modelAndView.addObject("next", null);
		return modelAndView;
	}
	
	@RequestMapping(value = "/houses/add", method = RequestMethod.POST)
	public ModelAndView addHouse(@Valid Houses house, BindingResult bindingResult, @RequestParam("houseType") Integer type) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Users user = userService.findUserByUsername(auth.getName());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("house", new Houses());
		modelAndView.addObject("typesHouse", houseTypesRepository.findAll());	
		if(!bindingResult.hasErrors()) {
			house.setUser(user);
			house.setType(houseTypesRepository.getOne(Long.valueOf(type)));
			houseService.saveHouse(house);
			modelAndView.addObject("next", houseService.findHouseByName(house.getName()).getId());
			modelAndView.addObject("message", "Будинок додано");
			modelAndView.setViewName("redirect:/user/houses/add/floor");
		}else {
			modelAndView.setViewName("user/house_add");
			modelAndView.addObject("next", null);
			modelAndView.addObject("message", "Будинок не додано");
		}
		return modelAndView;	
	}
	
	@RequestMapping(value = "/houses/add/floor", method = RequestMethod.GET)
	public ModelAndView addFloorPage(@RequestParam("next") Integer house) {
		ModelAndView modelAndView = new ModelAndView("user/floor_add");
		modelAndView.addObject("next", null);
		modelAndView.addObject("floor", new Floors());
		modelAndView.addObject("house", house);
		modelAndView.addObject("floors", floorService.getFloorByHouse(houseService.findHouseById(Long.valueOf(house))));
		return modelAndView;
	}
	
	@RequestMapping(value = "/houses/add/floor", method = RequestMethod.POST)
	public ModelAndView addFloor(@Valid Floors floor, BindingResult  bindingResult, @RequestParam("house") Integer house) {
		ModelAndView modelAndView = new ModelAndView("user/floor_add");
		modelAndView.addObject("floor", new Floors());
		modelAndView.addObject("house", house);
		if(!bindingResult.hasErrors()) {
			floor.setHouse(houseService.findHouseById(Long.valueOf(house)));
			floorService.saveFloor(floor);
			modelAndView.addObject("next", floorService.findFloorByName(floor.getName()).getId());
			modelAndView.addObject("message", "Поверх додано");
		}else {
			modelAndView.addObject("next", null);
			modelAndView.addObject("message", "Поверх не додано");
		}	
		modelAndView.addObject("floors", houseService.findHouseById(Long.valueOf(house)).getFloor());
		return modelAndView;
	}
	
	@RequestMapping(value = "/room/add", method = RequestMethod.GET)
	public ModelAndView addRoomPage(@RequestParam("next") Long floor) {
		ModelAndView modelAndView = new ModelAndView("user/room_add");
		modelAndView.addObject("room", new Rooms());
		modelAndView.addObject("next", null);
		modelAndView.addObject("rooms", floorService.findFloorById(floor).getRooms());
		modelAndView.addObject("floor", floor);
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/room/add", method = RequestMethod.POST)
	public ModelAndView addRoom(@Valid Rooms room, BindingResult bindingResult, @RequestParam("floorid") Long floor) {
		ModelAndView modelAndView = new ModelAndView("user/room_add");
		modelAndView.addObject("room", new Rooms());
		modelAndView.addObject("floor", floor);
		if(!bindingResult.hasErrors()) {
			room.setFloor(floorService.findFloorById(floor));
			roomsService.saveRoom(room);
			modelAndView.addObject("next", roomsService.findRoomByName(room.getName()).getId());
			modelAndView.addObject("message", "Кімнату додано");
		}else {
			System.out.println(bindingResult);
			modelAndView.addObject("next", null);
			modelAndView.addObject("message", "Кімату не додано");
		}
		modelAndView.addObject("rooms", floorService.findFloorById(floor).getRooms());
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/room/add/sensors", method = RequestMethod.GET)
	public ModelAndView addSensorPage(@RequestParam("next") Integer  room) {
		ModelAndView modelAndView = new ModelAndView("user/sensor_add");
		modelAndView.addObject("sensors", sensorService.findSensorByType(SensorType.ROOM));
		modelAndView.addObject("next", room);
		return modelAndView;
	}
	
	@RequestMapping(value = "/room/add/sensors", method = RequestMethod.POST)
	public ModelAndView addSensor(@RequestParam(name = "selectSensors", required=false)  List<Sensors> sensors, @RequestParam("room") Long  room){
		ModelAndView modelAndView = new ModelAndView("user/sensor_add");
		modelAndView.addObject("sensors", sensorService.findSensorByType(SensorType.ROOM));
		modelAndView.addObject("next", room);
		Rooms savedRoom = roomsService.findRoomById(room); 
		savedRoom.setSensors(sensors);
		try {
			if (sensors == null) {throw new NullPointerException();}
			roomsService.updateRoom(savedRoom);
			modelAndView.addObject("message", "Сенсор додано");
		}catch(Exception ex) {
			modelAndView.addObject("message", "Сенсор не додано");
		}
		return modelAndView;
	}
	

	
	@RequestMapping(value = "/room/window/add", method = RequestMethod.GET)
	public ModelAndView addWindowToRoomPage(@RequestParam("next") Long  room) {
		ModelAndView modelAndView = new ModelAndView("user/window_add");
		modelAndView.addObject("window", new Windows());
		modelAndView.addObject("sensors", sensorService.findSensorByType(SensorType.WINDOW));
		modelAndView.addObject("next", room);
		modelAndView.addObject("windows", roomsService.findRoomById(room).getWindows());
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/room/window/add",  method = RequestMethod.POST)
	public ModelAndView addWindowtoRoom(@Valid Windows window, BindingResult bindingResult, @RequestParam("room") Long room, @RequestParam(name = "selectSensors", required = false)   List<Sensors> sensors) {
		ModelAndView modelAndView = new ModelAndView("user/window_add");
		modelAndView.addObject("window", new Windows());
		modelAndView.addObject("next", room);
		modelAndView.addObject("sensors", sensorService.findSensorByType(SensorType.WINDOW));
		modelAndView.addObject("windows", roomsService.findRoomById(room).getWindows());
		if(!bindingResult.hasErrors() && sensors != null) {
			window.setSensor(sensors);
			windowService.saveWindow(window);
			modelAndView.addObject("message", "Вікно додано");
		}else {
			modelAndView.addObject("message", "Вікно не додано");
		}
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/room/door/add", method = RequestMethod.GET)
	public ModelAndView addDoorToRoomPage(@RequestParam("next") Long room) {
		ModelAndView modelAndView = new ModelAndView("user/door_add");
		modelAndView.addObject("door", new Door());
		modelAndView.addObject("sensors", sensorService.findSensorByType(SensorType.DOOR));
		modelAndView.addObject("next", room);
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/room/door/add", method = RequestMethod.POST)
	public ModelAndView addDoorToRoom(@Valid Door door, BindingResult  bindingResult,  @RequestParam("room") Long room, @RequestParam(name = "selectSensors", required = false)  List<Sensors> sensors) {
		ModelAndView modelAndView = new ModelAndView("user/door_add");
		modelAndView.addObject("dooor", new Door());
		modelAndView.addObject("sensors", sensorService.findSensorByType(SensorType.DOOR));
		modelAndView.addObject("next", room);
		if(!bindingResult.hasErrors() && sensors != null) {
			door.setSensor(sensors);
			doorService.saveDoor(door);
			modelAndView.addObject("message", "Двері додано");
		}else {
			modelAndView.addObject("message", "Двері не додано, можливо ви не вибрали сенсори");
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/settings", method = RequestMethod.GET)
	public ModelAndView settingsPage() {
		ModelAndView modelAndView = new ModelAndView("user/settings");
		Authentication authUser = SecurityContextHolder.getContext().getAuthentication(); 
		modelAndView.addObject("authUser", userService.findUserByUsername(authUser.getName()));
		modelAndView.addObject("user", new Users());
		return modelAndView;
	}
	
}
