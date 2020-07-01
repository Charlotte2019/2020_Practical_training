import java.util.ArrayList;
import java.util.Objects;

public class db_teacher {
    private static db_teacher mInstance=null;
    private ArrayList<Teacher> teacherArrayList=null;

    public static db_teacher getInstance(){
        if (mInstance == null){
            synchronized (db_teacher.class){
                if (mInstance == null){
                    mInstance=new db_teacher();
                }
            }
        }
        return mInstance;
    }

    public ArrayList<Teacher> getTeacherArrayList() {
        return teacherArrayList;
    }

    public void setTeacherArrayList(ArrayList<Teacher> teacherArrayList) {
        this.teacherArrayList = teacherArrayList;
    }

    public db_teacher addTeacher(Teacher teacher){
        teacherArrayList.add(teacher);
        return this;
    }
}
