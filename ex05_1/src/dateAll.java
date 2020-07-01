import java.util.ArrayList;
import java.util.Date;

public class dateAll {
    Date date=new Date();
    Teacher teacher1=new Teacher("q","q","q","q","1");
    Teacher teacher2=new Teacher("a","q","a","q","1");
    Student student1=new Student("q","q","q",1,date,"1");
    Student student2=new Student("a","q","q",1,date,"1");
    public void assemble(){
        ArrayList<Teacher> teacherArrayList = new ArrayList<>();
        teacherArrayList.add(teacher1);
        teacherArrayList.add(teacher2);
        db_teacher.setTeacherArrayList(teacherArrayList);
        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(student1);
        studentArrayList.add(student2);
        db_student.setStudentArrayList(studentArrayList);
    }
}
