package dao;

import bean.Brand;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DaoUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class BrandDao {
    public List<Brand> brandsNameId(){
        QueryRunner runner=new QueryRunner(DaoUtils.DATA_SOURCE);
        String sql="select brandName,brandid from brand ";

        try {
            return runner.query(sql,new BeanListHandler<Brand>(Brand.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

}
