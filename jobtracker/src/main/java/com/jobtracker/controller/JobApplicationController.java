package com.jobtracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jobtracker.entity.JobApplication;
import com.jobtracker.service.JobApplicationService;

@RestController
@RequestMapping("/applications")
public class JobApplicationController {

    @Autowired
    private JobApplicationService service;

    // CREATE
    @PostMapping
    public JobApplication createApplication(@RequestBody JobApplication application) {
        return service.saveApplication(application);
    }

    // GET ALL
    @GetMapping
    public List<JobApplication> getAllApplications() {
        return service.getAllApplications();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public JobApplication getApplicationById(@PathVariable Long id) {
        return service.getApplicationById(id).orElse(null);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteApplication(@PathVariable Long id) {
        service.deleteApplication(id);
        return "Application deleted successfully";
    }

    // FILTER BY STATUS
    @GetMapping("/status")
    public List<JobApplication> getByStatus(@RequestParam String value) {
        return service.getByStatus(value);
    }

    // FILTER BY COMPANY
    @GetMapping("/company")
    public List<JobApplication> getByCompany(@RequestParam String value) {
        return service.getByCompany(value);
    }

    // FILTER BY ROLE
    @GetMapping("/role")
    public List<JobApplication> getByRole(@RequestParam String value) {
        return service.getByRole(value);
    }

    // FILTER BY STATUS + COMPANY
    @GetMapping("/filter")
    public List<JobApplication> filterByStatusAndCompany(
            @RequestParam String status,
            @RequestParam String company) {
        return service.getByStatusAndCompany(status, company);
    }

    // FILTER BY STATUS + COMPANY + ROLE (CONSISTENT NAMING FIXED)
    @GetMapping("/filter/all")
    public List<JobApplication> filterAll(
            @RequestParam String status,
            @RequestParam String company,
            @RequestParam String role) {
        return service.getByStatusAndCompanyAndRole(status, company, role);
    }
}