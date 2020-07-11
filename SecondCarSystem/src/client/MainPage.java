package client;

import dao.UserDao;
import utils.MessageShow;
import utils.ScTool;

public class MainPage extends BasePage {
    MessageShow messageShow;
    SearchPage searchPage;

    public MainPage() {
        messageShow = new MessageShow();
        searchPage = new SearchPage();
    }

    public void main() {
        if (new UserDao().isLogin()) {
            loginMain();
        } else {
            noLoginmain();
        }
    }

    private void noLoginmain() {
        System.out.println("1、登陆");
        System.out.println("2、注册");
        System.out.println("3、最新二手车信息");
        System.out.println("4、搜索车辆");
        System.out.println("5、退出系统");
        String check = ScTool.scannerString();
        switch (check) {
            case "1":
                new LoginPage().login(new LoginPage.LoginListener() {
                    @Override
                    public void loginSuccess() {
                        main();
                    }

                    @Override
                    public void loginFailed() {
                        System.out.println("输入#返回开始菜单\t输入其他退出程序");
                        if ("#".equals(ScTool.scannerString())) {
                            main();
                        } else {
                            System.out.println("成功退出");
                            System.exit(0);
                        }
                    }
                });
                break;
            case "2":
                new LoginPage().register(new LoginPage.RegisterListener() {
                    @Override
                    public void registerSuccess() {
                        main();
                    }

                    @Override
                    public void registerFailed() {
                        main();
                    }
                });
                break;
            case "3":
                searchPage.latestUsedCar();
                break;
            case "4":
                searchPage.searchCar();
                break;
            case "5":
                System.out.println("成功退出");
                System.exit(0);
                break;
            default:
                System.out.println("输入正确选项");
                main();
        }
    }

    private void loginMain() {
        System.out.println("1、最新二手车信息");
        System.out.println("2、搜索车辆");
        System.out.println("3、退出系统");
        String check = ScTool.scannerString();
        switch (check) {
            case "1":
                searchPage.latestUsedCar();
                break;
            case "2":
                searchPage.searchCar();
                break;
            case "3":
                System.out.println("成功退出");
                System.exit(0);
                break;
            default:
                System.out.println("输入正确选项");
                loginMain();
        }
        System.exit(0);
    }

}
