
package com.smarthire.dto;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter

public class VacancyRequest {

	private long id;
	private String vacancyName;
	private long jobId;
	private String jobTitle;
	private String description;
	private String hiringManager;
	private int numberOfPosition;
	private String costCenter;
	private String vendorName;
	private String status;
	private String tenant;

}
