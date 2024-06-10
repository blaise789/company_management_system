package com.codewithme.jobapp.controllers;

import com.codewithme.jobapp.Models.Review;
import com.codewithme.jobapp.error.CompanyNotFoundException;
import com.codewithme.jobapp.error.ReviewNotFoundException;
import com.codewithme.jobapp.services.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/companies/{companyId}/reviews")
@RequiredArgsConstructor
public class ReviewController {
    public final ReviewService reviewService;
    @GetMapping()
    private ResponseEntity<List<Review>> getAllCompanyReviews(@PathVariable("companyId") Long id){

        return  new ResponseEntity<>(reviewService.findAllCompanyReviews(id), HttpStatus.OK);

    }
    @PostMapping()
    private  ResponseEntity<String> createCompanyReview(@PathVariable("companyId")Long companyId, @RequestBody() Review review) throws CompanyNotFoundException {
         reviewService.createReview(companyId,review);
         return  new ResponseEntity<>("review created successfully",HttpStatus.CREATED);

    }
    @GetMapping("{reviewId}")
    private  ResponseEntity<Review> getCompanyReview(@PathVariable("companyId") Long compId, @PathVariable("reviewId") Long reviewId) throws ReviewNotFoundException, CompanyNotFoundException {
       Review review=reviewService.getReview(compId,reviewId);
        return new ResponseEntity<>(review,HttpStatus.OK);
    }
    @DeleteMapping("{reviewId}")
    private ResponseEntity<String> deleteCompanyReview(@PathVariable("companyId") Long companyId,@PathVariable("reviewId") Long reviewId) throws ReviewNotFoundException, CompanyNotFoundException {
        reviewService.deleteReview(companyId,reviewId);
     return new ResponseEntity<>("review deleted successfully",HttpStatus.OK);
    }
}
