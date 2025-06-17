
package com.smarthire.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smarthire.common.ResponseCode;
import com.smarthire.dto.VacancyData;
import com.smarthire.dto.VacancyRequest;
import com.smarthire.dto.VacancyResponse;
import com.smarthire.entity.Vacancy;
import com.smarthire.repo.SmartHireRepository;

@Service
public class SmartHireServiceImp {

	@Autowired
	private SmartHireRepository vacancyRepo;

	@Autowired
	private VacancyResponse vacancyResponse;

	public VacancyResponse addVacancy(VacancyRequest request) {

		List<Vacancy> optionalVacancy = vacancyRepo.findByJobId(request.getId());

		if (!optionalVacancy.isEmpty()) {
			vacancyResponse.setStatus(ResponseCode.VACANCY_FAILED.getStatus());
			vacancyResponse.setMessage(ResponseCode.VACANCY_FAILED.getMessage());
			return vacancyResponse;
		}

		Vacancy vacancy = new Vacancy();
		vacancy.setJobId(request.getJobId());
		vacancy.setVacancyName(request.getVacancyName());
		vacancy.setJobTitle(request.getJobTitle());
		vacancy.setNumberOfPosition(request.getNumberOfPosition());
		vacancy.setCostCenter(request.getCostCenter());
		vacancy.setDescription(request.getDescription());
		vacancy.setHiringManager(request.getHiringManager());
		vacancy.setStatus(request.getStatus());
		vacancy.setTenant(request.getTenant());
		vacancy.setVendorName(request.getVendorName());

		vacancy = vacancyRepo.save(vacancy);

		vacancyResponse.setStatus(ResponseCode.VACANCY_SUCCESS.getStatus());
		vacancyResponse.setMessage(ResponseCode.VACANCY_SUCCESS.getMessage());
		vacancyResponse.getVacancyData().setErrorCode(ResponseCode.VACANCY_FAILED.getErrorCode());
		vacancyResponse.getVacancyData().setVacancy_id(vacancy.getId());
		vacancyResponse.getVacancyData().setJob_id(vacancy.getJobId());
		vacancyResponse.getVacancyData().setVacancyName(vacancy.getVacancyName());
		vacancyResponse.getVacancyData().setJobTitle(vacancy.getJobTitle());
		vacancyResponse.getVacancyData().setDescription(vacancy.getDescription());
		vacancyResponse.getVacancyData().setHiringManager(vacancy.getHiringManager());
		vacancyResponse.getVacancyData().setNumberOfPosition(vacancy.getNumberOfPosition());
		vacancyResponse.getVacancyData().setVendorName(vacancy.getVendorName());
		vacancyResponse.getVacancyData().setTenant(vacancy.getTenant());
		vacancyResponse.getVacancyData().setCostCenter(vacancy.getCostCenter());

		return vacancyResponse;
	}

	public VacancyResponse updateVacancy(Long id, VacancyRequest request) {
		VacancyResponse vacancyResponse = new VacancyResponse();

		Optional<Vacancy> optionalVacancy = vacancyRepo.findById(id);

		if (!optionalVacancy.isPresent()) {
			vacancyResponse.setStatus(ResponseCode.VACANCY_NOT_UPDATED.getStatus());
			vacancyResponse.setMessage("Vacancy not found with ID: " + id);
			return vacancyResponse;
		}

		Vacancy vacancy = optionalVacancy.get();
		vacancy.setJobId(request.getJobId());
		vacancy.setVacancyName(request.getVacancyName());
		vacancy.setJobTitle(request.getJobTitle());
		vacancy.setNumberOfPosition(request.getNumberOfPosition());
		vacancy.setCostCenter(request.getCostCenter());
		vacancy.setDescription(request.getDescription());
		vacancy.setHiringManager(request.getHiringManager());
		vacancy.setStatus(request.getStatus());
		vacancy.setTenant(request.getTenant());
		vacancy.setVendorName(request.getVendorName());

		vacancyRepo.save(vacancy);

		vacancyResponse.setStatus(ResponseCode.VACANCY_UPDATED.getStatus());
		vacancyResponse.setMessage("Vacancy updated successfully");

		return vacancyResponse;
	}

	public VacancyResponse deleteVacancy(Long id) {

		VacancyResponse vacancyResponse = new VacancyResponse();
		Optional<Vacancy> optionalVacancy = vacancyRepo.findById(id);

		if (optionalVacancy.isEmpty()) {
			vacancyResponse.setStatus(ResponseCode.NOT_DELETE_VACANCY.getStatus());
			vacancyResponse.setMessage("Vacancy not found with ID: " + id);
			return vacancyResponse;
		}

		vacancyRepo.deleteById(id);
		vacancyResponse.setStatus(ResponseCode.DELETE_VACANCY.getStatus());
		vacancyResponse.setMessage("Vacancy deleted successfully with ID: " + id);
		return vacancyResponse;
	}

	public VacancyResponse searchVacancyByid(Long id) {

		Optional<Vacancy> optionalVacancy = vacancyRepo.findById(id);

		if (!optionalVacancy.isPresent()) {
			vacancyResponse.setStatus(ResponseCode.SEARCH_VACANCY_FAILED.getStatus());
			vacancyResponse.setMessage("Vacancy not found with ID: " + id);
			return vacancyResponse;
		}

		Vacancy vacancy = optionalVacancy.get();
		vacancyResponse.setStatus(ResponseCode.SEARCH_VACANCY.getStatus());
		vacancyResponse.setMessage("Vacancy found with ID: " + id);

		return vacancyResponse;

	}

	public List<VacancyResponse> getAllVacancies() {
		List<Vacancy> vacancies = vacancyRepo.findAll();
		List<VacancyResponse> vacancyResponses = new ArrayList<>();

		for (Vacancy vacancy : vacancies) {
			VacancyResponse response = new VacancyResponse();
			VacancyData vacancyData = new VacancyData();
			response.setVacancyData(vacancyData);
			vacancyData.setVacancy_id(vacancy.getId());
			vacancyData.setJob_id(vacancy.getJobId());
			vacancyData.setVacancyName(vacancy.getVacancyName());
			vacancyData.setJobTitle(vacancy.getJobTitle());
			vacancyData.setDescription(vacancy.getDescription());
			vacancyData.setHiringManager(vacancy.getHiringManager());
			vacancyData.setNumberOfPosition(vacancy.getNumberOfPosition());
			vacancyData.setVendorName(vacancy.getVendorName());
			vacancyData.setTenant(vacancy.getTenant());
			vacancyData.setCostCenter(vacancy.getCostCenter());

			response.setStatus(ResponseCode.SEARCH_VACANCY.getStatus());
			response.setMessage("Vacancy fetched Successfully");

			vacancyResponses.add(response);
		}

		return vacancyResponses;
	}

}
