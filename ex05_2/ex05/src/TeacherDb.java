import java.util.ArrayList;

public class TeacherDb {

    private static TeacherDb mInstance = null;
    private volatile ArrayList<Teacher> teacherArrayList = null;

    public static TeacherDb getInstance() {
        if (mInstance == null) {
            synchronized (TeacherDb.class) {
                if (mInstance == null) {
                    mInstance = new TeacherDb();
                }
            }
        }
        return mInstance;
    }

    private TeacherDb() {
        teacherArrayList = new ArrayList<>();
    }

    public ArrayList<Teacher> getTeacherArrayList(){
        return teacherArrayList;
    }

    public TeacherDb addTeacher(Teacher teacher){
        teacherArrayList.add(teacher);
        return this;
    }
}
