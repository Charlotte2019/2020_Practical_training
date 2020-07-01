import java.lang.reflect.ParameterizedType;

public class demo4 {
    public static void main(String[] args) {
        int a = 3, b = 4;
        swap(a, b);
        System.out.println(a);
        System.out.println(b);
    }

    static void swap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }
}
