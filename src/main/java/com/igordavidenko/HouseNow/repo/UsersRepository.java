package com.igordavidenko.HouseNow.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.igordavidenko.HouseNow.Models.Users;

@Repository("userRepository")
public interface UsersRepository extends JpaRepository<Users, Long> {
			public Users findUserByUsername(String username);
			public Users findUserByEmail(String email);
				
			@Modifying
			@Query("UPDATE Users u SET u.username = :username,  u.email = :email, u.firstName = :firstName, u.lastName = :lastName, u.password = :password WHERE u.id = :id")
			public int updateUser(@Param("id") Long integer, @Param("username")String username, @Param("email") String email, @Param("firstName") String firstName, @Param("lastName") String lastName, @Param("password") String password);
			
			@Modifying
			@Query("UPDATE Users u SET u.username = :username,  u.email = :email, u.firstName = :firstName, u.lastName = :lastName WHERE u.id = :id")
			public int updateUser(@Param("id") Long integer, @Param("username")String username, @Param("email") String email, @Param("firstName") String firstName, @Param("lastName") String lastName);
}

