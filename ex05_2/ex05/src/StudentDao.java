import java.util.Iterator;

public class StudentDao {

    private IMainMenu iMainMenu;

    public StudentDao(IMainMenu iMainMenu){
        this.iMainMenu = iMainMenu;
    }
    
    public void SelectId() {
        System.out.println("输入要查找的学号");
        String sno = tool.ScannerString();
        boolean flag = false;
        for (Student student : StudentDb.getInstance().getStudentArrayList()) {
            if (student.getSno().equals(sno)) {
                flag = true;
                System.out.println(student);
            }
        }
        if (!flag) {
            System.out.println("没有这个学号的学生");
        }
        System.out.println("1、继续此操作");
        System.out.println("2、返回上一级");
        System.out.println("3、退出");
        do {
            String check = tool.ScannerString();
            String regex = "[1-3]";
            if (check.matches(regex)) {
                switch (check) {
                    case "1":
                        SelectId();
                        break;
                    case "2":
                        iMainMenu.SelectStudent();
                        break;
                    case "3":
                        System.out.println("成功退出");
                        System.exit(0);
                }
                break;
            }
            System.err.println("!输入有误!");
            System.out.println("重新选择或者按3退出.");
        } while (true);
    }

    public void SelectName() {
        System.out.println("输入要查找的名字");
        String name = tool.ScannerString();
        boolean flag = false;
        for (Student student : StudentDb.getInstance().getStudentArrayList()) {
            if (student.getName().equals(name)) {
                flag = true;
                System.out.println(student);
            }
        }
        if (!flag) {
            System.out.println("没有这个名字的学生");
        }
        System.out.println("1、继续此操作");
        System.out.println("2、返回上一级");
        System.out.println("3、退出");
        do {
            String check = tool.ScannerString();
            String regex = "[1-3]";
            if (check.matches(regex)) {
                switch (check) {
                    case "1":
                        SelectName();
                        break;
                    case "2":
                        iMainMenu.SelectStudent();
                        break;
                    case "3":
                        System.out.println("成功退出");
                        System.exit(0);
                }
                break;
            }
            System.err.println("!输入有误!");
            System.out.println("重新选择或者按3退出.");
        } while (true);
    }

    public void SelectAll() {
        boolean flag = false;
        for (Student student : StudentDb.getInstance().getStudentArrayList()) {
            System.out.println(student);
            flag = true;
        }
        if (!flag) {
            System.out.println("没有学生");
        }
        System.out.println("1、继续此操作");
        System.out.println("2、返回上一级");
        System.out.println("3、退出");
        do {
            String check = tool.ScannerString();
            String regex = "[1-3]";
            if (check.matches(regex)) {
                switch (check) {
                    case "1":
                        SelectAll();
                        break;
                    case "2":
                        iMainMenu.SelectStudent();
                        break;
                    case "3":
                        System.out.println("成功退出");
                        System.exit(0);
                }
                break;
            }
            System.err.println("!输入有误!");
            System.out.println("重新选择或者按3退出.");
        } while (true);
    }

    public void DeleteStudent() {
        System.out.println("输入要删除的学号");
        String sno = tool.ScannerString();
        Iterator<Student> studentIterator = StudentDb.getInstance().getStudentArrayList().iterator();
        while (studentIterator.hasNext()) {
            String str = studentIterator.next().getSno();
            if (str.equals(sno)) {
                studentIterator.remove();
            }
        }
        System.out.println("1、继续此操作");
        System.out.println("2、返回上一级");
        System.out.println("3、退出");
        do {
            String check = tool.ScannerString();
            String regex = "[1-3]";
            if (check.matches(regex)) {
                switch (check) {
                    case "1":
                        DeleteStudent();
                        break;
                    case "2":
                        iMainMenu.SelectStudent();
                        break;
                    case "3":
                        System.out.println("成功退出");
                        System.exit(0);
                }
                break;
            }
            System.err.println("!输入有误!");
            System.out.println("重新选择或者按3退出.");
        } while (true);
    }
}
