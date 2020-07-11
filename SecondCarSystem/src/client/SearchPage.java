package client;

import utils.MessageShow;
import utils.ScTool;

import java.util.List;
import java.util.Map;

public class SearchPage extends BasePage implements MessageShowListener {

    MessageShow messageShow;
    ShoppingPage shoppingPage;

    public SearchPage() {
        messageShow = new MessageShow();
        shoppingPage = new ShoppingPage();
    }


    public void searchCar() {
        System.out.println("1、根据品牌搜索");
        System.out.println("2、根据价格搜索");
        System.out.println("3、根据上牌日期搜索");
        System.out.println("4、返回主菜单");
        String check = ScTool.scannerString();
        switch (check) {
            case "1":
                searchByBrand();
                break;
            case "2":
                searchByPrice();
                break;
            case "3":
                searchByLicencedate();
                break;
            case "4":
                ((MainPage) App.navigation.get(MainPage.class.getSimpleName())).main();
                break;
            default:
                searchCar();
                break;
        }
    }

    public void latestUsedCar() {
        //返回选择项和汽车id
        Map<Integer, Integer> checkMap = messageShow.streamLiningShow();
        //根据接口返回
        messageShow.datailedShow(checkMap, this);

    }

    /**
     * 根据品牌搜索
     */
    public void searchByBrand() {
        //品牌搜索完成
        Map<Integer, Integer> brandMap = messageShow.showBrand();
        //品牌下车型搜索
        List<Integer> carBybrandidTypeid = messageShow.showTypeNameByBrandid(brandMap, new MessageShowListener() {
            @Override
            public void onMessageShowCallback() {
                searchByBrand();
            }

            @Override
            public void onMessageShowCallbackShopping(int carid) {
                shoppingPage.shoppingMenu(carid);
            }
        });
        //返回汽车id
        List<Integer> carid = messageShow.caridByBrandidTypeid(carBybrandidTypeid.get(0), carBybrandidTypeid.get(1));
        if (carid==null||carid.size()==0){
            System.out.println("\n\t售空请重新选择");
            searchCar();
        }else {
            System.out.println("选择车辆");
            int check = ScTool.scannerInt();
            shoppingPage.shoppingMenu(carid.get(check - 1));
        }

    }

    public void searchByPrice() {
        //请选择价格区间
        System.out.println("输入最低价");
        double min = ScTool.scannerDouble();
        System.out.println("输入最高价");
        double max = ScTool.scannerDouble();
        //根据价格区间查找回集合
        Map<Integer, Integer> brandMap = messageShow.streamLiningShowByprice(min, max);
        if (brandMap==null||brandMap.size()==0){
            System.out.println("\n\t售空请重新选择");
            searchCar();
        }else {
            messageShow.datailedShow(brandMap, this);
        }
    }

    public void searchByLicencedate() {
        System.out.println("起始年份和月份日期");
        String mindate = ScTool.scannerString();
        System.out.println("结束年份和月份日期");
        String maxdate = ScTool.scannerString();
        Map<Integer, Integer> brandMap = messageShow.streamLiningShowBydate(mindate, maxdate);
        if (brandMap==null||brandMap.size()==0){
            System.out.println("\n\t售空请重新选择");
            searchCar();
        }else {
            messageShow.datailedShow(brandMap, this);
        }
    }

    @Override
    public void onMessageShowCallback() {
        ((MainPage) App.navigation.get(MainPage.class.getSimpleName())).main();
    }

    @Override
    public void onMessageShowCallbackShopping(int carid) {
        shoppingPage.shoppingMenu(carid);
    }
}
