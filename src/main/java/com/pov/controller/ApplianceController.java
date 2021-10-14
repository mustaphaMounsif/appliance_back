package com.pov.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pov.dtos.ApplianceDto;
import com.pov.service.interfaces.IApplianceService;

@RestController
@RequestMapping("/api/v1/")
public class ApplianceController {
	
	@Autowired
	private IApplianceService applianceService;
	
	@GetMapping("/appliances")
	public List<ApplianceDto> listAppliances(){
		return applianceService.allAppliance();
	}
	
	@PostMapping("/appliances/add")
	public boolean createAppliance(@RequestBody ApplianceDto applianceDto) {
		return applianceService.addAppliance(applianceDto);
	}
	
	@GetMapping("/appliances/{id}")
	public ApplianceDto getOneAppliance(@PathVariable Long id) {
		return applianceService.getOneAppliance(id);
	}
	
	@PutMapping("/appliances/update")
	public boolean updateAppliance(@RequestBody ApplianceDto applianceDto){
		return applianceService.editAppliance(applianceDto);
	}

	@DeleteMapping("/appliances/{id}")
	public boolean deleteAppliance(@PathVariable Long id){
		applianceService.deleteAppliance(id);
		return true;
	}
}
