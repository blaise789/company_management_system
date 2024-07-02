package com.codewithme.jobapp.repositories;

import com.codewithme.jobapp.Models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {
    List<Company> findCompaniesByNameContainingIgnoreCase(String name);
}
