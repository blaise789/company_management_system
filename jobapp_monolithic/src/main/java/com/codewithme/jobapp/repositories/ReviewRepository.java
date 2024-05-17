package com.codewithme.jobapp.repositories;

import com.codewithme.jobapp.Models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {
    public List<Review> findByCompanyId(Long companyId);
}
