public class SecMenu implements IMainMenu{
    StudentDao studentDao;
    TeacherDao teacherDao;
    public SecMenu(){
        studentDao=new StudentDao(this);
        teacherDao=new TeacherDao(this);
    }

    @Override
    public void SelectStudent() {
        teacherDao.QAQ();
    }
}
