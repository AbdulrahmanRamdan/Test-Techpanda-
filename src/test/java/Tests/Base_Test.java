package Tests;

import Classess.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class Base_Test {
    private WebDriver driver;
    protected ManagerEyes managerEyes;
    protected Pages pages;
    @BeforeClass
    void Start_Up(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ABDO\\Downloads\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("http://live.techpanda.org/index.php");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        managerEyes=new ManagerEyes(driver,"TechPanda");
        pages=new Pages(driver);
    }
    @AfterClass
    void finish(){
        //driver.quit();
    }

}
