package com.igordavidenko.HouseNow.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.igordavidenko.HouseNow.Models.Role;
import com.igordavidenko.HouseNow.Models.Users;
import com.igordavidenko.HouseNow.repo.UsersRepository;


@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired 
	private UsersRepository userRepository;
	

	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	

	@Override
	public Users findUserByUsername(String username) {
		return userRepository.findUserByUsername(username);
	}
	
	@Override
	public Users findUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}

	@Override
	public void saveUser(Users user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role userRole = Role.USER;
        user.setRole(userRole);
		userRepository.save(user);
	}
	
	@Override 
	public void updateUser(Users user) {
		if (user.getPassword() != null) {
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			Role userRole = Role.USER;
			user.setRole(userRole);
			userRepository.updateUser(user.getId(), user.getUsername(), user.getEmail(), user.getFirstName(), user.getLastName(), user.getPassword());
		}else {
			userRepository.updateUser(user.getId(), user.getUsername(), user.getEmail(), user.getFirstName(), user.getLastName());
		}
	}
	
	@Override
	public void deleteUser(Users user) {
		userRepository.delete(user);
	}

}
