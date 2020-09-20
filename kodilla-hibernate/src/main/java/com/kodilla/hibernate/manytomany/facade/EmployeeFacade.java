package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.facade.api.FoundException;
import com.kodilla.hibernate.manytomany.facade.service.EmployeeService;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeFacade {

    @Autowired
    private EmployeeService employeeService;

    private final static Logger LOGGER = LoggerFactory.getLogger(EmployeeFacade.class);

    public List<Employee> findEmployeeByPartOfName(String name) throws FoundException {
        LOGGER.info("Finding employees by part of name");
        if (name.length() < 1) {
            LOGGER.error(FoundException.ERR_TOO_SHORT_PHRASE_PROVIDED);
            throw new FoundException(FoundException.ERR_TOO_SHORT_PHRASE_PROVIDED);
        }
        LOGGER.info("Founding by name completed.");
        return employeeService.findByPartOfEmployeeName(name);
    }
}
