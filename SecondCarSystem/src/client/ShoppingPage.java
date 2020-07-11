package client;

import bean.Car;
import bean.User;
import dao.CarDao;
import dao.UserDao;
import utils.ScTool;

public class ShoppingPage extends BasePage {

    public void shoppingMenu(int carid) {
        System.out.println("1、购买");
        System.out.println("2、返回主菜单");
        int choose = ScTool.scannerInt();
        switch (choose) {
            case 1:
                shopping(carid);
                break;
            case 2:
                ((MainPage) App.navigation.get(MainPage.class.getSimpleName())).main();
                break;
            default:
                shoppingMenu(carid);
                break;
        }
    }

    public void shopping(int carid) {
        if (!new UserDao().isLogin()) {
            System.out.println("请登录");
            ((MainPage) App.navigation.get(MainPage.class.getSimpleName())).main();
        } else {
            Car car = new CarDao().priceByid(carid);
            User user = new UserDao().balanceByid();
            if (user.getBalance() < car.getPrice()) {
                System.out.println("余额不足\t返回首页");
            } else {
                if (new UserDao().shopCarByCarid(user, car) == 1) {
                    System.out.println("购买成功返回首页");
                } else {
                    System.out.println("购买失败\t返回首页");
                }
            }
            ((MainPage) App.navigation.get(MainPage.class.getSimpleName())).main();
        }
    }
}
