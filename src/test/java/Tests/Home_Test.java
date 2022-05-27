package Tests;

import Classess.Home;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Home_Test extends Base_Test{
    Home home;
    @Test
    void Test_Title_Home(){
        home=pages.home();
        Assert.assertEquals("Home page",home.Get_title());
    }
}
