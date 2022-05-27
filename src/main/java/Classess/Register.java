package Classess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Register {
    private WebDriver driver;
    private By frist_name=By.id("firstname");
    private By middle_name=By.id("middlename");
    private By Last_name=By.id("lastname");
    private By Email=By.id("email_address");
    private By Password=By.id("password");
    private By comfirm=By.id("confirmation");
    public Register(WebDriver webDriver){this.driver=webDriver;}
    public void Register(String[] Reg ){
        driver.findElement(frist_name).sendKeys(Reg[0]);
        driver.findElement(middle_name).sendKeys(Reg[1]);
        driver.findElement(Last_name).sendKeys(Reg[2]);
        driver.findElement(Email).sendKeys(Reg[3]);
        driver.findElement(Password).sendKeys(Reg[4]);
        driver.findElement(comfirm).sendKeys(Reg[5]);
    }
    public void CLear(){
        driver.findElement(frist_name).clear();
        driver.findElement(middle_name).clear();
        driver.findElement(Last_name).clear();
        driver.findElement(Email).clear();
        driver.findElement(Password).clear();
        driver.findElement(comfirm).clear();
    }
    public String Get_error_email(){
        return driver.findElement(By.cssSelector("body > div > div > div.main-container.col1-layout > div > div > div > ul > li > ul > li > span")).getText();
    }
    public void Click_Reg(){
        driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div[2]/button")).click();
    }
    public String Get_Error_of_pass(){
       return driver.findElement(By.id("advice-validate-cpassword-confirmation")).getText();
    }
    public String Get_suc(){
        return driver.findElement(By.className("hello")).getText();
    }
}
