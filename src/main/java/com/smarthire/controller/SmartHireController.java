
package com.smarthire.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smarthire.dto.VacancyRequest;
import com.smarthire.dto.VacancyResponse;
import com.smarthire.service.SmartHireServiceImp;

@RestController
public class SmartHireController {

	@Autowired
	private SmartHireServiceImp addVacancyService;

	// http://localhost:8080/api/user/AddVacancy
	@PostMapping(path = "api/user/AddVacancy")
	public VacancyResponse addVacancy(@RequestBody VacancyRequest addVacancyBody) {
		return addVacancyService.addVacancy(addVacancyBody);
	}

	@PostMapping(path = "api/user/UpdateVacancy/{id}")
	public VacancyResponse updateVacancy(@PathVariable Long id, @RequestBody VacancyRequest updateVacancyBody) {
		return addVacancyService.updateVacancy(id, updateVacancyBody);
	}

	@DeleteMapping(path = "api/user/DeleteVacancy/{id}")
	public VacancyResponse deleteVacancy(@PathVariable Long id) {
		return addVacancyService.deleteVacancy(id);
	}

	@GetMapping(path = "api/user/GetVacancy/{id}")
	public VacancyResponse getVacancyById(@PathVariable Long id) {
		return addVacancyService.searchVacancyByid(id);
	}

	@GetMapping(path = "api/user/GetAllVacancies")
	public List<VacancyResponse> getAllVacancies() {
		return addVacancyService.getAllVacancies();
	}

}
