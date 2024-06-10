package com.codewithme.jobapp.services;

import com.codewithme.jobapp.Models.Review;
import com.codewithme.jobapp.error.CompanyNotFoundException;
import com.codewithme.jobapp.error.ReviewNotFoundException;

import java.util.List;

public interface ReviewService {
    List<Review> findAllCompanyReviews(Long id);
    void  createReview(Long id,Review review) throws CompanyNotFoundException;
    Review getReview(Long companyId,Long reviewId) throws CompanyNotFoundException, ReviewNotFoundException;
    void updateReview(Review updatedReview,Long companyId,Long reviewId) throws CompanyNotFoundException, ReviewNotFoundException;
    void deleteReview(Long compId,Long reviewId) throws CompanyNotFoundException, ReviewNotFoundException;
}
