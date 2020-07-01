import java.util.ArrayList;

public class db_student {
    private static ArrayList<Student> studentArrayList;

    public static ArrayList<Student> getStudentArrayList() {
        return studentArrayList;
    }

    public static void setStudentArrayList(ArrayList<Student> studentArrayList) {
        db_student.studentArrayList = studentArrayList;
    }

    public db_student() {
    }
}
