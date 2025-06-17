
package com.smarthire.dto;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter

public class VacancyData {

	private String errorCode;
	private long vacancy_id;
	private long job_id;
	private String jobTitle;
	private String description;
	private String hiringManager;
	private int numberOfPosition;
	private String costCenter;
	private String vendorName;
	private String tenant;
	private String vacancyName;

}
