package utils;

import bean.Brand;
import bean.Car;
import bean.CarType;
import client.MessageShowListener;
import client.SearchPage;
import dao.BrandDao;
import dao.CarDao;
import dao.CarTypeDao;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageShow  {

    BrandDao brandDao=new BrandDao();
    CarDao carDao=new CarDao();
    Brand brand=new Brand();
    Car car= new Car();
    CarType carType=new CarType();
    CarTypeDao carTypeDao=new CarTypeDao();


    public Map<Integer,Integer> streamLiningShow(){
        System.out.println("\t品牌\t\t车型\t\t里程数\t\t价格\t\t发布时间");
        int i=1,n=0;
        Map<Integer,Integer> checkMap =new HashMap<>();
        for (Map<String,Object> map:carDao.latestUsedCar()){
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
            System.out.println(i+++"\t"+brand.getBrandname()+"\t\t"+carType.getTypename()+"\t\t"+
                    car.getMileage()+"\t\t"+car.getPrice()+"\t\t"+car.getReleasedate());
            checkMap.put(n++,car.getCarid());
        }
        return checkMap;
    }


    public void datailedShow(Map<Integer,Integer> checkMap,MessageShowListener listener){
        System.out.println("输入对应编号查看详细\t输入#返回主菜单");
        String check=ScTool.scannerString();
        if ("#".equals(check)){
            listener.onMessageShowCallback();
        }else {
            int checks= Integer.parseInt(check);
            System.out.println("\t品牌\t\t车型\t\t里程数\t\t价格\t\t发布时间\t\t排量\t\t上牌时间\t\t离合器类型");
            for (Map<String,Object>map:carDao.messageCarById(checkMap.get(checks-1))){
                ConvertUtils.register(new DateLocaleConverter(), Date.class);
                try {
                    ConvertUtils.register(new DateLocaleConverter(), java.util.Date.class);
                    BeanUtils.populate(brand,map);
                    BeanUtils.populate(carType,map);
                    BeanUtils.populate(car,map);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
                System.out.println(brand.getBrandname()+"\t"+
                        carType.getTypename()+"\t"+car.getMileage()+"\t"+
                        car.getPrice()+"\t"+car.getReleasedate()+"\t"+car.getCarid()+"\t"+
                        car.getDisplacement()+"\t"+car.getLicencedate()+"\t"+car.getCluth());
            }
            listener.onMessageShowCallbackShopping(car.getCarid());
        }
    }

    public Map<Integer,Integer> showBrand(){
        int i=1,n=0;
        Map<Integer,Integer> checkMap =new HashMap<>();
        for (Brand brand:brandDao.brandsNameId()){
            System.out.println(i+++"\t"+brand.getBrandname());
            checkMap.put(n++,brand.getBrandid());
        }
        return checkMap;
    }

    public List<Integer> showTypeNameByBrandid(Map<Integer,Integer> checkMap, MessageShowListener listener){
        System.out.println("输入对应编号查看类型\t输入#返回上一菜单");
        Map<Integer,Integer> checksMap =new HashMap<>();
        String check=ScTool.scannerString();
        int checks = 0;
        if ("#".equals(check)){
            listener.onMessageShowCallback();
        }else {
            checks= Integer.parseInt(check);
            int i=1,n=0;
            for (CarType carType:carTypeDao.carTypeNameIdByBrandid(checkMap.get(checks-1))){
                System.out.println(i+++"\t"+carType.getTypename());
                checksMap.put(n++,carType.getTypeid());
            }
        }
        System.out.println("输入对应编号查看详细信息");
        check=ScTool.scannerString();
        int choose= 0;
        List<Integer> finalcheck = new ArrayList<>();
        if ("#".equals(check)){
            listener.onMessageShowCallback();
        }else {
            choose= Integer.parseInt(check);
            //brandid cartypeid
            finalcheck=new ArrayList<>();
            finalcheck.add(checkMap.get(checks-1));
            finalcheck.add(checksMap.get(choose-1));
            System.out.println("\t品牌\t\t车型\t\t里程数\t\t价格\t\t发布时间\t\t排量\t\t上牌时间\t\t离合器类型");
            return finalcheck;
        }
        return finalcheck;
    }


    public List<Integer> caridByBrandidTypeid(int brandid,int typeid){
        List<Integer> carid = new ArrayList<>();
        int i=1;
        for (Map<String,Object> map: carDao.carByBrandidTypeid(brandid,typeid)){
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
        return carid;
    }


    public Map<Integer,Integer> streamLiningShowByprice(double min,double max){
        System.out.println("\t品牌\t\t车型\t\t里程数\t\t价格\t\t发布时间");
        int i=1,n=0;
        Map<Integer,Integer> checkMap =new HashMap<>();
        for (Map<String,Object> map:carDao.findByPrice(min,max)){
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
            System.out.println(i+++"\t"+brand.getBrandname()+"\t\t"+carType.getTypename()+"\t\t"+
                    car.getMileage()+"\t\t"+car.getPrice()+"\t\t"+car.getReleasedate());
            checkMap.put(n++,car.getCarid());
        }
        return checkMap;
    }

    public Map<Integer,Integer> streamLiningShowBydate(String min,String max){
        System.out.println("\t品牌\t\t车型\t\t里程数\t\t价格\t\t发布时间");
        int i=1,n=0;
        Map<Integer,Integer> checkMap =new HashMap<>();
        for (Map<String,Object> map:carDao.findByDate(min,max)){
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
            System.out.println(i+++"\t"+brand.getBrandname()+"\t\t"+carType.getTypename()+"\t\t"+
                    car.getMileage()+"\t\t"+car.getPrice()+"\t\t"+car.getReleasedate());
            checkMap.put(n++,car.getCarid());
        }
        return checkMap;
    }
}
