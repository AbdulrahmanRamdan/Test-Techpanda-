package Tests;

import Classess.Acount_Manage;
import Classess.Cart;
import Classess.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Reorder extends Base_Test{
    Login  login;
    Acount_Manage acountManage;
    String mail="Abdo0@gmail.com";
    WebDriver driver;
    String Country="United States";String stat="New York";String Zip_code="12345678";
    String price;
    Cart cart;
    @Test(priority = 1)
    void login(){
        acountManage=pages.acount_manage();
        acountManage.Click_Select();
        acountManage.Click_Log_in();
        login=new Login(acountManage.getDriver());
        login.Clear();
        login.Login(mail,"01117611550");
        Assert.assertTrue(login.Get_Suc_ligon().contains("Abdo"));
        driver=login.getDriver();
    }
    @Test(priority = 2)
    void Click_reoder_and_update(){
        price=driver.findElement(By.className("price")).getText();
        driver.findElement(By.linkText("REORDER")).click();
        driver.findElement(By.cssSelector("#shopping-cart-table > tbody > tr > td.product-cart-actions > input")).clear();
        driver.findElement(By.cssSelector("#shopping-cart-table > tbody > tr > td.product-cart-actions > input")).sendKeys("2");
        driver.findElement(By.cssSelector("#shopping-cart-table > tbody > tr > td.product-cart-actions > button")).click();
    }
    @Test(priority = 3)
    void Set_Cart_Data(){
        cart=new Cart(driver);
        cart.Select_Country(Country);cart.Select_State(stat);cart.Set_code(Zip_code);
        driver= cart.getDriver();
        Assert.assertNotEquals(driver.findElement(By.cssSelector("#shopping-cart-totals-table > tfoot > tr > td:nth-child(2) > strong > span")).getText(),price);
       cart.Click_Check_Out();
    }
    @Test(priority = 4)
    void Con_pilling(){
        driver.findElement(By.cssSelector("#billing-buttons-container > button > span > span")).click();
        driver.findElement(By.cssSelector("#shipping-method-buttons-container > button")).click();
        driver.findElement(By.id("p_method_checkmo")).click();
        driver.findElement(By.cssSelector("#payment-buttons-container > button")).click();
        driver.findElement(By.cssSelector("#review-buttons-container > button")).click();
    }
}
