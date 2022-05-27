package Tests;

import Classess.Home;
import Classess.Mobile_page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Discount_Test extends Base_Test{
    WebDriver driver;
    Mobile_page mobile_page;
    @Test
    void discount(){
       Home home=pages.home();
        mobile_page=home.Click_Mobile();
        driver= mobile_page.getDriver();
        driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/div[3]/button")).click();
       // String price=driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[3]/span/span")).getText();
        driver.findElement(By.id("coupon_code")).sendKeys("GURU50");
        driver.findElement(By.cssSelector("#discount-coupon-form > div > div > div > div > button > span > span")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"shopping-cart-totals-table\"]/tbody/tr[2]/td[2]/span")).getText().contains("25"));
    }

}
