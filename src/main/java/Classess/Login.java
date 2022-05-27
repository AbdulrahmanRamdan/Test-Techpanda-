package Classess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    By Email= By.id("email");
    By Pass=By.id("pass");
    By login_btn=By.id("send2");
    By login_error=By.cssSelector("body > div > div > div.main-container.col1-layout > div > div > div > ul > li > ul > li > span");
    By Pass_error=By.id("advice-validate-password-pass");
    public Login(WebDriver webDriver){this.driver=webDriver;}
    public void Login(String useer,String mail){
        driver.findElement(Email).sendKeys(useer);
        driver.findElement(Pass).sendKeys(mail);
        driver.findElement(login_btn).click();
    }
    public void Clear(){
        driver.findElement(Email).clear();
        driver.findElement(Pass).clear();
    }
    public String Get_Login_Error(){
        return driver.findElement(login_error).getText();
    }
    public String Get_pass_Error(){
        return driver.findElement(Pass_error).getText();
    }
    public String Get_Suc_ligon(){
         return driver.findElement(By.className("hello")).getText();
    }
}
