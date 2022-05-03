package com.example.companias.foundation;

import java.util.List;

public interface BasicIoOperations<I, O> {

    public void insert(I input);
    public void delete(I input);
    public void updateEntity(I input);
    public List<O> getEntities(int page, int quantity);
    public O getById(String id);
}
