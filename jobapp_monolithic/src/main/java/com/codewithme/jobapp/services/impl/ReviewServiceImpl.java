package com.codewithme.jobapp.services.impl;

import com.codewithme.jobapp.Models.Company;
import com.codewithme.jobapp.Models.Review;
import com.codewithme.jobapp.error.CompanyNotFoundException;
import com.codewithme.jobapp.error.ReviewNotFoundException;
import com.codewithme.jobapp.repositories.CompanyRepository;
import com.codewithme.jobapp.repositories.ReviewRepository;
import com.codewithme.jobapp.services.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
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
        if (company.isEmpty()){
            throw  new CompanyNotFoundException("company is not available");
        }
        review.setCompany(company.get());
        reviewRepository.save(review);

    }

    @Override
    public Review getReview(Long companyId, Long reviewId) throws CompanyNotFoundException, ReviewNotFoundException {
        Optional<Company> company=companyRepository.findById(companyId);
        log.info(company.toString());
        log.trace("hello");
        if(company.isEmpty()){
            throw  new CompanyNotFoundException("company not available");

        }
        List<Review> reviews=reviewRepository.findByCompanyId(companyId);
        Optional<Review>  review=reviews.stream().filter(rev ->
             rev.getId().equals(reviewId)
        ).findFirst();
        if(review.isEmpty()){
            throw new ReviewNotFoundException("review not found");
        }
//        System.out.println(review);
        return  review.get();



    }
    public void updateReview(Review updatedReview,Long companyId,Long reviewId) throws CompanyNotFoundException, ReviewNotFoundException {
        boolean companyExists=companyRepository.findById(companyId).isPresent();
        if(!companyExists){
            throw new CompanyNotFoundException("company not found");
        }
        List<Review> reviews=reviewRepository.findByCompanyId(companyId);
        Optional<Review> reviewToUpdateOptional=reviews.stream().filter((rev)->rev.getId().equals(reviewId)).findFirst();
        if (reviewToUpdateOptional.isEmpty()){
            throw new ReviewNotFoundException("review does not exist");
        }
        Review reviewToUpdate=reviewToUpdateOptional.get();
        reviewToUpdate.setDescription(updatedReview.getDescription());
        reviewToUpdate.setTitle(updatedReview.getTitle());
        reviewToUpdate.setRating(updatedReview.getRating());

        reviewRepository.save(reviewToUpdate);
    }
    @Override
   public  void deleteReview(Long companyId,Long reviewId) throws CompanyNotFoundException, ReviewNotFoundException {
        Optional<Company> company=companyRepository.findById(companyId);
        if(company.isEmpty()){
            throw new CompanyNotFoundException("the company does not exist");
        }


        List<Review> companyReviews=reviewRepository.findByCompanyId(companyId);
        Optional<Review> reviewsOptional=companyReviews.stream().filter((rev)->rev.getId().equals(reviewId)).findFirst();
        if(reviewsOptional.isEmpty()){
            throw new ReviewNotFoundException("review does not exist");
        }
        log.info(reviewsOptional.get().toString());
        Review reviewToDelete=reviewsOptional.get();
        reviewRepository.delete(reviewToDelete);

   }

}
