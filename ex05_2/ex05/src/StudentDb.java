import java.util.ArrayList;

public class StudentDb {
    private static StudentDb mInstance = null;
    private ArrayList<Student> studentArrayList = null;

    public static StudentDb getInstance() {
        if (mInstance == null) {
            synchronized (TeacherDb.class) {
                if (mInstance == null) {
                    mInstance = new StudentDb();
                }
            }
        }
        return mInstance;
    }

    private StudentDb() {
        studentArrayList = new ArrayList<>();
    }

    public ArrayList<Student> getStudentArrayList() {
        return studentArrayList;
    }

    public StudentDb addStudent(Student student) {
        studentArrayList.add(student);
        return this;
    }
}
