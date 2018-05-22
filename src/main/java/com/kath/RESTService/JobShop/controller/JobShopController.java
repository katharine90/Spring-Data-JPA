package com.kath.RESTService.JobShop.controller;

import com.kath.RESTService.JobShop.exception.ResourceNotFoundException;
import com.kath.RESTService.JobShop.model.JobShop;
import com.kath.RESTService.JobShop.repository.JobShopRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class JobShopController {
    
    @Autowired
    JobShopRepository jobRepository;

    // Get All Notes
    @GetMapping("/jobs")
    public List<JobShop> getAllJobs() {
        return jobRepository.findAll();
    }

    // Create a new JobShop
    @PostMapping("/jobs")
    public JobShop createJob(@Valid @RequestBody JobShop job) {
        return jobRepository.save(job);
    }

    // Get a Single JobShop by id
    @GetMapping("/jobs/{id}")
    public JobShop getJobById(@PathVariable(value = "id") Long jobId) {
        return jobRepository.findById(jobId)
                .orElseThrow(() -> new ResourceNotFoundException("JobShop", "id", jobId));
    }
    
    @GetMapping("/jobs/yrkesomrade={value}")
    public List<JobShop> getYrkesOmrade(@PathVariable(value = "value") String value) {
    	List<JobShop> list = jobRepository.findByYrkesomrade(value);
    	list.forEach(p->System.out.println(p.getTitel()));
        return list;
    }
    

    // Update a JobShop
    @PutMapping("/jobs/{id}")
    public JobShop updateJob(@PathVariable(value = "id") Long jobId, @Valid @RequestBody JobShop jobDetails) {

        JobShop job = jobRepository.findById(jobId)
                .orElseThrow(() -> new ResourceNotFoundException("JobShop", "id", jobId));

        job.setYrkesomrade(jobDetails.getYrkesomrade());
        job.setTitel(jobDetails.getTitel());
        job.setContent(jobDetails.getContent());
        job.setURL(jobDetails.getURL());

        JobShop updatedJob =  jobRepository.save(job);
        return updatedJob;
    }

    // Delete a JobShop
    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<?> deleteJob(@PathVariable(value = "id") Long jobId) {
        JobShop job = jobRepository.findById(jobId)
                .orElseThrow(() -> new ResourceNotFoundException("JobShop", "id", jobId));

        jobRepository.delete(job);

        return ResponseEntity.ok().build();
    }
}
