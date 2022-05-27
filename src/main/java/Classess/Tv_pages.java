package Classess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Tv_pages {
    WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    By Tv_a= By.className("nav-2");
    By Add_wish=By.xpath("//*[contains(@class,'add-to-links')]/li[1]");
    public Tv_pages(WebDriver w){this.driver=w;}
    public void Click_TV(){driver.findElement(Tv_a).click();}
    public String Clcik_Add_Wish_lcd(){
        driver.findElements(Add_wish).get(0).click();
        return driver.findElement(By.className("success-msg")).getText();
    }

}
