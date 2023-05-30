package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nit.entity.ApplicantEntity;

public interface MyRepository extends JpaRepository<ApplicantEntity, Integer> {

	@Query("select resumePath from ApplicantEntity where id=:id")
	public String getResumeById(Integer id);
	
	@Query("select photoPath from ApplicantEntity where id=:id")
	public String getPhotoById(Integer id);
}
