package dao.util;

import java.sql.*;

public class DaoUtil {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        Connection connection=null;
        try {
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/ex07?useUnicode=true&characterEncoding=utf8","root","");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    public static void close(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if (connection!=null){
                connection.close();
            }
            if (statement!=null){
                statement.close();
            }
            if (resultSet!=null){
                resultSet.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void close(Connection connection, Statement statement){
        try {
            if (connection!=null){
                connection.close();
            }
            if (statement!=null){
                statement.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
