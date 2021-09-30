package com.pov.service.interfaces;

import java.util.List;

import com.pov.entities.Role;

public interface IRoleService {

	
	public List<Role> allRole();
	public Role oneRole(Long id);
	public void addRole(Role role);
	public void editRole(Role role);
	public void deleteRole(Long id);
}
