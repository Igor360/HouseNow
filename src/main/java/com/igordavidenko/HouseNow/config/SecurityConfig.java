package com.igordavidenko.HouseNow.config;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import com.igordavidenko.HouseNow.Service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
		
	@Autowired
	private CustomUserDetailsService userService;
	
	@Autowired
	private DataSource dataSource;
		
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
	}
	
	@Override 
	protected void configure(HttpSecurity http)	throws Exception {
		http.authorizeRequests() 
        .antMatchers("/", "/registration","/login*").permitAll() 
		.antMatchers("/user/home", "/user/house/info", "/user/house/floor/info", "/user/house/room/info").access("hasRole('USER')")
        .anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.usernameParameter("username").passwordParameter("password")
		.defaultSuccessUrl("/user/home")
		.failureUrl("/login?error=true")
		.and()
		.logout().logoutSuccessUrl("/");
	} 
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web
	       .ignoring()
	       .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}
	
	
	
	@Bean
	public PersistentTokenRepository presistentTokenRepository() {
			JdbcTokenRepositoryImpl tokenRepositoryImpl = new JdbcTokenRepositoryImpl();
			tokenRepositoryImpl.setDataSource(dataSource);
			return tokenRepositoryImpl;
	}
	
}
