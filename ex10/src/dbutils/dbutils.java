package dbutils;

import dao.util.DataPoolUtil;
import org.apache.commons.dbutils.QueryRunner;

public class dbutils {
    public static void main(String[] args) {
        QueryRunner runner=new QueryRunner(DataPoolUtil.dataSource);

    }
}
