package com.kodilla.hibernate.manytomany.facade.service;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    CompanyDao companyDao;

    public List<Company> findByPartOfCompanyName(String name) {
        return companyDao.retrieveCompanyContainingAnyPartOfTextInName(name);
    }
}
