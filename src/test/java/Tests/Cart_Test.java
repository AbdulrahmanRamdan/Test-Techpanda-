package Tests;

import Classess.Cart;
import Classess.Mobile_page;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Locale;

public class Cart_Test extends Base_Test{
    Mobile_page mobile_page;
    Cart cart;
    @Test(priority = 1)
    void click_item(){
        mobile_page=pages.home().Click_Mobile();
        mobile_page.Click_add_to_card();
        cart=new Cart(mobile_page.getDriver());
    }
    @Test(priority = 2)
    void UpdateQuatity(){
        cart.update_Qantity("1000");
    }
    @Test(priority = 3)
    void Click_update(){
        cart.Click_update();
        Assert.assertTrue(cart.Get_Error_massege().contains("The maximum quantity allowed for purchase is 500."));
    }
    @Test(priority = 4)
    void Click_Empty(){
        cart.Click_Empty();
        Assert.assertEquals(cart.Get_Title_massege(),"Shopping Cart is Empty".toUpperCase(Locale.ROOT));
    }
}
