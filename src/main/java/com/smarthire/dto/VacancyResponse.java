
package com.smarthire.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter

public class VacancyResponse {

	private String status;
	private String message;

	@Autowired
	private VacancyData VacancyData;

}
