package dao;

import bean.Emp;
import dao.util.DaoUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class EmpDao {

        Connection conn=null;
        ResultSet rs=null;
        PreparedStatement ps=null;
        Scanner scanner=new Scanner(System.in);

    /**
     * 添加新员工
     * @return bool
     */
    public boolean addEmp(){
        System.out.println("输入员工编号");
        int empno=scanner.nextInt();
        System.out.println("输入员工姓名");
        String ename=scanner.next();
        System.out.println("输入员工工作");
        String job=scanner.next();
        System.out.println("输入员工领导编号");
        int mgr=scanner.nextInt();
        System.out.println("输入员工入职时间");
        String hiredate=scanner.next();
        System.out.println("输入员工工资");
        double sal=scanner.nextDouble();
        System.out.println("输入员工奖金");
        double comm=scanner.nextDouble();
        System.out.println("输入员工部门编号");
        int deptno=scanner.nextInt();

        conn = DaoUtil.getConnection();
        boolean bool=false;
        String sql="insert into emp values(?,?,?,?,?,?,?,?)";
        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1,empno);
            ps.setString(2,ename);
            ps.setString(3,job);
            ps.setInt(4,mgr);
            ps.setString(5,hiredate);
            ps.setDouble(6,sal);
            ps.setDouble(7,comm);
            ps.setInt(8,deptno);

            int rs=ps.executeUpdate();
            if (rs>0){
                bool=true;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DaoUtil.close(conn,ps);
        }
        return bool;
    }

    /**
     * 根据员工编号修改员工工资
     * @return bool
     */
    public boolean changeEmpSal(int empno,double sal){

        boolean bool=false;
        conn=DaoUtil.getConnection();
        String sql="update emp set sal=sal+? where empno=?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setDouble(1,sal);
            ps.setInt(2,empno);

            int rs=ps.executeUpdate();
            if (rs>0){
                bool=true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DaoUtil.close(conn,ps);
        }
        return bool;
    }

    /**
     * 根据员工编号删除员工
     * @param empno
     * @return bool
     */
    public boolean deleteEmp(int empno){
        boolean bool=false;
        conn=DaoUtil.getConnection();
        String sql="delete from emp where empno=?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1,empno);

            int rs=ps.executeUpdate();
            if (rs>0){
                bool=true;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DaoUtil.close(conn,ps);
        }
        return bool;
    }

    /**
     * 查询所有员工
     * @return empArrayList
     */
    public ArrayList<Emp> allEmp(){
        ArrayList<Emp> empArrayList=new ArrayList<>();
        conn=DaoUtil.getConnection();
        String sql="select * from emp";

        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();

            while (rs.next()){

                int empno=rs.getInt("empno");
                String ename=rs.getString("ename");
                String job=rs.getString("job");
                int mgr=rs.getInt("mgr");
                Date hiredate=rs.getDate("hiredate");
                double sal=rs.getDouble("sal");
                double comm=rs.getDouble("comm");
                int deptno=rs.getInt("deptno");

                Emp emp = new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno);
                empArrayList.add(emp);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DaoUtil.close(conn,ps,rs);
        }

        return empArrayList;
    }

    /**
     * 根据员工的工号查询
     * @param empno
     * @return emp
     */
    public Emp idEmp(int empno){
        conn=DaoUtil.getConnection();
        String sql="select * from emp where empno=?";
        Emp emp=null;

        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1,empno);
            rs=ps.executeQuery();

            while (rs.next()){
                String ename=rs.getString("ename");
                String job=rs.getString("job");
                int mgr=rs.getInt("mgr");
                Date hiredate=rs.getDate("hiredate");
                double sal=rs.getDouble("sal");
                double comm=rs.getDouble("comm");
                int deptno=rs.getInt("deptno");

                emp=new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DaoUtil.close(conn,ps,rs);
        }
        return emp;
    }

    /**
     * 根据员工的姓名模糊查询
     * @param ename
     * @return
     */
    public ArrayList<Emp> nameEmp(String ename){
        ArrayList<Emp> empArrayList=new ArrayList<>();
        conn=DaoUtil.getConnection();
        String sql="SELECT * FROM emp WHERE ename LIKE \"%\"?\"%\" ";

        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,ename);
            rs=ps.executeQuery();
            while (rs.next()){

                int empno=rs.getInt("empno");
                String name=rs.getString("ename");
                String job=rs.getString("job");
                int mgr=rs.getInt("mgr");
                Date hiredate=rs.getDate("hiredate");
                double sal=rs.getDouble("sal");
                double comm=rs.getDouble("comm");
                int deptno=rs.getInt("deptno");

                Emp emp = new Emp(empno, name, job, mgr, hiredate, sal, comm, deptno);
                empArrayList.add(emp);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DaoUtil.close(conn,ps,rs);
        }
        return empArrayList;
    }
}
