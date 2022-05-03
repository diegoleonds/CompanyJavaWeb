package com.example.companias.data.transform;

import com.example.companias.data.model.Company;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyTransform implements Transform<Company> {
    @Override
    public Company transformToEntity(ResultSet result) {
        Company company = new Company();
        try {
            company.setId(result.getString(""));
            company.setName(result.getString("name"));
            company.setDomain(result.getString("domain"));
            company.setYear(result.getString("year founded"));
            company.setIndustry(result.getString("industry"));
            company.setSize(result.getString("size range"));
            company.setLocality(result.getString("locality"));
            company.setCountry(result.getString("country"));
            company.setLinkedin(result.getString("linkedin url"));
            company.setCurrentEmployeeEstimate(result.getInt("current employee estimate"));
            company.setTotalEmployeeEstimate(result.getInt("total employee estimate"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return company;
    }
}






























