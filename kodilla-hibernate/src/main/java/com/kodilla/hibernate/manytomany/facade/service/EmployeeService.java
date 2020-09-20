package com.kodilla.hibernate.manytomany.facade.service;

import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeDao employeeDao;

    public List<Employee> findByPartOfEmployeeName(String name) {
        return employeeDao.retrieveByEmployeePartOfLastName(name);
    }
}
