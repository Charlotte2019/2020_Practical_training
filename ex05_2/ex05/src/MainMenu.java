public class MainMenu implements IMainMenu{

    StudentDao studentDao;
    TeacherDao teacherDao;

    public MainMenu(){
        studentDao=new StudentDao(this);
        teacherDao=new TeacherDao(this);
    }

    public void mainPage() {
        System.out.println("1、查询学生成绩");
        System.out.println("2、删除学生信息");
        System.out.println("3、退出");
        do {
            String check = tool.ScannerString();
            String regex = "[1-3]";
            if (check.matches(regex)) {
                switch (check) {
                    case "1":
                        SelectStudent();
                        break;
                    case "2":
                        studentDao.DeleteStudent();
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

    @Override
    public void SelectStudent() {
        System.out.println("0、返回上一级");
        System.out.println("1、根据学号查找");
        System.out.println("2、根据姓名查找");
        System.out.println("3、查找所有");
        System.out.println("4、退出");
        do {
            String check = tool.ScannerString();
            String regex = "[0-4]";
            if (check.matches(regex)) {
                switch (check) {
                    case "0":
                        mainPage();
                        break;
                    case "1":
                        studentDao.SelectId();
                        break;
                    case "2":
                        studentDao.SelectName();
                        break;
                    case "3":
                        studentDao.SelectAll();
                        break;
                    case "4":
                        System.out.println("成功退出");
                        System.exit(0);
                }
                break;
            }
            System.err.println("!输入有误!");
            System.out.println("重新选择或者按4退出.");
        } while (true);
    }
}
