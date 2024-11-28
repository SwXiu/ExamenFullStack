package com.cinexpress.videofriend.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinexpress.videofriend.models.Company;
import com.cinexpress.videofriend.repository.CompanyRepository;
import com.cinexpress.videofriend.services.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public void updateCompany(Long id, Company company) {
        Optional<Company> existingCompanyOpt = companyRepository.findById(id);
        
        if (existingCompanyOpt.isPresent()) {
            Company existingCompany = existingCompanyOpt.get();
            
            existingCompany.setName(company.getName());
            existingCompany.setDescription(company.getDescription());
            companyRepository.save(existingCompany);
        } else {
            throw new RuntimeException("Company not found with ID: " + id);
        }
    }

    //Función deleteCompany no nos serviría ya que solo somos una companía y si queremos cambiar algun dato tenemos el update para hacerlo 
    // @Override
    // public void deleteCompany(Long id) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'deleteCompany'");
    // }
    
}
