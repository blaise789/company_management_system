package com.codewithme.jobapp.controllers;

import com.codewithme.jobapp.Models.Job;
import com.codewithme.jobapp.services.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jobs")
@RequiredArgsConstructor
public class JobController {
    private final JobService jobService;
    @GetMapping()
    public List<Job> getJobs(){
        return  jobService.findAll();
    }
    @PostMapping()
    public  ResponseEntity<Job> createJob( @RequestBody() Job job){

        return new ResponseEntity<>(jobService.createJob(job),HttpStatus.CREATED);

    }
    @GetMapping("/{id}")
    public ResponseEntity getJob(@PathVariable("id") Long id){
        Job job=jobService.findJob(id);
        System.out.println(job);
        if(job!=null) {
            return new ResponseEntity<>(job,HttpStatus.OK);
        }
        return new ResponseEntity<>("job not found",HttpStatus.NOT_FOUND);


    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable("id") Long id){

        boolean isJobDeleted= jobService.removeJob(id);
        if(isJobDeleted){
            return new ResponseEntity<>("job deleted successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("Job not found",HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity updateJob(@PathVariable("id") Long id,@RequestBody() Job updatedJob){
        Boolean isUpdated=jobService.updateJob(id,updatedJob);
        if(isUpdated){
            return new ResponseEntity<>("job updated successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("Job not found",HttpStatus.NOT_FOUND);


    }
}
