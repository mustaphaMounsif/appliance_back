package com.pov.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.pov.service.impl.UserServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userServiceImpl);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.formLogin()
		.loginPage("/login")
		.usernameParameter("username")
		.passwordParameter("password")
		.failureUrl("/login?error=true")
		.and()
		.logout()
		.logoutUrl("/logout")
		.logoutSuccessUrl("/login")
		.and()
		.csrf()
		.disable();
	}
	
	

}
