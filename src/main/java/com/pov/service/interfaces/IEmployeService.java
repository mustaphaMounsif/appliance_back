package com.pov.service.interfaces;

import java.util.List;

import com.pov.entities.Employe;

public interface IEmployeService {

	public List<Employe> allEmploye();
	public Employe oneEmploye(Long id);
	public void addEmploye(Employe employe);
	public void editEmploye(Employe employe);
	public void deleteEmploye(Long id);
	
}
