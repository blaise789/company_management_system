package com.codewithme.jobapp.services;

import com.codewithme.jobapp.Models.Company;
import com.codewithme.jobapp.error.CompanyNotFoundException;

import java.util.List;

public interface CompanyService {
    public List<Company> getAllCompanies();
    public Company createCompany(Company company);
    public  Company getCompany(Long id) throws CompanyNotFoundException;
    public Boolean deleteCompany(Long id);
    public  Boolean updateCompany(Long id,Company company);
}
