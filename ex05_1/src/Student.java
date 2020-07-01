import java.util.Date;

public class Student {
    private String sno;
    private String name;
    private String classes;
    private int age;
    private Date date;
    private String phone;

    public Student(String sno, String name, String classes, int age, Date date, String phone) {
        this.sno = sno;
        this.name = name;
        this.classes = classes;
        this.age = age;
        this.date = date;
        this.phone = phone;
    }

    public Student() {
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno='" + sno + '\'' +
                ", name='" + name + '\'' +
                ", classes='" + classes + '\'' +
                ", age=" + age +
                ", date=" + date +
                ", phone=" + phone +
                '}';
    }
}
