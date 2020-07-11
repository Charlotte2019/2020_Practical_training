package test;

import bean.Brand;
import bean.Car;
import bean.CarType;
import dao.CarDao;
import dao.CarTypeDao;
import dao.UserDao;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestUserDao {
    UserDao userDao=new UserDao();
    CarDao carDao=new CarDao();
    Brand brand=new Brand();
    Car car=new Car();
    CarType carType=new CarType();
    CarTypeDao carTypeDao=new CarTypeDao();

    @Test
    public void findNamePwd(){
        System.out.println(userDao.findNamePwd());
    }

    @Test
    public void latestUsedCar(){
        for (Map<String,Object>map:carDao.latestUsedCar()){
            ConvertUtils.register(new DateLocaleConverter(), Date.class);
            try {
                ConvertUtils.register(new DateLocaleConverter(), java.util.Date.class);
                BeanUtils.populate(brand,map);
                BeanUtils.populate(carType,map);
                BeanUtils.populate(car,map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            System.out.println(brand.getBrandname()+"\t"+
                    carType.getTypename()+"\t"+car.getMileage()+"\t"+
                    car.getPrice()+"\t"+car.getReleasedate()+"\t"+car.getCarid());
        }
    }
    @Test
    public void messageCarById(){

        for (Map<String,Object>map:carDao.messageCarById(1)){
            ConvertUtils.register(new DateLocaleConverter(), Date.class);
            try {
                ConvertUtils.register(new DateLocaleConverter(), java.util.Date.class);
                BeanUtils.populate(brand,map);
                BeanUtils.populate(carType,map);
                BeanUtils.populate(car,map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            System.out.println(brand.getBrandname()+"\t"+
                    carType.getTypename()+"\t"+car.getMileage()+"\t"+
                    car.getPrice()+"\t"+car.getReleasedate()+"\t"+car.getCarid()+"\t"+
                    car.getDisplacement()+"\t"+car.getLicencedate()+"\t"+car.getCluth());
        }

    }

    @Test
    public void showTypeNameByBrandid(){
        for (CarType carType:carTypeDao.carTypeNameIdByBrandid(1)){
            System.out.println(carType.getTypename());
        }
    }

    @Test
    public void findByPrice() {
        for (Map<String,Object>map:carDao.findByPrice(9000,900000)){
            ConvertUtils.register(new DateLocaleConverter(), Date.class);
            try {
                ConvertUtils.register(new DateLocaleConverter(), java.util.Date.class);
                BeanUtils.populate(brand,map);
                BeanUtils.populate(carType,map);
                BeanUtils.populate(car,map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            System.out.println(brand.getBrandname()+"\t"+
                    carType.getTypename()+"\t"+car.getMileage()+"\t"+
                    car.getPrice()+"\t"+car.getReleasedate()+"\t"+car.getCarid()+"\t"+
                    car.getDisplacement()+"\t"+car.getLicencedate()+"\t"+car.getCluth());
        }
    }

    @Test
    public void findByDate() {
        for (Map<String,Object>map:carDao.findByDate("1999-1-1","2222-1-1")){
            ConvertUtils.register(new DateLocaleConverter(), Date.class);
            try {
                ConvertUtils.register(new DateLocaleConverter(), java.util.Date.class);
                BeanUtils.populate(brand,map);
                BeanUtils.populate(carType,map);
                BeanUtils.populate(car,map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            System.out.println(brand.getBrandname()+"\t"+
                    carType.getTypename()+"\t"+car.getMileage()+"\t"+
                    car.getPrice()+"\t"+car.getReleasedate()+"\t"+car.getCarid()+"\t"+
                    car.getDisplacement()+"\t"+car.getLicencedate()+"\t"+car.getCluth());
        }
    }

    @Test
    public void carByBrandidTypeid(){
        List<Integer> carid = new ArrayList<>();
        int i=1;
        for (Map<String,Object> map: carDao.carByBrandidTypeid(2,3)){
            ConvertUtils.register(new DateLocaleConverter(), Date.class);
            try {
                ConvertUtils.register(new DateLocaleConverter(), java.util.Date.class);
                BeanUtils.populate(brand,map);
                BeanUtils.populate(carType,map);
                BeanUtils.populate(car,map);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            System.out.println(i+++"\t"+brand.getBrandname()+"\t"+
                    carType.getTypename()+"\t"+car.getMileage()+"\t"+
                    car.getPrice()+"\t"+car.getReleasedate()+"\t"+car.getCarid()+"\t"+
                    car.getDisplacement()+"\t"+car.getLicencedate()+"\t"+car.getCluth());
            carid.add(car.getCarid());
        }
        if (carid==null||carid.size()==0){
            System.out.println("+++++++++++++++");
        }
    }


}
