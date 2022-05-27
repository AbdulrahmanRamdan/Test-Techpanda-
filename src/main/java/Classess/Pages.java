package Classess;

import org.openqa.selenium.WebDriver;

public class Pages {
    private WebDriver driver;
    public Pages(WebDriver webDriver){this.driver=webDriver;}
    public Home home(){return new Home(driver);}
    public Mobile_page mobile_page(){return new Mobile_page(driver);}
    public Acount_Manage acount_manage(){return new Acount_Manage(driver);}
}
