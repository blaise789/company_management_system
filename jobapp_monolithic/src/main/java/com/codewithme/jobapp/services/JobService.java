package com.codewithme.jobapp.services;

import com.codewithme.jobapp.Entities.Job;

import java.util.List;

public interface JobService {
    public List<Job> findAll();
    public Job createJob(Job job);
    public Job findJob(Long id);
    public Boolean removeJob(Long id);
    public Boolean updateJob(Long id,Job job);

}
