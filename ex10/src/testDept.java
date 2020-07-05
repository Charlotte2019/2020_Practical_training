import bean.Dept;
import bean.Emp;
import com.mchange.v2.beans.BeansUtils;
import com.mchange.v2.codegen.bean.BeangenUtils;
import dao.DeptDao;
import dao.EmpDao;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;
import org.apache.commons.beanutils.*;
import sun.misc.Request;


import javax.sound.midi.Soundbank;
import javax.xml.crypto.Data;
import java.lang.reflect.InvocationTargetException;
import java.security.Key;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class testDept {
    DeptDao deptDao=new DeptDao();
    EmpDao empDao=new EmpDao();
    Dept dept=new Dept();
    Emp emp=new Emp();

    @Test
    public void findAllEmp(){
        for (Emp emp: empDao.findAllEmp()){
            System.out.println(emp.getEmpno());
        }
    }
    @Test
    public void findByLoc(){
        Dept dept= new Dept();
        dept=deptDao.findByLoc("DALLAS");
        System.out.println(dept);
    }
    @Test
    public void changeDeptNameById(){
        System.out.println(deptDao.changeDeptNameById(40,"QAQ"));
    }
    @Test
    public void delDeptById(){

        System.out.println(deptDao.delDeptById(10));
    }
    @Test
    public void empByjob(){
        for (Emp emp:deptDao.empByjob("CLERK")){
            System.out.println(emp+"dname="+emp.getDname());
        }
    }

    @Test
    public void empByjob_2(){
        for (Map<String,Object>map : deptDao.empByjob_2("CLERK")){
            try {
                ConvertUtils.register(new DateLocaleConverter(), Date.class);
                BeanUtils.populate(emp, transformLowerCase(map));
                BeanUtils.populate(dept,transformLowerCase(map));
                System.out.println("Emp{" +
                        "empno=" + emp.getEmpno() +
                        ", ename='" + emp.getEmpno() + '\'' +
                        ", job='" + emp.getJob() + '\'' +
                        ", mgr=" + emp.getMgr() +
                        ", hiredate=" + emp.getHiredate() +
                        ", sal=" + emp.getSal() +
                        ", comm=" + emp.getComm() +
                        ", deptno=" + emp.getDeptno() +
                        ", Dname=" + dept.getDname()+
                        '}');
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void empByjob_3(){
        for (Map<String,Object>map : deptDao.empByjob_3("CLERK")){
            try {
                ConvertUtils.register(new DateLocaleConverter(), Date.class);
                BeanUtils.populate(emp, transformLowerCase(map));
                BeanUtils.populate(dept,transformLowerCase(map));
                System.out.println("Emp{" +
                        "empno=" + emp.getEmpno() +
                        ", ename='" + emp.getEmpno() + '\'' +
                        ", job='" + emp.getJob() + '\'' +
                        ", mgr=" + emp.getMgr() +
                        ", hiredate=" + emp.getHiredate() +
                        ", sal=" + emp.getSal() +
                        ", comm=" + emp.getComm() +
                        ", deptno=" + emp.getDeptno() +
                        ", Dname=" + dept.getDname()+
                        '}');
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }


    public static Map<String, Object> transformLowerCase(Map<String, Object> orgMap) {
        Map<String, Object> resultMap = new HashMap<>();
        if (orgMap == null || orgMap.isEmpty()) {
            return resultMap;
        }
        Set<String> keySet = orgMap.keySet();
        for (String key : keySet) {
            String newKey = key.toLowerCase();
            resultMap.put(newKey, orgMap.get(key));
        }
        return resultMap;
    }

}
