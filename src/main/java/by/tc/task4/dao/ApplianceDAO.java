package by.tc.task4.dao;

import ConnectionTool.ConnectionPoolException;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
public interface ApplianceDAO <T>{
    public int insert(T t) throws ConnectionPoolException, SQLException;
    // Удалить запись на основе идентификатора
    public int delete(Serializable id) throws ConnectionPoolException, SQLException;
    // Изменить запись
    public int update(T t,Serializable id) throws ConnectionPoolException, SQLException;
    // Запрос записи на основе идентификатора и возврат записи в виде объекта
    public T findById(Serializable id) throws ConnectionPoolException, SQLException;
    // Запрос всех данных, создание объекта для каждой записи в таблице и возврат его в виде коллекции
    public List<T> findAll() throws ConnectionPoolException, SQLException;
}
