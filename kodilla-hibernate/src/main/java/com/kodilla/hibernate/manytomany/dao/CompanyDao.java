package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface CompanyDao extends CrudRepository<Company, Integer> {
    @Query(nativeQuery = true)
    List<Company> retrieveCompanyFirstThreeLettersOfName(@Param("SEARCHFIRSTTHREELETTERS") String searchfirstthreeletters);

    @Query(nativeQuery = true)
    List<Company> retrieveCompanyLongerThanSomeNumber(@Param("NUMBEROFNAMELENGHTCONSTRAIN") int numberofnamelengthconstrain);

    @Query(nativeQuery = true)
    List<Company> retrieveCompanyContainingAnyPartOfTextInName(@Param("ANYPARTOFTEXTINNAME") String anypartoftextinname);
}