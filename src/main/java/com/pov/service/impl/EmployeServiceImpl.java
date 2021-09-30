package com.pov.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pov.entities.Employe;
import com.pov.repository.IEmployeRepository;
import com.pov.service.interfaces.IEmployeService;

@Service
@Transactional
public class EmployeServiceImpl  implements IEmployeService{
	@Autowired
	private IEmployeRepository employeRepository;

	@Override
	public List<Employe> allEmploye() {
		// TODO Auto-generated method stub
		return employeRepository.findAll();
	}

	@Override
	public Employe oneEmploye(Long id) {
		// TODO Auto-generated method stub
		return employeRepository.getById(id);
	}

	@Override
	public void addEmploye(Employe employe) {
		// TODO Auto-generated method stub
		employeRepository.save(employe);
	}

	@Override
	public void editEmploye(Employe employe) {
		// TODO Auto-generated method stub
		employeRepository.save(employe);
	}

	@Override
	public void deleteEmploye(Long id) {
		// TODO Auto-generated method stub
		employeRepository.deleteById(id);
	}

	

}
