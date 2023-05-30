package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.ApplicantEntity;
import com.nit.repository.MyRepository;

@Service
public class ApplicantService implements IApplicantService {

	@Autowired
	MyRepository repo;

	@Override
	public String registerApplicant(ApplicantEntity applicant) {
		ApplicantEntity id=repo.save(applicant);
		return id+" applicant is registered successfully";
	}

	@Override
	public List<ApplicantEntity> fetchAllApplicant() {
		List<ApplicantEntity> applicant=repo.findAll();
		return applicant;
	}

	@Override
	public String getResumeById(Integer id) {
		String resume=repo.getResumeById(id);
		return resume;
	}

	@Override
	public String getPhotoById(Integer id) {
		String photo=repo.getPhotoById(id);
		return photo;
	}
	
}
