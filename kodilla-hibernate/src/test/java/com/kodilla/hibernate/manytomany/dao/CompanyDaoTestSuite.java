package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTestSuite {
    @Autowired
    CompanyDao companyDao;

    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee rozaKowalska = new Employee("Roza", "Kowalska");
        Employee annaLipski = new Employee("Anna", "Lipsk");
        Employee lindaKowalsky = new Employee("Linda", "Kowalski");
        Employee markTrocki = new Employee("Mark", "Trocki");

        Company microsoftCorp = new Company("Microsoft Corp.");
        Company dataMines = new Company("Data Mines");
        Company doesntMatter = new Company("Doesnt Matter");

        microsoftCorp.getEmployees().add(johnSmith);
        dataMines.getEmployees().add(rozaKowalska);
        dataMines.getEmployees().add(annaLipski);
        dataMines.getEmployees().add(lindaKowalsky);
        doesntMatter.getEmployees().add(markTrocki);
        doesntMatter.getEmployees().add(lindaKowalsky);

        johnSmith.getCompanies().add(microsoftCorp);
        rozaKowalska.getCompanies().add(dataMines);
        annaLipski.getCompanies().add(dataMines);
        lindaKowalsky.getCompanies().add(dataMines);
        lindaKowalsky.getCompanies().add(doesntMatter);
        markTrocki.getCompanies().add(doesntMatter);

        //When
        companyDao.save(microsoftCorp);
        int microsoftCorpId = microsoftCorp.getId();
        companyDao.save(dataMines);
        int dataMinesId = dataMines.getId();
        companyDao.save(doesntMatter);
        int doesntMatterId = doesntMatter.getId();

        List<Employee> smithsList = employeeDao.retrieveEmployeeLastname("Smith");
        int numberOfSmiths = smithsList.size();
//        List<Employee> partOfLastNameList = employeeDao.retrieveByEmployeePartOfLastName("alsk");
//        int numberOfPartLastNames = partOfLastNameList.size();
        List<Company> namesCompaniesLongerThan5 = companyDao.retrieveCompanyLongerThanSomeNumber(5);
        int numberOfCompaniesWithNamesLongerThan5 = namesCompaniesLongerThan5.size();
//        List<Company> namesCompaniesIncludedMatt = companyDao.retrieveCompanyContainingAnyPartOfTextInName("Matt");
//        int numberOfCompaniesWithNamesIncludedMatt = namesCompaniesIncludedMatt.size();
        List<Company> namesWithFirstThreeLetters = companyDao.retrieveCompanyFirstThreeLettersOfName("Dat");
        int numberOfCompaniesWithNamesWithFirstThreeLetters = namesWithFirstThreeLetters.size();


        //Then
        Assert.assertNotEquals(0, dataMinesId);
        Assert.assertNotEquals(0, microsoftCorpId);
        Assert.assertNotEquals(0, doesntMatterId);

        Assert.assertNotEquals(0, numberOfSmiths);
//        Assert.assertNotEquals(0,numberOfPartLastNames);
        Assert.assertNotEquals(0,numberOfCompaniesWithNamesLongerThan5);
//        Assert.assertNotEquals(0,numberOfCompaniesWithNamesIncludedMatt);
        Assert.assertNotEquals(0,numberOfCompaniesWithNamesWithFirstThreeLetters);

        //CleanUp
        try {
            companyDao.deleteById(dataMinesId);
            companyDao.deleteById(microsoftCorpId);
            companyDao.deleteById(doesntMatterId);

            employeeDao.deleteById(numberOfSmiths);
//            employeeDao.deleteById(numberOfPartLastNames);
            companyDao.deleteById(numberOfCompaniesWithNamesLongerThan5);
//            companyDao.deleteById(numberOfCompaniesWithNamesIncludedMatt);
        } catch (Exception e) {
            //do nothing
        }
    }
}
