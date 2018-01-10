package com.igordavidenko.HouseNow.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.igordavidenko.HouseNow.Models.Users;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{

	
	@Autowired 
	private UserServiceImpl userService;
	
	
	
	@Transactional(readOnly=true) 
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		Users user = userService.findUserByUsername(username);
		System.out.println(username);
		System.out.println(user);	
		if (user == null){
			throw new UsernameNotFoundException("User not found");
		}
		return new User(user.getUsername(), user.getPassword(), getGrantedAuthorities(user));
	} 
	
	
    private List<GrantedAuthority> getGrantedAuthorities(Users user){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();   
        authorities.add(new SimpleGrantedAuthority("ROLE_"+user.getRole()));
        return authorities;
    }
}
