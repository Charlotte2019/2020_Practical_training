import java.util.Random;

public class CheckPage implements ICheckPage{
    CheckPagePresenter checkPagePresenter;
    MainMenu mainmenu;

    public CheckPage(){
        checkPagePresenter = new CheckPagePresenter(this);
        mainmenu=new MainMenu();
    }

    public static void main(String[] args) {
        CheckPage checkPage = new CheckPage();
        checkPage.main();
    }

    public void main() {
        checkPagePresenter.dataLoad();
        System.out.println("1、登陆");
        System.out.println("2、注册");
        System.out.println("3、退出");
        do {
            String check = tool.ScannerString();
            String regex = "[1-3]";
            if (check.matches(regex)) {
                switch (check) {
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
        } while (true);
    }

    public void Login() {
        int lognum = 3;
        while (lognum != 0) {
            lognum--;
            boolean flag = false;
            String pwd = "";
            Random random = new Random();
            int Verification = random.nextInt(9000) + 1000;

            System.out.println("输入账号");
            String account = tool.ScannerString();

            for (Teacher teacher : TeacherDb.getInstance().getTeacherArrayList()) {
                if (teacher.getAccount().equals(account)) {
                    pwd = teacher.getPassword();
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.println("没有此账号");
                System.out.println("你还有" + lognum + "次机会");
            } else {
                System.out.println("输入密码");
                String password = tool.ScannerString();
                if (pwd.equals(password)) {
                    System.out.println("输入验证码\n验证码是" + Verification);
                    int num = tool.ScannerNum();
                    if (Verification == num) {
                        System.out.println("登陆成功");
                        mainmenu.mainPage();
                    } else {
                        System.out.println("验证码错误");
                        System.out.println("你还有" + lognum + "次机会");

                    }
                } else {
                    System.out.println("密码错误");
                    System.out.println("你还有" + lognum + "次机会");
                }
            }
        }
    }

    public void Register() {
        System.out.println("输入要注册的账号");
        String account;
        boolean flag;
        Teacher newteacher = new Teacher();
        while (true) {
            flag = true;
            account = tool.ScannerString();
            for (Teacher teacher : TeacherDb.getInstance().getTeacherArrayList())
                if (teacher.getAccount().equals(account)) {
                    flag = false;
                }
            if (flag) {
                newteacher.setAccount(account);
                break;
            } else {
                System.out.println("账号存在请重新输入");
            }
        }
        System.out.println("输入名字");
        String name = tool.ScannerString();
        newteacher.setName(name);
        System.out.println("输入密码");
        String password = tool.ScannerString();
        newteacher.setPassword(password);
        System.out.println("输入邮箱");
        String mailbox = tool.ScannerString();
        newteacher.setMailbox(mailbox);
        System.out.println("输入电话");
        int phone = tool.ScannerNum();
        newteacher.setPhone(phone);
        TeacherDb.getInstance().getTeacherArrayList().add(newteacher);
        System.out.println("注册成功");
        System.out.println("1、返回开始菜单");
        System.out.println("2、退出");
        do {
            String check = tool.ScannerString();
            String regex = "[1-2]";
            if (check.matches(regex)) {
                switch (check) {
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
        } while (true);
    }

    @Override
    public void loadSuccess() {
        System.out.println("数据加载完成");
    }
}





















