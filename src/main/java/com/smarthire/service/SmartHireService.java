package com.smarthire.service;

import com.smarthire.dto.VacancyRequest;
import com.smarthire.dto.VacancyResponse;

public interface SmartHireService {
	
	public VacancyResponse addVacancy(VacancyRequest request) throws Exception;
	
	public VacancyResponse updateVacancy(Long id, VacancyRequest request);
	
	public VacancyResponse deleteVacancy(Long id);
	
	public VacancyResponse searchVacancyByid(Long id);
	
	public  VacancyResponse getAllVacancies();

}