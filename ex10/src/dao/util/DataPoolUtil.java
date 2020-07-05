package dao.util;


import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataPoolUtil {
    public static final ComboPooledDataSource dataSource=new ComboPooledDataSource();

    public static Connection openConn(){
        try {
            return dataSource.getConnection();
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
