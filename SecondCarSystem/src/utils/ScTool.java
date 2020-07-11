package utils;

import java.util.Scanner;

public class ScTool {
    public static int scannerInt(){
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        return num;
    }

    public static double scannerDouble(){
        Scanner scanner=new Scanner(System.in);
        double num=scanner.nextDouble();
        return num;
    }

    public static String scannerString(){
        Scanner scanner=new Scanner(System.in);
        String str=scanner.next();
        return str;
    }
}
