package com.example.companias.foundation.connection;

import com.example.companias.data.model.Company;
import com.example.companias.data.transform.CompanyTransform;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DbConfigTest {

    @Test
    void testConnection() {
        DbConfig dbConfig = new DbConfig();
        Connection connection = dbConfig.getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM compania");
            CompanyTransform transform = new CompanyTransform();
            ArrayList<Company> companies = new ArrayList<>();

            while (result.next()) {
                companies.add(transform.transformToEntity(result));
            }

            assertFalse(companies.isEmpty());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}