package com.igordavidenko.HouseNow.Service;

import com.igordavidenko.HouseNow.Models.Users;


public interface UserService {
		
		public Users findUserByUsername(String username);
		public Users findUserByEmail(String email);
		public void saveUser (Users user);
		public void updateUser (Users user);
		public void deleteUser (Users user);
		public Users findUserById(Long id);
}
