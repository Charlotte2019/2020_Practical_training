public class CheckPagePresenter {
    private ICheckPage iCheckPage;
    public CheckPagePresenter(ICheckPage iCheckPage){
        this.iCheckPage = iCheckPage;
    }

    public void dataLoad(){
        DataAll.date(this);
    }

    public void loadSuccess(){
        iCheckPage.loadSuccess();
    }
}
