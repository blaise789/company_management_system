package com.codewithme.jobapp.services;

import com.codewithme.jobapp.Entities.Company;

import java.util.List;

public interface CompanyService {
    public List<Company> getAllCompanies();
    public Company createCompany(Company company);
    public  Company getCompany(Long id);
    public Boolean deleteCompany(Long id);
    public  Boolean updateCompany(Long id,Company company);
}
