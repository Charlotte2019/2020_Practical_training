import java.util.*;

public class checkPage {
    Scanner scanner=new Scanner(System.in);
//    db_teacher db_teacher=new db_teacher();
//    db_student db_student=new db_student();
//    Date date=new Date();
//    Teacher teacher1=new Teacher("q","q","q","q",1);
//    Teacher teacher2=new Teacher("a","q","a","q",1);
//    Student student1=new Student("1","q","a",1,date,1);
//    Student student2=new Student("2","q","b",1,date,1);
    public static void main(String[] args) {
        ArrayList<Teacher> teacherArrayList=new ArrayList<>();
        teacherArrayList=db_teacher.data_teacher();
        checkPage checkPage=new checkPage();
        checkPage.main();
    }
    public void main(){
//        db_teacher.getTeacherArrayList().add(teacher1);
//        db_teacher.getTeacherArrayList().add(teacher2);
//        db_student.getStudentArrayList().add(student1);
//        db_student.getStudentArrayList().add(student2);
        System.out.println("1、登陆");
        System.out.println("2、注册");
        System.out.println("3、退出");
        do {
            String check=scanner.next();
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

    public void Login(){
        int lognum=3;
        while (lognum!=0){
            lognum--;
            boolean flag=false;
            String pwd="";
            Random random=new Random();
            int Verification=random.nextInt(9000)+1000;

            System.out.println("输入账号");
            String account=scanner.next();

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
                String password=scanner.next();
                if (pwd.equals(password)){
                    System.out.println("输入验证码\n验证码是"+Verification);
                    int num=scanner.nextInt();
                    if(Verification==num){
                        System.out.println("登陆成功");
                        mainPage();
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

    public void Register(){
        System.out.println("输入要注册的账号");
        String account;
        boolean flag;
        Teacher newteacher=new Teacher();
        while (true){
            flag=true;
            account=scanner.next();
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
        String name=scanner.next();
        newteacher.setName(name);
        System.out.println("输入密码");
        String password=scanner.next();
        newteacher.setPassword(password);
        System.out.println("输入邮箱");
        String mailbox=scanner.next();
        newteacher.setMailbox(mailbox);
        System.out.println("输入电话");
        int phone=scanner.nextInt();
        newteacher.setPhone(phone);
        db_teacher.getTeacherArrayList().add(newteacher);
        System.out.println("注册成功");
        System.out.println("1、返回开始菜单");
        System.out.println("2、退出");
        do {
            String check=scanner.next();
            String regex="[1-2]";
            if(check.matches(regex)){
                switch (check){
                    case "1":
                        main();
                        break;
                    case "2":
                        System.out.println("成功退出");
                        System.exit(0);
                }
                break;
            }
            System.err.println("!输入有误!");
            System.out.println("重新选择或者按3退出.");
        }while (true);
    }

    public void mainPage(){
        System.out.println("1、查询学生成绩");
        System.out.println("2、删除学生信息");
        System.out.println("3、退出");
        do {
            String check=scanner.next();
            String regex="[1-3]";
            if(check.matches(regex)){
                switch (check){
                    case "1":
                        SelectStudent();
                        break;
                    case "2":
                        DeleteStudent();
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

    public void SelectStudent(){
        System.out.println("0、返回上一级");
        System.out.println("1、根据学号查找");
        System.out.println("2、根据姓名查找");
        System.out.println("3、查找所有");
        System.out.println("4、退出");
        do {
            String check=scanner.next();
            String regex="[1-4]";
            if(check.matches(regex)){
                switch (check){
                    case "0":
                        mainPage();
                        break;
                    case "1":
                        SelectId();
                        break;
                    case "2":
                        SelectName();
                        break;
                    case "3":
                        SelectAll();
                        break;
                    case "4":
                        System.out.println("成功退出");
                        System.exit(0);
                }
                break;
            }
            System.err.println("!输入有误!");
            System.out.println("重新选择或者按4退出.");
        }while (true);

    }

    public void SelectId(){
        System.out.println("输入要查找的学号");
        String sno=scanner.next();
        boolean flag=false;
        for (Student student:db_student.getStudentArrayList()){
            if (student.getSno().equals(sno)){
                flag=true;
                System.out.println(student);
            }
        }
        if (!flag){
            System.out.println("没有这个学号的学生");
        }
        System.out.println("1、继续此操作");
        System.out.println("2、返回上一级");
        System.out.println("3、退出");
        do {
            String check=scanner.next();
            String regex="[1-3]";
            if(check.matches(regex)){
                switch (check){
                    case "1":
                        SelectId();
                        break;
                    case "2":
                        SelectStudent();
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

    public void SelectName(){
        System.out.println("输入要查找的名字");
        String name=scanner.next();
        boolean flag=false;
        for (Student student:db_student.getStudentArrayList()){
            if (student.getName().equals(name)){
                flag=true;
                System.out.println(student);
            }
        }
        if (!flag){
            System.out.println("没有这个名字的学生");
        }
        System.out.println("1、继续此操作");
        System.out.println("2、返回上一级");
        System.out.println("3、退出");
        do {
            String check=scanner.next();
            String regex="[1-3]";
            if(check.matches(regex)){
                switch (check){
                    case "1":
                        SelectName();
                        break;
                    case "2":
                        SelectStudent();
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

    public void SelectAll(){
        boolean flag=false;
        for (Student student:db_student.getStudentArrayList()){
                System.out.println(student);
                flag=true;
        }
        if (!flag){
            System.out.println("没有学生");
        }
        System.out.println("1、继续此操作");
        System.out.println("2、返回上一级");
        System.out.println("3、退出");
        do {
            String check=scanner.next();
            String regex="[1-3]";
            if(check.matches(regex)){
                switch (check){
                    case "1":
                        SelectAll();
                        break;
                    case "2":
                        SelectStudent();
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

    public void DeleteStudent(){
        System.out.println("输入要删除的学号");
        String sno=scanner.next();
        Iterator<Student> studentIterator=db_student.getStudentArrayList().iterator();
        while (studentIterator.hasNext()){
            String str=studentIterator.next().getSno();
            if (str.equals(sno)){
                studentIterator.remove();
            }
        }
        System.out.println("1、继续此操作");
        System.out.println("2、返回上一级");
        System.out.println("3、退出");
        do {
            String check=scanner.next();
            String regex="[1-3]";
            if(check.matches(regex)){
                switch (check){
                    case "1":
                        DeleteStudent();
                        break;
                    case "2":
                        SelectStudent();
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
}





















