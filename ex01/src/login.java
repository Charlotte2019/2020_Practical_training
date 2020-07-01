import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class login {
    public static void main(String[] args) {
        System.out.println("/*********抽奖系统***********8/");
        System.out.println("1、登陆");
        System.out.println("2、注册");
        System.out.println("3、退出");
        System.out.println("请选择");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                Login();
                break;
            case 2:
                Register();
                break;
            case 3:
                System.exit(0);
        }
    }

    public static void Login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入账号密码和验证码");
        Random random = new Random();
        int v_code = random.nextInt(8999) + 1000;
        System.out.println("验证码是" + v_code);
        System.out.println("输入账号");
        String account = scanner.nextLine();
        System.out.println("输入密码");
        String pwd = scanner.nextLine();
        System.out.println("输入验证码");
        int Verification = scanner.nextInt();
        if (account.equals("admin") && pwd.equals("123456") && Verification == v_code) {
            MainPage();
        } else {
            System.out.println("错误，请重新登陆");
            Login();
        }
    }

    public static void Register() {
        System.out.println("注册成功");
        System.exit(0);
    }

    public static void MainPage() {
        System.out.println("主菜单");
        System.out.println("1、幸运抽奖");
        System.out.println("2、购物结算");
        System.out.println("3、退出系统");
        System.out.println("请选择");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                Draw();
                break;
            case 2:
                Shopping();
                break;
            case 3:
                System.exit(0);
        }
    }

    public static void Draw() {
        System.out.println("输入4位数");
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("\\d{4}");
        String num;
        while (true) {
            num = scanner.nextLine();
            if (pattern.matcher(num).matches()) {
                break;
            }
        }
        int num_3 = Integer.valueOf(num);
        num_3 = num_3 / 100 % 10;
        Random random = new Random();
        if (num_3 == random.nextInt(10)) {
            System.out.println("你中奖了，获得MP3一个");
        } else {
            System.out.println("你没中奖\n退出程序");
        }
    }

    public static void Shopping() {
        System.out.println("结算成功");
        System.exit(0);
    }
}
