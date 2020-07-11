package dao;

import bean.CarType;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DaoUtils;

import java.sql.SQLException;
import java.util.List;

public class CarTypeDao {
    public List<CarType> carTypeNameIdByBrandid(int id){
        QueryRunner runner=new QueryRunner(DaoUtils.DATA_SOURCE);
        String sql="SELECT cartype.typeName,typeid from cartype,brand \n" +
                "where brand.brandid=cartype.brandid and cartype.brandid=?";
        try {
            return runner.query(sql,new BeanListHandler<>(CarType.class),id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
