package bean;

public class CarType {
    private int typeid;
    private String typename;
    private int brandid;

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public int getBrandid() {
        return brandid;
    }

    public void setBrandid(int brandid) {
        this.brandid = brandid;
    }

    public CarType() {
    }

    public CarType(int typeid, String typename, int brandid) {
        this.typeid = typeid;
        this.typename = typename;
        this.brandid = brandid;
    }
}
