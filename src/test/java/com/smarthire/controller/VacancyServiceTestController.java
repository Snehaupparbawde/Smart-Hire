package com.smarthire.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.smarthire.SmartHireMain;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = SmartHireMain.class)
public class VacancyServiceTestController {

	@Autowired
	private MockMvc mockMvc;

	private static final String VACANCY_JSON = """
			{
			  "vacancyName": "Software Tester",
			  "jobTitle": "SDET",
			  "description": "Develop and Test Java Applications",
			  "hiringManager": "John",
			  "numberOfPosition": 10,
			  "costCenter": "CC12342",
			  "vendorName": "XYZ",
			  "status": "Open",
			  "tenant": "TenantA",
			  "jobId": 40
			}
			""";

	@Test
	@Order(1)
	@DisplayName("Add Vacancy - Success")
	public void testAddVacancySuccess() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/api/user/AddVacancy").content(VACANCY_JSON)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.status").value("Success"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Vacancy added successfully"));
	}

	@Test
	@Order(2)
	@DisplayName("Add Vacancy - Failed")
	public void testAddVacancyFailed() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/api/user/AddVacancy").content(VACANCY_JSON)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.status").value("Failed"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Vacancy added Failed"));
	}

	@Test
	@Order(3)
	@DisplayName("Update Vacancy - Success")
	public void testUpdateVacancySuccess() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.put("/api/user/UpdateVacancy").content(VACANCY_JSON)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.status").value("Success"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Vacancy updated successfully!"));
	}

	@Test
	@Order(4)
	@DisplayName("Update Vacancy - Failed")
	public void testUpdateVacancyFailed() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.put("/api/user/UpdateVacancy").content(VACANCY_JSON)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.status").value("Fail"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Vacancy not found or invalid request!"));
	}

	@Test
	@Order(5)
	@DisplayName("Delete Vacancy - Success")
	public void testDeleteVacancySuccess() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/api/user/DeleteVacancy/40").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.status").value("Success"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Vacancy deleted successfully !"));
	}

	@Test
	@Order(6)
	@DisplayName("Delete Vacancy - Failed")
	public void testDeleteVacancyFailed() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/api/user/DeleteVacancy/999").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.status").value("Fail"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Vacancy not deleted !"));
	}

	@Test
	@Order(7)
	@DisplayName("Get Vacancy - Failed")
	public void testGetVacancyFailed() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/user/GetVacancy/999").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.status").value("Fail"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Vacancy not found or invalid request!"));
	}

	@Test
	@Order(8)
	@DisplayName("Get Vacancy - Success")
	public void testGetVacancySuccess() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/user/GetVacancy/40").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.status").value("Success"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Vacancy found successfully!"));
	}
}
