import java.util.Date;

public class DataAll {
    public static void date(CheckPagePresenter checkPagePresenter){
        Date date=new Date();
        Teacher teacher1=new Teacher("q","q","q","q",1);
        Teacher teacher2=new Teacher("a","q","a","q",1);
        Student student1=new Student("1","q","a",1,date,1);
        Student student2=new Student("2","q","b",1,date,1);
        TeacherDb.getInstance().addTeacher(teacher1).addTeacher(teacher2);
        StudentDb.getInstance().addStudent(student1).addStudent(student2);
        checkPagePresenter.loadSuccess();
    }
}
