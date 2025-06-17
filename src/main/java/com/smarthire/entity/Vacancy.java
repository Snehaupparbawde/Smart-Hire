
package com.smarthire.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Component
@Getter
@Setter
@Table(name = "vacancy")
public class Vacancy {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column
	private long id;

	@Column
	private String vacancyName;

	@Column(name = "job_id")
	private long jobId;

	public long getJobId() {
		return jobId;
	}

	public void setJobId(long jobId) {
		this.jobId = jobId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	@Column(name = "job_title")
	private String jobTitle;

	@Column
	private String description;

	@Column(name = "hiring_manager")
	private String hiringManager;

	@Column(name = "number_of_position")
	private int numberOfPosition;

	@Column
	private String costCenter;

	@Column
	private String vendorName;

	@Column
	private String status;

	@Column
	private String tenant;

}
