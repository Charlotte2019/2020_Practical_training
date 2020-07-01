public class TeacherDao {
    private IMainMenu iMainMenu;

    public TeacherDao (IMainMenu iMainMenu){
        this.iMainMenu=iMainMenu;
    }
    public void QAQ(){
        iMainMenu.SelectStudent();
    }
}
