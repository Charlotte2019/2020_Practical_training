import java.util.Scanner;

public class MainPage {
    Card card = new Card("admin", "00000", 1500, "工商卡1");
    ATM atm = new ATM(50000);
    private final Scanner scanner = new Scanner(System.in);
    private int count = 0;
    private double a = 0;

    public static void main(String[] args) {
        MainPage mainPage = new MainPage();
        mainPage.main();
    }

    public void main() {
        System.out.println("1、插卡");
        System.out.println("2、离去");
        String choose = scanner.next();
        String regex = "[1-2]";
        if (choose.matches(regex)) {
            switch (choose) {
                case "1":
                    logIn();
                    break;
                case "2":
                    System.exit(0);
            }
        } else {
            System.out.println("输入正确选项");
            main();
        }
    }

    public void logIn() {
        String flag;
        while (true) {
            System.out.println("输入密码");
            String pwd = scanner.next();
            count++;
            if (pwd.equals(card.getPwd())) {
                System.out.println("登陆成功");
                menu();
                break;
            } else if (count == 3) {
                System.out.println("冻结");
                System.exit(0);
            } else {
                System.out.println("用户名或密码输入错误。还有" + (3 - count) + "次机会");
                System.out.println("输入#取卡\t输入其他继续");
                if ((flag = scanner.next()).equals("#")) {
                    main();
                    break;
                }
            }
        }
    }

    public void menu() {
        System.out.println("0、取卡");
        System.out.println("1、查看余额");
        System.out.println("2、取款");
        System.out.println("3、存款");
        String choose = scanner.next();
        String regex = "[0-3]";
        if (choose.matches(regex)) {
            switch (choose) {
                case "0":
                    main();
                    break;
                case "1":
                    System.out.println("当前余额");
                    System.out.println(card.getMoney());
                    menu();
                    break;
                case "2":
                    withdraw();
                    menu();
                    break;
                case "3":
                    deposit();
                    menu();
                    break;
            }
        } else {
            System.out.println("输入正确选项");
            menu();
        }
    }

    public void withdraw() {
        boolean flag = true;
        if (!card.getType().equals("工商卡")) {
            System.out.println("因为你的银行卡不是工商卡所以要扣3%的手续费");
            flag = false;
        }
        System.out.println("额度最小50，单笔取款金额不能超过2000元");
        System.out.println("金额为50的整数倍");
        System.out.println("输入你要取的金额\t你现有金额" + card.getMoney());
        double money = scanner.nextInt();
        while (true) {
            if (money >= 50 && money <= 2000 && money % 50 == 0) {
                break;
            } else {
                System.out.println("输入正确金额");
                money = scanner.nextInt();
            }
        }
        money = judge(flag, money);
        System.out.println("卡号：" + card.getId());
        System.out.println("取款：" + money);
        if (!flag) {
            System.out.println("手续费：" + 0.03 * money);
        }
        System.out.println("余额：" + card.getMoney());
    }

    public double judge(boolean flag, double money) {
        if (flag) {
            if (card.getMoney() - money >= 0 && atm.getAllmoney() - money >= 0) {
                card.setMoney(card.getMoney() - money);
                atm.setAllmoney(atm.getAllmoney() - money);
                a = money;
            } else {
                if (atm.getAllmoney() - money <= 0) {
                    System.out.println("ATM只有：" + atm.getAllmoney());
                } else {
                    System.out.println("余额不足，请重新输入");
                }
                money = scanner.nextInt();
                return judge(flag, money);
            }
        } else {
            if (card.getMoney() - 1.03 * money >= 0 && atm.getAllmoney() - money >= 0) {
                card.setMoney(card.getMoney() - 1.03 * money);
                atm.setAllmoney(atm.getAllmoney() - money);
                a = money;
            } else {
                if (atm.getAllmoney() - money <= 0) {
                    System.out.println("ATM只有：" + atm.getAllmoney());
                } else {
                    System.out.println("余额不足，请重新输入");
                }
                money = scanner.nextInt();
                judge(flag, money);
            }
        }
        return a;
    }

    public void deposit() {
        System.out.println("额度最小50");
        System.out.println("金额为50的整数倍");
        double money = scanner.nextInt();
        while (true) {
            if (money % 50 == 0 && atm.getAllmoney() + money <= 500000) {
                card.setMoney(card.getMoney() + money);
                atm.setAllmoney(atm.getAllmoney() + money);
                break;
            } else {
                if (money % 50 != 0) {
                    System.out.println("请输入50的整数倍");
                    money = scanner.nextInt();
                } else {
                    System.out.println("ATM已经满了");
                    System.out.println("ATM还能存" + (500000 - atm.getAllmoney()));
                    System.out.println("请重新输入\t如果已经满了输入0退出该界面");
                    money = scanner.nextInt();
                }
            }
        }
        System.out.println("卡号：" + card.getId());
        System.out.println("存入：" + money);
        System.out.println("存款：" + card.getMoney());
    }
}
