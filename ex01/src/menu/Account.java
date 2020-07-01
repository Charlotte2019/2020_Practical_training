package menu;

import java.util.HashMap;
import java.util.Map;

public class Account {
    private String username = "admin";
    private String pwd = "00000";
    Map<String, String> map = new HashMap<>();

    public void register(String username, String pwd) {
        map.put(username, pwd);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
