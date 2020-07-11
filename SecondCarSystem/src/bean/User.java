package bean;


import dao.UserDao;

public class User {
    public static String token = "";
    private String username;
    private String password;
    private double balance;
    private int isAdmin;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isadmin) {
        this.isAdmin = isadmin;
    }

    public boolean login(String username,String password){
        return new UserDao().login(username, password);
    }
}
