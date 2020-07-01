import java.util.Scanner;

public class Prismatic {
    public static void main(String[] args) {
        lingxing();
    }

    public static void lingxing() {
        Scanner scanner = new Scanner(System.in);
        int row;
        do {
            System.out.println("输入行数必须是奇数");
            row = scanner.nextInt();
        } while (row % 2 == 0 || row <= 0);
        int m = (row - 1) / 2;
        for (int i = -m; i <= m; i++) {
            for (int j = -m; j <= m; j++) {
                //Math.abs(j) + Math.abs(i) == Math.abs(m)是空心菱形
                if (Math.abs(j) + Math.abs(i) <= Math.abs(m)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }

            }
            System.out.println();
        }
    }
}
