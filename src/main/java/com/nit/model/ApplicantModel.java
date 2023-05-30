package com.nit.model;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

public class ApplicantModel {

	private String appName;
	private MultipartFile appResume;
	private MultipartFile appPhoto;
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public MultipartFile getAppResume() {
		return appResume;
	}
	public void setAppResume(MultipartFile appResume) {
		this.appResume = appResume;
	}
	public MultipartFile getAppPhoto() {
		return appPhoto;
	}
	public void setAppPhoto(MultipartFile appPhoto) {
		this.appPhoto = appPhoto;
	}
	@Override
	public String toString() {
		return "ApplicantModel [appName=" + appName + ", appResume=" + appResume + ", appPhoto=" + appPhoto + "]";
	}
	
	
}
