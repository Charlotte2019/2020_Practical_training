package client;

import bean.User;
import dao.UserDao;
import utils.ScTool;

import java.util.Random;

public class LoginPage extends BasePage {
    public void login(LoginListener listener) {
        while (true) {
            Random random = new Random();
            int verification = random.nextInt(9000) + 1000;
            System.out.println("输入账号");
            String account = ScTool.scannerString();
            System.out.println("输入密码");
            String password = ScTool.scannerString();
            boolean isFind = new User().login(account, password);
            if (!isFind) {
                System.out.println("账号或密码错误");
            } else {
                System.out.println("输入验证码\n验证码是" + verification);
                int num = ScTool.scannerInt();
                if (verification == num) {
                    System.out.println("登陆成功");
                    listener.loginSuccess();
                    break;
                } else {
                    System.out.println("验证码错误");
                }
                listener.loginFailed();
            }
        }
    }

    public void register(RegisterListener listener) {
        String account;
        User user = new User();
        while (true) {
            System.out.println("输入要注册的账号");
            account = ScTool.scannerString();
            if (new UserDao().userExist(account)){
                System.out.println("账号已存在");
                continue;
            }
            System.out.println("输入密码");
            String password1 = ScTool.scannerString();
            System.out.println("确认密码");
            String password2 = ScTool.scannerString();
            if (password1.equals(password2)) {
                user.setPassword(password1);
            } else {
                System.out.println("两次密码输入不一致");
                continue;
            }
            user.setUsername(account);
            System.out.println("输入充值金额");
            double money = ScTool.scannerDouble();
            user.setBalance(money);
            //默认普通用户
            user.setIsAdmin(0);
            if (new UserDao().addUser(user)){
                System.out.println("注册成功");
                listener.registerSuccess();
            }else {
                System.out.println("注册失败,输入#重新注册，任意键返回");
                String input = ScTool.scannerString();
                if ("#".equals(input)){
                    continue;
                }else {
                    listener.registerFailed();
                }
            }
        }
    }

    public interface LoginListener {
        void loginSuccess();

        void loginFailed();
    }

    public interface RegisterListener {
        void registerSuccess();
        void registerFailed();
    }
}
