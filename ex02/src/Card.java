public class Card {
    private String id = "admin";
    private String pwd = "00000";
    private double money = 5000;
    private String type = "工商卡";

    public Card(String id, String pwd, double money, String type) {
        this.id = id;
        this.pwd = pwd;
        this.money = money;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
