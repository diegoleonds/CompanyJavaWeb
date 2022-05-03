package com.example.companias.controller;

import com.example.companias.data.dao.Dao;
import com.example.companias.data.model.Entity;
import com.example.companias.foundation.BasicIoOperations;
import java.util.List;

public abstract class Controller<E extends Entity> implements BasicIoOperations<E, E> {

    protected abstract Dao<E> getDao();

    @Override
    public void insert(E entity) {
        getDao().insert(entity);
    }

    @Override
    public void delete(E entity) {
        getDao().delete(entity);
    }

    @Override
    public void updateEntity(E entity) {
        getDao().updateEntity(entity);
    }

    @Override
    public E getById(String id) {
        return getDao().getById(id);
    }

    @Override
    public List<E> getEntities(int page, int quantity) {
        return getDao().getEntities(page, quantity);
    }
}