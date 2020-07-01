import java.util.ArrayList;
import java.util.Scanner;

public class demo3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.next();
        str = encryption(str);
        System.out.println(str);
    }
    public static String encryption(String str){
        int num;
        ArrayList<Character> arrayList=new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            num=str.charAt((i+1)%str.length());
            arrayList.add((char)num);
        }
        String string="";
        for (Character character:arrayList){
            string+=character;
        }
        return string;
    }
}
