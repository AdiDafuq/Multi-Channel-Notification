package com.jobtracker.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobtracker.entity.JobApplication;
import com.jobtracker.repository.JobApplicationRepository;
@Service

public class JobApplicationService
{
    @Autowired
    private JobApplicationRepository repository;
    public List<JobApplication> getAllApplications() 
    {
        return repository.findAll();
    }
    public Optional<JobApplication> getApplicationById(Long id)
    {
        return repository.findById(id);
    }
    public void deleteApplication(Long id)
    {
        repository.deleteById(id);
    }
    public List<JobApplication> getByStatus(String status)
    {
        return repository.findByStatus(status);
    }
    public List<JobApplication> getByCompany(String company)
    {
        return repository.findByCompany(company);
    }
    public List<JobApplication> getByRole(String role)
    {
        return repository.findByRole(role);
    }
    public List<JobApplication> getByStatusAndCompany(String status, String company)
    {
       return repository.findByStatusAndCompany(status, company);
    }
    public List<JobApplication> getByStatusAndCompanyAndRole(String status, String company, String role)
    {
       return repository.findByStatusAndCompanyAndRole(status, company, role);
    }
    public JobApplication saveApplication(JobApplication application)
    {
        return repository.save(application);
    }
}
