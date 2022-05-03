package com.example.companias.data.dao;

import com.example.companias.data.model.Entity;
import com.example.companias.data.transform.Transform;
import com.example.companias.foundation.BasicIoOperations;
import com.example.companias.foundation.connection.DbConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Dao<E extends Entity> implements BasicIoOperations<E, E> {
    final DbConfig dbConfig = new DbConfig();

    protected abstract String getTableName();

    protected abstract String getInsertQuery();

    protected abstract Transform<E> getTransform();

    protected abstract void populateStatement(PreparedStatement preparedStatement, E entity) throws SQLException;

    protected String getSelectEntitiesQuery(int page, int quantity) {
        return "SELECT * FROM " + getTableName() + " LIMIT " + quantity + " OFFSET " + page;
    }

    @Override
    public void insert(E entity) {
        try {
            Connection connection = dbConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(getInsertQuery());

            populateStatement(preparedStatement, entity);
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<E> getEntities(int page, int quantity) {
        ArrayList<E> entities = new ArrayList<>();
        try {
            if (dbConfig.getConnection() != null) {
                Statement statement = dbConfig.getConnection().createStatement();
                ResultSet result = statement.executeQuery(getSelectEntitiesQuery(page, quantity));

                while (result.next()) {
                    entities.add(getTransform().transformToEntity(result));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entities;
    }

    @Override
    public void delete(E entity) {
        //TODO
//        String query = "DELETE FROM " + getTableName() + " WHERE  = " + entity.getId();
//        try {
//            Statement statement = dbConfig.getConnection().createStatement();
//            statement.executeQuery(query);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void updateEntity(E input) {
        // TODO
    }

    @Override
    public E getById(String id) {
        // TODO
        return null;
//        String query = "SELECT * FROM " + getTableName() + " WHERE  = " + id;
//        E entity = null;
//
//        try {
//            Statement statement = dbConfig.getConnection().createStatement();
//            ResultSet result = statement.executeQuery(query);
//
//            if (result.next()) {
//                entity = getTransform().transformToEntity(result);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return entity;
    }
}