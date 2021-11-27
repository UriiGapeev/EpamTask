package Print;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Print {

    public void PrintFindAllAuto(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            int auto_id =  resultSet.getInt(1);
            String model = resultSet.getString(2);
            String number= resultSet.getString(3);
            String images_url= resultSet.getString(4);
            String vehicle_haracteristics= resultSet.getString(5);
            String color= resultSet.getString(6);
            System.out.println(auto_id+" "+model+" "+number+" "+images_url+" "+vehicle_haracteristics+" "+color);
        }

    }
    public void PrintFindByIDAuto(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            int auto_id =  resultSet.getInt(1);
            String model = resultSet.getString(2);
            String number= resultSet.getString(3);
            String images_url= resultSet.getString(4);
            String vehicle_haracteristics= resultSet.getString(5);
            String color= resultSet.getString(6);
            System.out.println(auto_id+" "+model+" "+number+" "+images_url+" "+vehicle_haracteristics+" "+color);
        }

    }
}
