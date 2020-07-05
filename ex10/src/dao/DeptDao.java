package dao;

import bean.Dept;
import bean.Emp;
import dao.util.DataPoolUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DeptDao {

    public List<Dept> findAll(){
        QueryRunner runner=new QueryRunner(DataPoolUtil.dataSource);
        String sql="select * from dept";

        try {
            return runner.query(sql,new BeanListHandler<Dept>(Dept.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    public Dept findByLoc(String loc){
        QueryRunner runner=new QueryRunner(DataPoolUtil.dataSource);
        String sql="select * from dept where loc=?";

        try {
            return runner.query(sql,new BeanHandler<Dept>(Dept.class),loc);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    public int changeDeptNameById(int deptno,String dname){
        QueryRunner runner=new QueryRunner(DataPoolUtil.dataSource);
        String sql="update dept set dname=? where deptno=?";

        try {
            return runner.update(sql,dname,deptno);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return 0;
    }

    public boolean delDeptById(int deptno){
        QueryRunner runner=new QueryRunner(DataPoolUtil.dataSource);
        String sql1="delete from emp where empno in(select * from(select empno from emp where deptno=?)as a)";
        String sql2="delete from dept where deptno=?";

        try {
            if (runner.update(sql1,deptno)!=0&&runner.update(sql2,deptno)!=0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    public List<Emp> empByjob(String job){
        QueryRunner runner=new QueryRunner(DataPoolUtil.dataSource);
        String sql="select emp.*,dept.dname from emp,dept where emp.deptno=dept.deptno and job = ?";
        try {
            return  runner.query(sql,new BeanListHandler<Emp>(Emp.class),job);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public List<Map<String,Object>> empByjob_2(String job){
        QueryRunner runner=new QueryRunner(DataPoolUtil.dataSource);
        String sql="select emp.*,dept.dname from emp,dept where emp.deptno=dept.deptno and job = ?";

        try {
            return runner.query(sql,new MapListHandler(),job);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public List<Map<String,Object>> empByjob_3(String job){
        QueryRunner runner=new QueryRunner(DataPoolUtil.dataSource);
        String sql="select emp.*,dept.dname from emp,dept \n" +
                "where emp.deptno=dept.deptno and job= ? \n" +
                "GROUP BY EMPNO\n" +
                "ORDER BY HIREDATE";
        try {
            return runner.query(sql,new MapListHandler(),job);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
