package com.pov.service.impl;

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

import com.pov.entities.Employe;
import com.pov.repository.IEmployeRepository;

@Service
public class UserServiceImpl implements UserDetailsService {
	@Autowired
	private IEmployeRepository employeRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Employe employe=employeRepository.findByLogin(username);
		
		if(employe!=null) {
			String password=employe.getPassword();
			boolean enabled = true;
            boolean accountNonExpired = true;
            boolean credentialsNonExpired = true;
            boolean accountNonLocked = true;
            List<GrantedAuthority> listRole=new ArrayList<GrantedAuthority>();
            listRole.add(new SimpleGrantedAuthority(employe.getRole().getNom_role()));
            
            User userSecurity=new User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, listRole);
            		
            	return userSecurity;
		}
		
		return null;
	}

}
