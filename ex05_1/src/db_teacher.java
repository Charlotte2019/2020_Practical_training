import java.util.ArrayList;

public class db_teacher {
    private static ArrayList<Teacher> teacherArrayList;

    public db_teacher() {
    }

    public static ArrayList<Teacher> getTeacherArrayList() {
        return teacherArrayList;
    }

    public static void setTeacherArrayList(ArrayList<Teacher> teacherArrayList) {
        db_teacher.teacherArrayList = teacherArrayList;
    }
}
