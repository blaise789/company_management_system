package com.codewithme.jobapp.controllers;

import com.codewithme.jobapp.Models.Company;
import com.codewithme.jobapp.error.CompanyNotFoundException;
import com.codewithme.jobapp.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/companies")
public class CompanyController {
    private final CompanyService companyService;
    @GetMapping()
    public ResponseEntity<List<Company>> findAllCompanies(){
        return new ResponseEntity<>(companyService.getAllCompanies(), HttpStatus.OK);

    }
    @GetMapping("{id}")
    public ResponseEntity findCompany(@PathVariable("id") Long companyId) throws CompanyNotFoundException {
//        Company company=companyService.getCompany(companyId);
//        if(company  !=null){
            return  new ResponseEntity<>(companyService.getCompany(companyId),HttpStatus.OK);
//        }

//        return  new ResponseEntity<>("user not found",HttpStatus.NOT_FOUND);

    }
    @PostMapping()
    public ResponseEntity createCompany(@RequestBody() Company newCompany){
        try {

            return new ResponseEntity(companyService.createCompany(newCompany), HttpStatus.CREATED);
        }
        catch (Exception exception){
            return new ResponseEntity<>("company cannot be created",HttpStatus.BAD_REQUEST);
        }

    }
    @PutMapping("{id}")
    public ResponseEntity<String> updateCompany(@PathVariable("id")Long id,@RequestBody() Company updatedCompany){
   Boolean isCompanyupdated=companyService.updateCompany(id,updatedCompany);
   if(isCompanyupdated){
       return new ResponseEntity("company updated successfully",HttpStatus.CREATED);
   }

 return new ResponseEntity<>("company not found",HttpStatus.NOT_MODIFIED);
    }
    @DeleteMapping("{id}")
    public ResponseEntity deleteCompany(@PathVariable("id") Long id){
        Boolean isDeleted=companyService.deleteCompany(id);
        if(isDeleted){
            return new ResponseEntity("company deleted successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("company not found",HttpStatus.NOT_MODIFIED);


    }

}
