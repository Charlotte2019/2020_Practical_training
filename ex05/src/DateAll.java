import java.util.ArrayList;
import java.util.Date;

public class DateAll {
    public static void date(){
        Date date=new Date();
        Teacher teacher1=new Teacher("q","q","q","q",1);
        Teacher teacher2=new Teacher("a","q","a","q",1);
        Student student1=new Student("1","q","a",1,date,1);
        Student student2=new Student("2","q","b",1,date,1);
        ArrayList<Teacher> teacherArrayList = new ArrayList<>();
        teacherArrayList.add(teacher1);
        teacherArrayList.add(teacher2);
        db_teacher db_teacher=new db_teacher();
        db_teacher.setTeacherArrayList(teacherArrayList);
        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(student1);
        studentArrayList.add(student2);
        db_student db_student=new db_student();
        db_student.setStudentArrayList(studentArrayList);
    }
}
