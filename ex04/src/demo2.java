import java.util.Scanner;

public class demo2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.next();
        str=Camel(str);
        System.out.println(str);

    }
    public static String Camel(String str){
        String[] strings=str.split("\\#");
        String string="";
        for(String s:strings){
            string=string+s.substring(0,1).toUpperCase()+s.substring(1).toLowerCase();
        }
        return string;
    }
}
