package Classess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cart {
    WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    WebDriverWait wait;
    By input_Q= By.xpath("//*[contains(@class,'input-text qty')]");
    By btn_Update=By.xpath("//*[contains(@class,'button btn-update')]");
    By erroe_msg=By.xpath("//*[contains(@class,'item-msg error')]");
    By Empty_btn=By.xpath("//*[contains(@class,'button2 btn-empty')]");
    By title=By.xpath("//*[contains(@class,'page-title')]");
    By Select_Country=By.id("country");
    By Select_State=By.id("region_id");
    By Zip_COde=By.id("postcode");
    By Check_out=By.className("btn-proceed-checkout");
    public Cart(WebDriver driver){this.driver=driver;wait=new WebDriverWait(driver,3);}
    public void update_Qantity(String Qan){
        driver.findElement(input_Q).sendKeys(Qan);
    }
    public void Click_update(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(btn_Update));
        driver.findElement(btn_Update).click();
    }
    public String Get_Error_massege(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(erroe_msg));
        return driver.findElement(erroe_msg).getText();
    }
    public void Click_Empty(){
        driver.findElement(Empty_btn).click();
    }
    public String Get_Title_massege(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(title));
        return driver.findElement(title).getText();
    }
    public void Select_Country(String country){
        WebDriverWait wait=new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Select_Country));
        String path="//*[contains(text(),'"+country+"')]";
        By Country=By.xpath(path);
        driver.findElement(Select_Country).click();
        driver.findElement(Country).click();
    }
    public void Select_State(String State){
        String path="//*[contains(text(),'"+State+"')]";
        By stat=By.xpath(path);
        driver.findElement(Select_State).click();
        driver.findElement(stat).click();
    }
    public void Set_code(String code){
        driver.findElement(Zip_COde).sendKeys(code);
    }
    public void Click_Check_Out(){
        driver.findElement(Check_out).click();
    }

}
