package dao;

import bean.Emp;
import dao.util.DataPoolUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class EmpDao {
    public int insertEmp(Emp emp){
        QueryRunner runner=new QueryRunner(DataPoolUtil.dataSource);
        String sql="insert into emp values(?,?,?,?,?,?,?,?)";

        try {
            return runner.update(sql, emp.getEmpno(),emp.getEname(),emp.getJob(),emp.getMgr(),emp.getHiredate(),emp.getSal(),emp.getComm(),emp.getDeptno());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return 0;
    }

    public List<Emp> findAllEmp(){
        QueryRunner runner=new QueryRunner(DataPoolUtil.dataSource);
        String sql="select empno,ename,job,mgr,hiredate,sal,comm,deptno from emp";

        try {
            return runner.query(sql,new BeanListHandler<Emp>(Emp.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    public List<Emp> findByNameLike(String name){
        QueryRunner runner=new QueryRunner(DataPoolUtil.dataSource);
        String sql="select * from where ename like ?";

        try {
            return runner.query(sql,new BeanListHandler<Emp>(Emp.class),"%"+name+"%");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }
}
