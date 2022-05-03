package com.example.companias.data.dao;

import com.example.companias.data.model.Company;
import org.junit.jupiter.api.Test;

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