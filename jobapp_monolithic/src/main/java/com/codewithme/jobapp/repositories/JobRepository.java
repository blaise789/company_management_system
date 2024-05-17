package com.codewithme.jobapp.repositories;

import com.codewithme.jobapp.Models.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job,Long> {

}
