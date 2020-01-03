package com.gl.springbootcrudjpaoracledemo.dao;

import java.util.List;

public interface CrudDao<T, ID> {
    List<T> findAll();

    T findById(ID id);

    T save(T newObject);

    void delete(T object);

    void deleteById(ID id);

}
