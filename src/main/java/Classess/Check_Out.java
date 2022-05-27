package Classess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

public class Check_Out {
    WebDriver driver;
    By print=By.linkText("here to print");
    By Company= By.id("billing:company");
    By Address1=By.id("billing:street1");
    By Address2=By.id("billing:street2");
    By City=By.id("billing:city");
    By Stat=By.id("billing:region_id");
    By Zip_code=By.id("billing:postcode");
    By Telph=By.id("billing:telephone");
    By Fax=By.id("billing:fax");
    By Btn_Con=By.xpath("//*[contains(@id,'billing-buttons-container')]/button");
    By Radio_Order=By.id("p_method_checkmo");
    public Check_Out(WebDriver webDriver){this.driver=webDriver;}
    public WebDriver getDriver() {
        return driver;
    }
    public void Set_Data(String[]data){
        driver.findElement(Company).clear();
        driver.findElement(Address1).clear();
        driver.findElement(Address2).clear();
        driver.findElement(Zip_code).clear();
        driver.findElement(Telph).clear();
        driver.findElement(Fax).clear();
        driver.findElement(City).clear();
        driver.findElement(Company).sendKeys(data[0]);
        driver.findElement(Address1).sendKeys(data[1]);
        driver.findElement(Address2).sendKeys(data[1]);
        driver.findElement(City).sendKeys(data[2]);
        String path="//*[contains(text(),'"+data[3]+"')]";
        By stat=By.xpath(path);
        driver.findElement(Stat).click();
        driver.findElement(stat).click();
        driver.findElement(Zip_code).sendKeys(data[4]);
        driver.findElement(Telph).sendKeys(data[5]);
        driver.findElement(Fax).sendKeys(data[0]);
        driver.findElement(Btn_Con).click();
    }
    public void Check_Money_Order(){
        driver.findElement(By.xpath("//*[contains(@id,'shipping-method-buttons-container')]/button")).click();
        driver.findElement(Radio_Order).click();
        driver.findElement(By.xpath("//*[contains(@id,'payment-buttons-container')]/button")).click();
        driver.findElement(By.xpath("//*[contains(@id,'review-buttons-container')]/button")).click();
    }
    public void print(){
        driver.findElement(print).click();
    }
}
