package client;

import bean.Emp;
import dao.EmpDao;

import javax.sound.midi.Soundbank;

public class EmpManage {

    EmpDao empDao=new EmpDao();

    public static void main(String[] args) {
        EmpManage empManage=new EmpManage();
        empManage.main();
    }
    public void main(){
        //添加新员工
        System.out.println(empDao.addEmp());

        //根据员工编号修改员工工资
        System.out.println(empDao.changeEmpSal(4396,10000.00));

        //根据员工编号删除员工
        System.out.println(empDao.deleteEmp(9527));

        //查询所有员工
        for (Emp emp:empDao.allEmp()){
            System.out.println(emp);
        }

        //根据员工的工号查询
        System.out.println(empDao.idEmp(4396));

        //根据员工的姓名模糊查询
        for (Emp emp:empDao.nameEmp("S")){
            System.out.println(emp);
        }

    }
}
