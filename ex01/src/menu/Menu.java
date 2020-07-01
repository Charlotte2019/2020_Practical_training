package menu;

import java.util.Random;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final Account account = new Account();
    Random random = new Random();
    private int count = 0;

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.start();
    }

    public void start() {
        System.out.println("��½");
        System.out.println("1����½\t2��ע��\t3���˳�");
        String choose = scanner.next();
        switch (choose) {
            case "1":
                login();
                break;
            case "2":
                regist();
                break;
            case "3":
                System.exit(0);
            default:
                System.out.println("ѡ������");
                start();
        }
    }

    public void login() {
        while (true) {
            System.out.println("�����û���");
            String username = scanner.next();
            System.out.println("��������");
            String pwd = scanner.next();
            count++;
            System.out.println("--------------");
            if (account.map.containsKey(username) && pwd.equals(account.map.get(username))) {
                System.out.println("��½�ɹ�");
                mainMenu();
                break;
            } else {
                if (count == 3) {
                    System.out.println("����");
                    System.exit(0);
                }
                System.out.println("�û����������������,�������롣����" + (3 - count) + "�λ���");
            }
        }
    }

    public void mainMenu() {
        System.out.println("--------���˵�----------");
    }

    public void regist() {
        System.out.println("����ע���û���");
        String name = scanner.next();
        System.out.println("��������");
        String pwd = scanner.next();
        System.out.println("ȷ������");
        String pwd2 = scanner.next();
        int checkCode = random.nextInt(9000) + 1000;
        System.out.println("��֤����" + checkCode + "\n������֤��");
        int code = scanner.nextInt();
        boolean contains = account.map.containsKey(name);
        if (!contains) {
            if (pwd.equals(pwd2)) {
                if (checkCode == code) {
                    account.register(name, pwd);
                    System.out.println(name + "\t" + account.map.get(name));
                    login();
                } else {
                    System.out.println("��֤�����");
                }
            } else {
                System.out.println("���벻ƥ��");
            }
        } else {
            System.out.println("�û����Ѵ���");
        }
    }
}
