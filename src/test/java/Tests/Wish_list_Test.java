package Tests;

import Classess.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Wish_list_Test extends Base_Test{
    Acount_Manage acountManage;
    Check_Out check_out;
    String Country="United States";String stat="New York";String Zip_code="12345678";
    Cart cart;
    Login login;
    Tv_pages Tv;
    Wish_List wish_list;
    String mail="Abdo0@gmail.com";
    @Test(priority = 1)
    void login(){
        acountManage=pages.acount_manage();
        acountManage.Click_Select();
        acountManage.Click_Log_in();
        login=new Login(acountManage.getDriver());
        login.Clear();
        login.Login(mail,"01117611550");
        Assert.assertTrue(login.Get_Suc_ligon().contains("Abdo"));
    }
    @Test(priority = 2)
    void OpenTv_Add_lcd_wish(){
        Tv=new Tv_pages(login.getDriver());
        Tv.Click_TV();
        Assert.assertTrue(Tv.Clcik_Add_Wish_lcd().contains("LG LCD has been added to your wishlist"));
    }
    @Test(priority = 3)
    void Commint_save(){
        wish_list=new Wish_List(Tv.getDriver());
        wish_list.Set_commint("Abdo 1");
        wish_list.update_wish();
    }
    @Test(priority = 4)
    void Check_Suc(){
        Assert.assertTrue(wish_list.Get_commint().contains("Abdo 1"));
    }
    @Test(priority = 5)
    void Click_ADD_CARD(){
        wish_list.Click_Add_To_Card();
    }
    @Test(priority = 6)
    void Set_Attr_CARD_Click_Check(){
        cart=new Cart(wish_list.getDriver());
        cart.Select_Country(Country);cart.Select_State(stat);cart.Set_code(Zip_code);
        cart.Click_Check_Out();
    }
    @Test(priority = 7)
    void Check_out(){
        check_out=new Check_Out(cart.getDriver());
        String []data=new String[]{"A","12a","Cairo",stat,Zip_code,"01117611550","01122"};
        check_out.Set_Data(data);
        check_out.Check_Money_Order();
    }
    @Test(priority = 8)
    void Print(){
        check_out.print();
        managerEyes.validatewindow();
    }

}
