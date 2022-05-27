package Classess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home {
    private WebDriver driver;
    private By Moblie=By.cssSelector("#nav > ol > li.level0.nav-1.first > a");
    public Home(WebDriver webDriver){this.driver=webDriver;}
    public String Get_title(){
        return driver.getTitle();
    }
    public Mobile_page Click_Mobile(){
        driver.findElement(Moblie).click();
        return new Mobile_page(driver);
    }
}
