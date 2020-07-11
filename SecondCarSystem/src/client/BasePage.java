package client;

public class BasePage {
    public final String TAG = this.getClass().getSimpleName();
    public BasePage(){
        App.navigation.put(TAG,this);
    }
}
