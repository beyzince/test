package test;

import driver.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest extends DriverManager {


    @BeforeTest
    @Parameters(value={"browserName"})
    public void initializeBrowser(@Optional String browserName){
        if(browserName==null){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().window().maximize();

        }else{
            setDriver(browserName);
        }

    }


    @AfterTest
    public  void quitDriver(){
        terminateBrowser();
    }
}
