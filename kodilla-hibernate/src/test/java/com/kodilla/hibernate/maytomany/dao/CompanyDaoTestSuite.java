package com.kodilla.hibernate.maytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTestSuite {
    @Autowired
    CompanyDao companyDao;

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

        //Then
        Assert.assertNotEquals(0, dataMinesId);
        Assert.assertNotEquals(0, microsoftCorpId);
        Assert.assertNotEquals(0, doesntMatterId);

        //CleanUp
//        try {
//            companyDao.deleteById(dataMinesId);
//            companyDao.deleteById(microsoftCorpId);
//            companyDao.deleteById(doesntMatterId);
//        } catch (Exception e) {
//            //do nothing
//        }
    }
}
