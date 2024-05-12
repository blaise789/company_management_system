package com.codewithme.jobapp.services.impl;

import com.codewithme.jobapp.Entities.Company;
import com.codewithme.jobapp.repositories.CompanyRepository;
import com.codewithme.jobapp.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private  final CompanyRepository companyRepository;
    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company createCompany(Company company) {

            return companyRepository.save(company);


    }

    @Override
    public Company getCompany(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean deleteCompany(Long id) {
        Optional<Company> companyToDelete=companyRepository.findById(id);
        if(companyToDelete.isPresent()){
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateCompany(Long id,Company updatedCompany) {
        Optional<Company> companyOptional=companyRepository.findById(id);
        if(companyOptional.isPresent()){
            Company company=companyOptional.get();
            company.setName(updatedCompany.getName());
            company.setDescription(updatedCompany.getDescription());
            companyRepository.save(company);
            return  true;

        }
return false;

    }
}
