package com.example.companias.data.dao;

import com.example.companias.data.model.Company;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompanyDaoTest {

    CompanyDao dao = CompanyDao.getInstance();

    @Test
    void getInstanceShouldReturnAlwaysTheSameInstance() {
        CompanyDao secondDao = CompanyDao.getInstance();
        assertEquals(dao, secondDao);
    }

    @Test
    void shouldGetOnlyOneCompanyFromDb() {
        assertEquals(1, dao.getEntities(0, 1).size());
    }

    @Test
    void getAllFromDb() {
        assertEquals(999, dao.getEntities(0, 0).size());
    }

    @Test
    void shouldGetOnlyIbmFromDb() {
        List<Company> resultFromDb = dao.getEntities(0, 1);
        Company compania = resultFromDb.get(0);

        assertEquals(1, resultFromDb.size());
        assertEquals("5872184", compania.getId());
        assertEquals("ibm", compania.getName());
        assertEquals("ibm.com", compania.getDomain());
        assertEquals("1911.0", compania.getYear());
        assertEquals("information technology and services", compania.getIndustry());
        assertEquals("10001+", compania.getSize());
        assertEquals("new york, new york, united states", compania.getLocality());
        assertEquals("10001+", compania.getSize());
        assertEquals("united states", compania.getCountry());
        assertEquals("linkedin.com/company/ibm", compania.getLinkedin());
        assertEquals(274047, compania.getCurrentEmployeeEstimate());
        assertEquals(716906, compania.getTotalEmployeeEstimate());
    }

    @Test
    void shouldInsertInDatabase() {
        int previousQuantity = dao.getEntities(0, 0).size();
        dao.insert(
                new Company(
                        "1000",
                        "Nome",
                        "dominio",
                        "1990",
                        "industria",
                        "grande",
                        "SP",
                        "Brasil",
                        "perdi",
                        10,
                        2
                )
        );
        int updatedQuantity = dao.getEntities(0, 0).size();
        assertEquals(previousQuantity + 1, updatedQuantity);
    }
}