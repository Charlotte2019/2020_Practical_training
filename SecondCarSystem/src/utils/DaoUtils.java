package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DaoUtils {
    public static final ComboPooledDataSource DATA_SOURCE =new ComboPooledDataSource();

    public static Connection openConn(){
        try {
            return DATA_SOURCE .getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public static void close(Connection connection, Statement st){
        try {
            if (connection!=null){
                connection.close();
            }
            if (st!=null){
                st.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void close(Connection connection, Statement st, ResultSet rs){
        try {
            if (connection!=null){
                connection.close();
            }
            if (st!=null){
                st.close();
            }
            if (rs!=null){
                rs.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
