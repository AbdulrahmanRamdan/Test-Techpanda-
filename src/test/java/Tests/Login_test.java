package Tests;

import Classess.Acount_Manage;
import Classess.Login;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login_test extends Base_Test{
    Acount_Manage acountManage;
    Login login;
    String mail="Abdo7@gmail.com";
    @Test(priority = 1)
    void Click_login(){
        acountManage=pages.acount_manage();
        acountManage.Click_Select();
        acountManage.Click_Log_in();
    }
    @Test(priority = 2)
    void Check_pass_error(){
        login=new Login(acountManage.getDriver());
        login.Login(mail,"00");
        Assert.assertTrue(login.Get_pass_Error().contains("Please enter 6 or more characters without leading or trailing spaces."));
    }
    @Test(priority = 3)
    void Check_login_Error(){
        login.Clear();
        login.Login(mail,"01111761155");
        Assert.assertTrue(login.Get_Login_Error().contains("Invalid login or password."));
    }
    @Test(priority = 4)
    void Suc_login(){
        login.Clear();
        login.Login(mail,"01117611550");
        Assert.assertTrue(login.Get_Suc_ligon().contains("Abdo"));
    }
}
