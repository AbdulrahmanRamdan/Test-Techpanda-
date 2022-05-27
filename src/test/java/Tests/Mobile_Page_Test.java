package Tests;

import Classess.Home;
import Classess.Mobile_page;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Mobile_Page_Test extends Base_Test{
    Mobile_page mobile_page;
    Home home;
    String []names_By_pos={"IPHONE","SAMSUNG GALAXY","SONY XPERIA"};
    String []names_By_name={"IPHONE","SAMSUNG GALAXY","SONY XPERIA"};
    @Test(priority = 1)
    void Check_name(){
        home=pages.home();
        mobile_page=home.Click_Mobile();
        Assert.assertEquals("Mobile",mobile_page.Get_Title());
    }
    @Test(priority = 2)
    void Names_By_Pos(){
        Assert.assertTrue(mobile_page.Select_Name().split("\n" +
                "                                             ")[0].contains("Position"));
        String[]names= mobile_page.Get_names();
        Assert.assertEquals(names,names_By_pos);
    }
    @Test(priority = 3)
    void Names_By_name(){
        mobile_page.Select_sort_by_name();
        String[]names= mobile_page.Get_names();
        Assert.assertEquals(names,names_By_name);
    }
    @Test(priority = 4)
    void Checkprice(){
        Assert.assertTrue(mobile_page.Check_priceitem_in_2_pages("Sony Xperia").contains("100"));
       // Assert.assertTrue(mobile_page.Check_price_in_2_pages());
    }
    @Test(priority = 5)
    void Click_com_2_items(){
        mobile_page.get_Url("http://live.techpanda.org/index.php/mobile.html");
        mobile_page.Add_to_Com();
        List<String> Ac=new ArrayList<>(){};
        Ac.add("IPHONE");Ac.add("SAMSUNG GALAXY");
        Assert.assertEquals(mobile_page.Get_Com_Items(),Ac);
    }
    @Test(priority = 6)
    void Check_Alert()  {
        mobile_page.Click_clear();
        Assert.assertEquals(mobile_page.Get_Alert_SMS(),"Are you sure you would like to remove all products from your comparison?");
    }
    @Test(priority = 7)
    void Clear_dismiss(){
        mobile_page.Dismiss_Alert();
        List<String> Ac=new ArrayList<>(){};
        Ac.add("IPHONE");Ac.add("SAMSUNG GALAXY");
        Assert.assertEquals(mobile_page.Get_Com_Items(),Ac);
    }
    @Test(priority = 8)
    void Clear_acc(){
        mobile_page.Click_clear();
        mobile_page.ACC_Alert();
        List<String> Ac=new ArrayList<>(){};
        Assert.assertEquals(mobile_page.Get_Com_Items(),Ac);
    }

}
