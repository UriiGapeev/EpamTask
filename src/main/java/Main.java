import ConnectionTool.ConnectionPoolException;

import by.tc.task4.dao.entity.Auto;
import by.tc.task4.dao.impl.AutoDaoImpl;
import org.apache.log4j.Logger;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws ConnectionPoolException, SQLException {

        AutoDaoImpl autoDao = new AutoDaoImpl();
        // удаление по ID
        autoDao.delete(11);
        //
        Auto auto = new Auto("volkswagen","5555-рк7","http:\\images\\volkswagen1",
                "Скорость -250; мощность мотора - 210; Скорость до 100 - 7 сек.","Красный");
        autoDao.insert(auto);


        // изменение в строке
        Auto auto1 = new Auto("volkswagen22","5555-рк7","http:\\images\\volkswagen1",
                "Скорость -250; мощность мотора - 210; Скорость до 100 - 7 сек.","Красный");
        autoDao.update(auto1, 5);

        // вывод всего на экран
        autoDao.findAll();

        // вывод по ID
        autoDao.findById(1);


    }

}
