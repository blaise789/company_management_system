package com.codewithme.jobapp.services.impl;

import com.codewithme.jobapp.Models.Company;
import com.codewithme.jobapp.Models.Review;
import com.codewithme.jobapp.error.CompanyNotFoundException;
import com.codewithme.jobapp.repositories.CompanyRepository;
import com.codewithme.jobapp.repositories.ReviewRepository;
import com.codewithme.jobapp.services.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final CompanyRepository companyRepository;
//    public CompanyRepository companyRepository;
    @Override
    public List<Review> findAllCompanyReviews(Long id) {
           List<Review> reviews = reviewRepository.findByCompanyId(id);

           return reviews;






    }

    @Override
    public void createReview(Long companyId,Review review) throws CompanyNotFoundException {
        Optional<Company> company=companyRepository.findById(companyId);
        if (!company.isPresent()){
            throw  new CompanyNotFoundException("company is not available");
        }
        review.setCompany(company.get());
        reviewRepository.save(review);

    }
}
