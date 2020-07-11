package dao;

import bean.Car;
import bean.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DaoUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class UserDao {
    public List<User> findNamePwd() {
        QueryRunner runner = new QueryRunner(DaoUtils.DATA_SOURCE);
        String sql = "select username,password from user";

        try {
            return runner.query(sql, new BeanListHandler<User>(User.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public boolean addUser(User user) {
        QueryRunner runner = new QueryRunner(DaoUtils.DATA_SOURCE);
        String sql = "insert into user values (?,?,?,?,0)";
        try {
            return runner.update(sql, user.getUsername(), user.getPassword(), user.getBalance(), user.getIsAdmin()) != 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public int shopCarByCarid(User user, Car car) {
        QueryRunner runner = new QueryRunner(DaoUtils.DATA_SOURCE);
        String sql1 = "update car set isselled=1 where carid=?";
        String sql2 = "update user set balance=balance-? where username=?";

        try {
            runner.update(sql1, car.getCarid());
            runner.update(sql2, car.getPrice(), user.getUsername());
            return 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return 0;
    }

    public User balanceByid() {
        QueryRunner runner = new QueryRunner(DaoUtils.DATA_SOURCE);
        String sql = "select balance,username from user where token=?";

        try {
            return runner.query(sql, new BeanHandler<>(User.class), User.token);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    public boolean login(String username, String password) {
        QueryRunner runner = new QueryRunner(DaoUtils.DATA_SOURCE);
        String queryUser = "select * from user where username = ? and password = ?";
        String sql = "update user set token=? where username=?";
        try {
            List<User> users = (List<User>) runner.query(queryUser, new BeanListHandler(User.class), username, password);
            if (users != null && users.size() > 0) {
                User.token = UUID.randomUUID().toString();
                runner.update(sql, User.token, username);
                return true;
            }
            return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public boolean userExist(String username) {
        QueryRunner runner = new QueryRunner(DaoUtils.DATA_SOURCE);
        String queryUser = "select * from user where username = ?";
        try {
            List<User> users = (List<User>) runner.query(queryUser, new BeanListHandler(User.class), username);
            if (users != null && users.size() > 0) {
                return true;
            }
            return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public boolean isLogin() {
        QueryRunner runner = new QueryRunner(DaoUtils.DATA_SOURCE);
        String queryUser = "select * from user where token = ?";
        try {
            List<User> users = (List<User>) runner.query(queryUser, new BeanListHandler(User.class), User.token);
            if (users != null && users.size() > 0) {
                return true;
            }
            return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
}
