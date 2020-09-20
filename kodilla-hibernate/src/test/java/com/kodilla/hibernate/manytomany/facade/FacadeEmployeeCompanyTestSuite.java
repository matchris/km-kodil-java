package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import com.kodilla.hibernate.manytomany.facade.api.FoundException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FacadeEmployeeCompanyTestSuite {
    @Autowired
    private CompanyFacade companyFacade;
    @Autowired
    private EmployeeFacade employeeFacade;
    @Autowired
    private EmployeeDao employeeRepository;
    @Autowired
    private CompanyDao companyRepository;


    private Employee johnSmith;
    private Employee rozaKowalska;
    private Employee annaLipski;

    private Company microsoftCorp;
    private Company dataMines;
    private Company doesntMatter;

    @Before
    public void initialData() {

        johnSmith = new Employee("John", "Smith");
        rozaKowalska = new Employee("Roza", "Kowalska");
        annaLipski = new Employee("Anna", "Lipski");


        microsoftCorp = new Company("Microsoft Corp");
        dataMines = new Company("Data Mines");
        doesntMatter = new Company("Doesnt Matter");

        microsoftCorp.getEmployees().add(johnSmith);
        dataMines.getEmployees().add(rozaKowalska);
        dataMines.getEmployees().add(annaLipski);
        doesntMatter.getEmployees().add(rozaKowalska);

        johnSmith.getCompanies().add(microsoftCorp);
        rozaKowalska.getCompanies().add(dataMines);
        annaLipski.getCompanies().add(dataMines);
        annaLipski.getCompanies().add(doesntMatter);

    }

    @After
    public void CleanUp() {
        employeeRepository.deleteAll();
        companyRepository.deleteAll();
    }

    @Test
    public void testRetrieveEmployeesNamesWhereNamesLikeParam() throws FoundException {
        //Given
        //When

        companyRepository.save(microsoftCorp);
        companyRepository.save(dataMines);
        companyRepository.save(doesntMatter);

        employeeRepository.save(johnSmith);
        employeeRepository.save(rozaKowalska);
        employeeRepository.save(annaLipski);

        List<Employee> find1 = employeeFacade.findEmployeeByPartOfName("Sm");
        List<Employee> find2 = employeeFacade.findEmployeeByPartOfName("a");
        List<Employee> find3 = employeeFacade.findEmployeeByPartOfName("");
        List<Employee> find4 = employeeFacade.findEmployeeByPartOfName("weGetEmptyResult");

        //Then
        assertEquals(find1.get(0).getLastname(), johnSmith.getLastname());
        assertEquals(find2.get(0).getLastname(), rozaKowalska.getLastname());
        assertEquals(find3.get(0).getLastname(), annaLipski.getLastname());
        assertTrue(find4.isEmpty());
    }


    @Test
    public void testRetrieveCompaniesNamesWhereNamesLikeParam() throws FoundException {
        //Given
        //When

        companyRepository.save(microsoftCorp);
        companyRepository.save(dataMines);
        companyRepository.save(doesntMatter);

        employeeRepository.save(johnSmith);
        employeeRepository.save(rozaKowalska);
        employeeRepository.save(annaLipski);

        List<Company> find1 = companyFacade.findCompanyByPartOfName("m");
        List<Company> find2 = companyFacade.findCompanyByPartOfName("a");
        List<Company> find3 = companyFacade.findCompanyByPartOfName("");
        List<Company> find4 = companyFacade.findCompanyByPartOfName("weGetEmptyResult");

        //Then
        assertEquals(find1.get(0).getName(), microsoftCorp.getName());
        assertEquals(find2.get(0).getName(), dataMines.getName());
        assertEquals(find3.get(0).getName(), doesntMatter.getName());
        assertTrue(find4.isEmpty());
    }
}
