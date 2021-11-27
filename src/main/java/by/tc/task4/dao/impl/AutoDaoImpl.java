package by.tc.task4.dao.impl;

import ConnectionTool.ConnectionPool;
import ConnectionTool.ConnectionPoolException;
import Print.Print;
import by.tc.task4.dao.AutoDao;
import by.tc.task4.dao.entity.Auto;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class AutoDaoImpl implements AutoDao {
    Statement st = null;
    private static final Logger logger = Logger.getLogger(AutoDaoImpl.class);


    @Override
    public int insert(Auto auto) throws ConnectionPoolException, SQLException {
        String sql="INSERT INTO `rentcars`.`auto` (`model`, `number`, `images_url`, `vehicle_haracteristics`, `color`) VALUES ("
                +"'"+auto.getModel()+"','"+auto.getNumber() +"','"+auto.getImages_url()+"','"+auto.getVehicle_haracteristics()+"','"+auto.getColor()+"'"+")";
        ConnectionPool connectionPool = new ConnectionPool();
        connectionPool.initPoolData();
        Connection connection = connectionPool.takeConnection();
        st = connection.createStatement();
        try{
            logger.log(Level.INFO, "Успешно добавлено");
            System.out.println("Успешно добавлено");
            int  result = ConnectionPool.executeUpdate (st,sql);
            //connectionPool.putConnection(connection);
            connectionPool.closeConnection(connection,st);
            connectionPool.dispose();
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return 0;
    }

    @Override
    public int delete(Serializable id) throws ConnectionPoolException, SQLException {
        String sql="DELETE FROM `rentcars`.`auto` WHERE (`id` = "+id+")";
        ConnectionPool connectionPool = new ConnectionPool();
        connectionPool.initPoolData();
        Connection connection = connectionPool.takeConnection();
        st = connection.createStatement();
        try{
            int  result = ConnectionPool.executeUpdate (st,sql);
            //connectionPool.putConnection(connection);
            connectionPool.closeConnection(connection,st);
            connectionPool.dispose();
            logger.log(Level.INFO, "Успешно удалено");

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(Auto auto,Serializable id) throws ConnectionPoolException, SQLException {
        String sql="UPDATE `rentcars`.`auto` SET `model` = '"+auto.getModel()+"' WHERE (`id` = "+id+")";
        ConnectionPool connectionPool = new ConnectionPool();
        connectionPool.initPoolData();
        Connection connection = connectionPool.takeConnection();
        st = connection.createStatement();
        try{
            System.out.println("Успешно добавлено");
            int  result = ConnectionPool.executeUpdate (st,sql);
            //connectionPool.putConnection(connection);
            connectionPool.closeConnection(connection,st);
            connectionPool.dispose();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public Auto findById(Serializable id) throws ConnectionPoolException, SQLException {
        String sql = "select * from auto where id="+id;
        ConnectionPool connectionPool = new ConnectionPool();
        connectionPool.initPoolData();
        Connection connection = connectionPool.takeConnection();
        st = connection.createStatement();
        ResultSet resultSet = ConnectionPool.executeQuery(st,sql);
        //connectionPool.putConnection(connection);

        Print print = new Print();
        print.PrintFindByIDAuto(resultSet);
        connectionPool.closeConnection(connection,st);
        connectionPool.dispose();
        return null;
    }

    @Override
    public List<Auto> findAll() throws ConnectionPoolException, SQLException {
        String sql = "select * from auto";
        ConnectionPool connectionPool = new ConnectionPool();
        connectionPool.initPoolData();
        Connection connection = connectionPool.takeConnection();
        st = connection.createStatement();
        ResultSet resultSet = ConnectionPool.executeQuery(st,sql);
        //connectionPool.putConnection(connection);

        Print print = new Print();
        print.PrintFindAllAuto(resultSet);
        connectionPool.closeConnection(connection,st);
        connectionPool.dispose();
        return null;
    }

}
