package dao;

import bean.Car;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import utils.DaoUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class CarDao {
    public List<Map<String,Object>> latestUsedCar(){
        QueryRunner runner=new QueryRunner(DaoUtils.DATA_SOURCE);
        String sql="select brandname,typename,mileage,price,releasedate,carid FROM brand,car,cartype\n" +
                "where brand.brandid=cartype.brandId and cartype.typeid=car.typeid and isselled=0 \n" +
                "GROUP BY car.carid\n" +
                "ORDER BY car.releaseDate desc LIMIT 10";
        try {
            return runner.query(sql,new MapListHandler());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    public List<Map<String,Object>> messageCarById(int id){
        QueryRunner runner=new QueryRunner(DaoUtils.DATA_SOURCE);
        String sql="select brandName,typeName,mileage,price,releaseDate,carid,displacement,licenceDate,cluth\n" +
                "FROM brand,car,cartype\n" +
                "where brand.brandid=cartype.brandId and cartype.typeid=car.typeid and carid=?\n";
        try {
            return runner.query(sql,new MapListHandler(),id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public Car priceByCarid(int carid){
        QueryRunner runner=new QueryRunner(DaoUtils.DATA_SOURCE);
        String sql="select price from car where carid=?";

        try {
            return runner.query(sql,new BeanHandler<Car>(Car.class),carid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public List<Map<String,Object>> carByBrandidTypeid(int brandid , int typeid){
        QueryRunner runner=new QueryRunner(DaoUtils.DATA_SOURCE);
        String sql="SELECT * from car,brand,cartype\n" +
                "where brand.brandid=cartype.brandid and cartype.typeid=car.typeid\n" +
                "and brand.brandid=? and cartype.typeid=?";
        try {
            return runner.query(sql,new MapListHandler(),brandid,typeid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public List<Map<String,Object>> findByPrice(double min,double max) {
        QueryRunner runner=new QueryRunner(DaoUtils.DATA_SOURCE);
        String sql="select c.*,b.brandName,t.typeName from car c,brand b,cartype t \n" +
                "where c.typeid=t.typeid and t.brandid=b.brandid and  price  between ? and ?;";
        try {
            return runner.query(sql,new MapListHandler(),min,max);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public List<Map<String,Object>> findByDate(String min,String max) {
        QueryRunner runner=new QueryRunner(DaoUtils.DATA_SOURCE);
        String sql="select c.*,b.brandName,t.typeName from car c,brand b,cartype t \n" +
                "where c.typeid=t.typeid and t.brandid=b.brandid and  licencedate  between ? and ?;";
        try {
            return runner.query(sql,new MapListHandler(),min,max);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public Car priceByid(int carid){
        QueryRunner runner=new QueryRunner(DaoUtils.DATA_SOURCE);
        String sql="select price,carid from car where carid=?";

        try {
            return runner.query(sql,new BeanHandler<>(Car.class),carid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }
}
