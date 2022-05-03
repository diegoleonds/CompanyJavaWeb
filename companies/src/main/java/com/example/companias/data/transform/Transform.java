package com.example.companias.data.transform;

import com.example.companias.data.model.Entity;

import java.sql.ResultSet;

public interface Transform<E extends Entity> {
    public E transformToEntity(ResultSet result);
//    public ResultSet transformFromEntity(E e);
}
