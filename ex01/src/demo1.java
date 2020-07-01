public class demo1 {
    public static void main(String[] args) {
        String regex="^\\w+(.\\w+)*@\\w+(.\\w+)*\\.\\w+(.\\w+)*$";
        String str="123.ad.ygfs@qq.vip.huih.com";
        if(str.matches(regex)){
            System.out.println("success");
        }else {
            System.out.println("mistake");
        }
    }
}
