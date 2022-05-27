package Classess;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class Mobile_page {
    private WebDriver driver;
    public void get_Url(String url){
        driver.get(url);
    }
    public WebDriver getDriver() {
        return driver;
    }
    private By Com_Items=By.xpath("//*[@id=\"compare-items\"]/li[*]/p/a");
    private By Clear_com=By.linkText("Clear All");
    private By Add_com=By.cssSelector(".link-compare");
    private By Item=By.cssSelector(".item last");
    private By price=By.xpath("//div[2]/div/span/span");
    private By select= By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select");
    private By name= By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select/option[2]");
    public Mobile_page(WebDriver webDriver){this.driver=webDriver;}
    public String Get_Title(){
        return driver.getTitle();
    }
    public String[] Get_names(){
        String []names=new String[3];
        List<WebElement>elements=driver.findElements(By.cssSelector(".product-name"));
        names[0]=elements.get(0).getText();
        names[1]=elements.get(1).getText();
        names[2]=elements.get(2).getText();
        return names;
    }
    public String Select_Name(){
        return driver.findElement(select).getText();
    }
    public void Select_sort_by_name(){
        driver.findElement(select).click();
        driver.findElement(name).click();
    }
    public boolean Check_price_in_2_pages(){
        boolean t=true;
        List<WebElement> items=driver.findElements(Item);
        for (WebElement e:items) {
            String p=e.findElement(By.cssSelector(".price")).getText();
            String utl=driver.getCurrentUrl();
            e.click();
            String pp=driver.findElement(price).getText();
            if(!pp.equals(p)){
                t=false;
                break;
            }
            driver.get(utl);
        }
        return t;
    }
    public String Check_priceitem_in_2_pages(String name){
        String xpath="//li/div/h2/a[contains(text(),'"+name+"')]";
        driver.findElement(By.xpath(xpath)).click();
        return driver.findElement(price).getText();
    }
    public void Click_add_to_card(){
        WebElement element= driver.findElement(By.xpath("//*[contains(@class,'item last')][1]"));
        element.findElement(By.className("btn-cart")).click();
    }
    public void Add_to_Com(){
     driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/ul/li[2]/a")).click();
    }
    public List<String> Get_Com_Items(){
        List<String>item=new ArrayList<>(){};
        try {
            List<WebElement>items=driver.findElements(Com_Items);
            for (WebElement e:items) {
                item.add(e.getText());
            }
        }
        catch (Exception e){}
        return item;
    }
    public void Click_clear(){
        driver.findElement(Clear_com).click();
    }
    public String Get_Alert_SMS() {
        WebDriverWait wait=new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert().getText();
    }
    public void Dismiss_Alert(){
        WebDriverWait wait=new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.alertIsPresent());
       driver.switchTo().alert().dismiss();
    }
    public void ACC_Alert(){
        WebDriverWait wait=new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(Com_Items));
    }
}
