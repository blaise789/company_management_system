package com.codewithme.jobapp.services;

import com.codewithme.jobapp.Models.Review;
import com.codewithme.jobapp.error.CompanyNotFoundException;

import java.util.List;

public interface ReviewService {
    List<Review> findAllCompanyReviews(Long id);
    void  createReview(Long id,Review review) throws CompanyNotFoundException;

}
