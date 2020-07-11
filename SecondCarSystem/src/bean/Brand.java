package bean;

public class Brand {
    private int brandid;
    private String brandname;
    private String remark;

    public int getBrandid() {
        return brandid;
    }

    public void setBrandid(int brandid) {
        this.brandid = brandid;
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Brand() {
    }

    public Brand(int brandid, String brandname, String remark) {
        this.brandid = brandid;
        this.brandname = brandname;
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "brandid=" + brandid +
                ", brandname='" + brandname + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
