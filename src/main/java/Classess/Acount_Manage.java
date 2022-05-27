package Classess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Acount_Manage {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    private By Register=By.xpath("//*[contains(text(),'Register')]");
    private By My_Wichlist=By.xpath("//*[contains(text(),'My Wishlist')]");
    private By Log_In=By.xpath("//*[contains(text(),'Log In')]");
    private By Acount_Select=By.className("skip-account");
    private By Log_Out=By.xpath("//*[contains(text(),'Log Out')]");

    public Acount_Manage(WebDriver webDriver){this.driver=webDriver;}
    public void Click_Select(){
        driver.findElement(Acount_Select).click();
    }
    public void Click_Register(){
        driver.findElement(Register).click();
    }
    public void Click_Log_in(){driver.findElement(Log_In).click();}
    public String Get_suc_mas(){return driver.findElement(By.className("hello")).getText();}
    public void Click_Wichlist(){driver.findElement(My_Wichlist).click();}
    public void Click_Log_Out(){driver.findElement(Log_Out).click();}
}
