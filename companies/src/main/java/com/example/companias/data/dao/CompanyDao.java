package com.example.companias.data.dao;

import com.example.companias.data.model.Company;
import com.example.companias.data.transform.CompanyTransform;
import com.example.companias.data.transform.Transform;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CompanyDao extends Dao<Company> {

    private final CompanyTransform transform = new CompanyTransform();
    private static CompanyDao instance;

    private CompanyDao() {

    }

    public static CompanyDao getInstance() {
        if (instance == null)
            instance = new CompanyDao();

        return instance;
    }

    @Override
    protected String getTableName() { return "compania"; }

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO " + getTableName() + " (\"\",name,domain,\"year founded\",industry,\"size range\"," +
                "locality,country,\"linkedin url\",\"current employee estimate\",\"total employee estimate\") " +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
    }

    @Override
    protected Transform<Company> getTransform() { return transform; }

    @Override
    protected void populateStatement(PreparedStatement preparedStatement, Company company) throws SQLException {
        preparedStatement.setString(1, company.getId());
        preparedStatement.setString(2, company.getName());
        preparedStatement.setString(3, company.getDomain());
        preparedStatement.setString(4, company.getYear());
        preparedStatement.setString(5, company.getIndustry());
        preparedStatement.setString(6, company.getSize());
        preparedStatement.setString(7, company.getLocality());
        preparedStatement.setString(8, company.getCountry());
        preparedStatement.setString(9, company.getLinkedin());
        preparedStatement.setInt(10, company.getCurrentEmployeeEstimate());
        preparedStatement.setInt(11, company.getTotalEmployeeEstimate());
    }
}




















