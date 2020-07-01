import java.util.Scanner;

public class tool {
    public static int ScannerNum(){
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        return num;
    }

    public static String ScannerString(){
        Scanner scanner=new Scanner(System.in);
        String str=scanner.next();
        return str;
    }
}
