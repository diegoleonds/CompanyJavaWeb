package com.example.companias.controller;

import com.example.companias.data.dao.CompanyDao;
import com.example.companias.data.dao.Dao;
import com.example.companias.data.model.Company;

public class CompanyController extends Controller<Company> {

    @Override
    protected Dao<Company> getDao() {
        return CompanyDao.getInstance();
    }

}
