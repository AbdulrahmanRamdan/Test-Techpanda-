package Classess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Wish_List {
private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    By commint= By.xpath("//*[contains(@title,'Comment')]");
By Update_btn=By.xpath("//*[contains(@class,'item-manage')]/button");
By Add_To_Card=By.className("btn-cart");

public Wish_List(WebDriver webDriver){this.driver=webDriver;}
public void Set_commint(String com){
    driver.findElement(commint).sendKeys(com);
}
public void update_wish(){
    driver.findElement(Update_btn).click();
}
public String Get_commint(){
    return driver.findElement(commint).getText();
}
public void Click_Add_To_Card(){
    driver.findElement(Add_To_Card).click();
}

}
