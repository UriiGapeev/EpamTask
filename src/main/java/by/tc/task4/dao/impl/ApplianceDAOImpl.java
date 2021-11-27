package by.tc.task4.dao.impl;

import by.tc.task4.dao.ApplianceDAO;

import java.io.Serializable;
import java.util.List;

public class ApplianceDAOImpl<T> implements ApplianceDAO<T> {

    @Override
    public int insert(T t) {
        return 0;
    }

    @Override
    public int delete(Serializable id) {
        return 0;
    }

    @Override
    public int update(T t,Serializable id) {
        return 0;
    }

    @Override
    public T findById(Serializable id) {
        return null;
    }

    @Override
    public List<T> findAll() {
        return null;
    }
}
