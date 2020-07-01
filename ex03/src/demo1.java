import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;

public class demo1 {
    public static void main(String[] args) {
        int date = 0;
        int day_max = 0;
        int day_sum = 0;
        int year = 0;
        int mouth = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入年份");
        year = scanner.nextInt();
        System.out.println("输入月份");
        mouth = scanner.nextInt();
        for (int i = 1900; i < year; i++) {
            if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
                day_sum += 366;
            } else {
                day_sum += 365;
            }
        }
        for (int i = 1; i < mouth; i++) {
            switch (i) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    day_max = 31;
                    day_sum += day_max;
                    break;
                case 2:
                    if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
                        day_max = 29;
                        day_sum += day_max;
                    } else {
                        day_max = 28;
                        day_sum += day_max;
                    }
                    break;
                default:
                    day_max = 30;
                    day_sum += day_max;
                    break;
            }
        }
        switch (mouth) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                day_max = 31;
                break;
            case 2:
                if (mouth % 4 == 0 && mouth % 100 != 0 || mouth % 400 == 0) {
                    day_max = 29;
                } else {
                    day_max = 28;
                }
                break;
            default:
                day_max = 30;
                break;
        }
        date = day_sum % 7 + 2;
        System.out.println(date);
        System.out.println(day_max);
        System.out.println("日\t一\t二\t三\t四\t五\t六");
        int day = 1;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (i == 0 && j < date) {
                    System.out.print("\t");
                    continue;
                }
                if (day > day_max) {
                    break;
                }
                System.out.print(day + "\t");
                day++;
            }
            System.out.println();
        }
    }
}


















