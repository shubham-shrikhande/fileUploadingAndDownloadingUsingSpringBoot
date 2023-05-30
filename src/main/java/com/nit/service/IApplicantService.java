package com.nit.service;

import java.util.List;

import com.nit.entity.ApplicantEntity;

public interface IApplicantService {

	public String registerApplicant (ApplicantEntity applicant);
	public List<ApplicantEntity> fetchAllApplicant();
	public String getResumeById(Integer id);
	public String getPhotoById(Integer id);
}
