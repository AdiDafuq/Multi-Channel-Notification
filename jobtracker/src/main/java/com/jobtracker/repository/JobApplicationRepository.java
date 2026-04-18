package com.jobtracker.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobtracker.entity.JobApplication;
public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> 
{
    List<JobApplication> findByStatus(String Status);
    List<JobApplication> findByCompany(String company);
    List<JobApplication> findByRole(String role);
    List<JobApplication> findByStatusAndCompanyAndRole(String status, String company, String role);
    List<JobApplication> findByStatusAndCompany(String status, String company);
    
}