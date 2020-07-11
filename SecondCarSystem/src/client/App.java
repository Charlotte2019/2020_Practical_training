package client;

import java.util.HashMap;

public class App {
    public static HashMap<String,BasePage> navigation = new HashMap<>();
    public static void main(String[] args) {
        MainPage mainPage = new MainPage();
        mainPage.main();
    }
}
