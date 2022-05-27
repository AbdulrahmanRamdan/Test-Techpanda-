package Tests;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ManagerEyes {
    private WebDriver driver;
    private Eyes eyes;
    private String Appname;

    public ManagerEyes(WebDriver webDriver , String appnamer){
        this.driver=webDriver;
        this.Appname=appnamer;
        inializeeye();
    }
    private void inializeeye() {
        eyes=new Eyes();
        eyes.setApiKey("f21ysT3b0xrGTqxNmusvlGGMm1071odcQlyatDdaOd107pY110");
    }
    public void setBatchname(String BatchName){
        eyes.setBatch(new BatchInfo(BatchName));
    }
    public void validatewindow(){
        eyes.open(driver,Appname,Thread.currentThread().getStackTrace()[2].getMethodName());
        eyes.checkWindow();
        eyes.close();
    }
    public void validateelement(By Locator){
        eyes.open(driver,Appname,Thread.currentThread().getStackTrace()[2].getMethodName());
        eyes.checkElement(Locator);
        eyes.close();
    }
    public void validateframe(String Locator){
        eyes.open(driver,Appname,Thread.currentThread().getStackTrace()[2].getMethodName());
        eyes.checkFrame(Locator);
        eyes.close();
    }
    public void ABORT(){eyes.abortIfNotClosed();}
    public Eyes getEyes(){return eyes;}
}
