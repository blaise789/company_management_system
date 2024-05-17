package com.codewithme.jobapp.services.impl;

import com.codewithme.jobapp.Models.Job;
import com.codewithme.jobapp.repositories.JobRepository;
import com.codewithme.jobapp.services.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {
//   ArrayList<Job> jobs=new ArrayList<>();
    private final JobRepository jobRepository;
   private Long nextId=1L;
    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public Job createJob(Job job) {
//        job.setId(nextId++);
        jobRepository.save(job);
        return job;
    }
    public Job findJob(Long id){
//        for (Job job:jobs){
//            if(job.getId().equals(id)){
//                return  job;
//            }

//        }



        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean removeJob(Long id) {
//        Iterator<Job> jobIterator=jobs.iterator();
//        System.out.println(jobIterator);
//        while(jobIterator.hasNext()){
//            Job job=jobIterator.next();
//            if(job.getId().equals(id)){
//                jobIterator.remove();
//                return true;
//            }
//
//        }
//        return false;
   Optional<Job> job= jobRepository.findById(id);
   if(job.isPresent()) {
       jobRepository.deleteById(id);
       return true;
   }
   return false;


    }

    @Override
    public Boolean updateJob(Long id, Job updatedJob) {
////        Iterator<Job> jobIterator=jobs.iterator();
//        while(jobIterator.hasNext()){
//            Job nextJob=jobIterator.next();
//            if(nextJob.getId().equals(id)){
//                nextJob.setDescription(updatedJob.getDescription());
//                nextJob.setLocation(updatedJob.getLocation());
//                nextJob.setTitle(updatedJob.getTitle());
//                nextJob.setMaxSalary(updatedJob.getMaxSalary());
//                nextJob.setMinSalary(updatedJob.getMinSalary());
//                return  true;
//
//            }
//
//        }
//        return false;
        Optional<Job> job= jobRepository.findById(id);
        if(job.isPresent()){
            Job jobTobeUpdated=job.get();
            jobTobeUpdated.setDescription(updatedJob.getDescription());
            jobTobeUpdated.setLocation(updatedJob.getLocation());
            jobTobeUpdated.setTitle(updatedJob.getTitle());
            jobTobeUpdated.setMinSalary(updatedJob.getMinSalary());
            jobTobeUpdated.setMaxSalary(updatedJob.getMaxSalary());
            jobRepository.save(jobTobeUpdated);
            return true;
        }

 return false;



    }
}
