package com.smarthire.common;

public enum ResponseCode {
	VACANCY_FAILED("Fail", "Vacancy add failed", "ERR001"),
	VACANCY_SUCCESS("Success", "Vacancy added successfully", "SUCCESS"),
	 VACANCY_NOT_UPDATED("Fail", " Vacancy not found or invalid request!","ERR001"),
	 VACANCY_UPDATED("Success", "Vacancy updated successfully!",  "SUCCESS"),
	 SEARCH_VACANCY("Success", "Vacancy found successfully!",  "SUCCESS"),
	 SEARCH_VACANCY_FAILED("Fail", "Vacancy not found or invalid request!", "ERR001"),
	 NOT_DELETE_VACANCY("Fail", "Vacancy not deleted !", "ERR001"),
	 DELETE_VACANCY("Success", "Vacancy deleted successfully !", "SUCCESS" );
	
	private final String status;
	private final String message;
	private final String errorCode;

	ResponseCode(String status, String message, String errorCode) {
		this.status = status;
		this.message = message;
		this.errorCode = errorCode;
	}

	public String getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public String getErrorCode() {
		return errorCode;
	}
}