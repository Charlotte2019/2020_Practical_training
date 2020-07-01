import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class checkPage {
    public static void main(String[] args) {
//        Date date=new Date();
//        Teacher teacher1=new Teacher("q","q","q","q",1);
//        Teacher teacher2=new Teacher("a","q","a","q",1);
//        Student student1=new Student("q","q","q",1,date,1);
//        Student student2=new Student("a","q","q",1,date,1);
//        ArrayList<Teacher> teacherArrayList = new ArrayList<>();
//        teacherArrayList.add(teacher1);
//        teacherArrayList.add(teacher2);
//        db_teacher.setTeacherArrayList(teacherArrayList);
//        ArrayList<Student> studentArrayList = new ArrayList<>();
//        studentArrayList.add(student1);
//        studentArrayList.add(student2);
//        db_student.setStudentArrayList(studentArrayList);
        dateAll dateAll = new dateAll();
        dateAll.assemble();
        main();
    }
    
    public static void main(){
        System.out.println("1、登陆");
        System.out.println("2、注册");
        System.out.println("3、退出");
        do {
            String check= tool.ScannerString();
            String regex="[1-3]";
            if(check.matches(regex)){
                switch (check){
                    case "1":
                        Login();
                        break;
                    case "2":
                        Register();
                        break;
                    case "3":
                        System.out.println("成功退出");
                        System.exit(0);
                }
                break;
            }
            System.err.println("!输入有误!");
            System.out.println("重新选择或者按3退出.");
        }while (true);
    }
    
    public static void Login(){
        int lognum=3;
        while (lognum!=0){
            lognum--;
            boolean flag=false;
            String pwd="";
            Random random=new Random();
            int Verification=random.nextInt(9000)+1000;

            System.out.println("输入账号");
            String account=tool.ScannerString();

            for (Teacher teacher:db_teacher.getTeacherArrayList()){
                if(teacher.getAccount().equals(account)){
                    pwd=teacher.getPassword();
                    flag=true;
                    break;
                }
            }
            if(!flag){
                System.out.println("没有此账号");
                System.out.println("你还有"+lognum+"次机会");
            }else {
                System.out.println("输入密码");
                String password=tool.ScannerString();
                if (pwd.equals(password)){
                    System.out.println("输入验证码\n验证码是"+Verification);
                    int num=tool.ScannerNum();
                    if(Verification==num){
                        System.out.println("登陆成功");
                        MainPage.mainPage();
                    }else {
                        System.out.println("验证码错误");
                        System.out.println("你还有"+lognum+"次机会");

                    }
                }else {
                    System.out.println("密码错误");
                    System.out.println("你还有"+lognum+"次机会");
                }
            }
        }
    }

    public static void Register(){
        System.out.println("输入要注册的账号");
        String account;
        boolean flag;
        Teacher newteacher=new Teacher();
        while (true){
            flag=true;
            account=tool.ScannerString();
            for (Teacher teacher:db_teacher.getTeacherArrayList())
                if (teacher.getAccount().equals(account)) {
                    flag = false;
                }
            if (flag){
                newteacher.setAccount(account);
                break;
            }else {
                System.out.println("账号存在请重新输入");
            }
        }
        System.out.println("输入名字");
        String name=tool.ScannerString();
        newteacher.setName(name);
        System.out.println("输入密码");
        String password=tool.ScannerString();
        newteacher.setPassword(password);
        System.out.println("输入邮箱");
        String regex="^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
        String mailbox;
        while (true){
            mailbox=tool.ScannerString();
            if (mailbox.matches(regex)){
                newteacher.setMailbox(mailbox);
                break;
            }else {
                System.out.println("请输入正确格式");
            }
        }
        System.out.println("输入电话");
        regex ="^(13[0-9]|14[5|7]|15[0|1|2|3|4|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";
        String phone;
        while (true){
            phone=tool.ScannerString();
            if (phone.matches(regex)){
                newteacher.setPhone(phone);
                break;
            }else {
                System.out.println("请输入正确格式");
            }
        }
        db_teacher.getTeacherArrayList().add(newteacher);
        System.out.println("注册成功");
        main();
    }
}





















