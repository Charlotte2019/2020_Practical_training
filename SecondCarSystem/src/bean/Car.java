package bean;

import java.util.Date;

public class Car {
    private int carid;
    /**
     * 排量
     */
    private double displacement;
    /**
     *里程数
     */
    private int mileage;
    private double price;
    /**
     *发布时间
     */
    private Date releasedate;
    /**
     *上牌时间
     */
    private Date licencedate;
    /**
     *离合器类型
     */
    private String cluth;
    /**
     * 是否购买
     */
    private int isSelled;
    private int typeid;

    public int getCarid() {
        return carid;
    }

    public void setCarid(int carid) {
        this.carid = carid;
    }

    public double getDisplacement() {
        return displacement;
    }

    public void setDisplacement(double displacement) {
        this.displacement = displacement;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(Date releasedate) {
        this.releasedate = releasedate;
    }

    public Date getLicencedate() {
        return licencedate;
    }

    public void setLicencedate(Date licencedate) {
        this.licencedate = licencedate;
    }

    public String getCluth() {
        return cluth;
    }

    public void setCluth(String cluth) {
        this.cluth = cluth;
    }

    public int getIsSelled() {
        return isSelled;
    }

    public void setIsSelled(int isSelled) {
        this.isSelled = isSelled;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public Car() {
    }

    public Car(int carid, double displacement, int mileage, double price, Date releasedate, Date licencedate, String cluth, int isselled, int typeid) {
        this.carid = carid;
        this.displacement = displacement;
        this.mileage = mileage;
        this.price = price;
        this.releasedate = releasedate;
        this.licencedate = licencedate;
        this.cluth = cluth;
        this.isSelled = isselled;
        this.typeid = typeid;
    }
}
