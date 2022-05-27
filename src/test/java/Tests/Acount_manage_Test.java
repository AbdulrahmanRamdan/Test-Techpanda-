package Tests;

import Classess.Acount_Manage;
import Classess.Register;
import com.sun.source.tree.AssertTree;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Acount_manage_Test extends Base_Test{
    private Acount_Manage acountManage;
    Register register;
    String[]parameters=new String[]{"Abdo","Ramadan","Ramadan","Abdo7@gmail.com","01117611550","01117611550"};
    @Test(priority = 1)
    void Click_Account(){
        acountManage=pages.acount_manage();
        acountManage.Click_Select();
    }

    void Click_Redister(){
        acountManage.Click_Register();
        register=new Register(acountManage.getDriver());
    }
    @Test(priority = 2)
    void Pass_com_error(){
        Click_Redister();
        parameters[5]="01111111";
        register.CLear();
        register.Register(parameters);
        register.Click_Reg();
       Assert.assertTrue( register.Get_Error_of_pass().contains("Please make sure your passwords match."));
    }
    @Test(priority = 3)
    void Succes_Reg(){
        parameters[5]="01117611550";
        register.CLear();
        register.Register(parameters);
        register.Click_Reg();
        Assert.assertTrue(register.Get_suc().contains(parameters[0]));
    }
    @Test(priority = 4)
    void Same_Email(){
        acountManage.Click_Select();
        acountManage.Click_Log_Out();
        acountManage.Click_Select();
        Click_Redister();
        register.Register(parameters);
        register.Click_Reg();
        Assert.assertTrue(register.Get_error_email().contains("There is already an account with this email address."));
    }
}
