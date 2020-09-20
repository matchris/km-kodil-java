package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.facade.api.FoundException;
import com.kodilla.hibernate.manytomany.facade.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyFacade {

    @Autowired
    private CompanyService companyService;

    private final static Logger LOGGER = LoggerFactory.getLogger(CompanyFacade.class);

    public List<Company> findCompanyByPartOfName(String name) throws FoundException {
        LOGGER.info("Searching companies by part of name...");
        if (name.length() < 1) {
            LOGGER.error(FoundException.ERR_TOO_SHORT_PHRASE_PROVIDED);
            throw new FoundException(FoundException.ERR_TOO_SHORT_PHRASE_PROVIDED);
        }
        LOGGER.info("Finding by name completed");
        return companyService.findByPartOfCompanyName(name);

    }
}

