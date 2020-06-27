package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {

    @Query
    List<Employee> retrieveEmployeeLastname(@Param("SEARCHLASTNAME") String searchlastname);

    @Query(nativeQuery = true)
    List<Employee> retrieveByEmployeePartOfLastName(@Param("PARTOFLASTNAME") String partoflastname);
}
