package com.example.companias.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompanyControllerTest {

    CompanyController controller = new CompanyController();

    @Test
    public void testGetCompanies() {
        assertEquals(999, controller.getEntities(0, 0).size());
    }
}