package com.cinexpress.videofriend.services;

import com.cinexpress.videofriend.models.Company;

public interface CompanyService {
    void createCompany(Company company);
    //void deleteCompany(Long id); No sirve porque tenemos update y solo es una empresa
    void updateCompany(Long id, Company company);
}
