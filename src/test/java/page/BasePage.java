package page;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;
    JavascriptExecutor js;

    private final static int TIME_OUT_DURATION = 20;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        js=(JavascriptExecutor)driver;
        PageFactory.initElements(driver,this);
    }

    private  void waitFor(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));


    }
    private WebElement findBy(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }
    public  void  click(By locator){
        waitFor(locator);
        findBy(locator).click();
    }
    public void setText(By locator, String text){
        waitFor(locator);
        findBy(locator).clear();
        findBy(locator).sendKeys(text);

    }

    public boolean isElementDisplayed(By locator){
        waitFor(locator);
        return  findBy(locator).isDisplayed();
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public  void  getPage(String url){
        driver.get(url);
    }
    public String getText(By locator){
        waitFor(locator);
        return findBy(locator).getText();
    }
//    public void scrollDown(){
//        js.executeScript("window.scrollBy(0,600)");
//    }
//
//    public void scrollDownByValue(int value){
//        String script = "window.scrollBy(0,"+ value + ")";
//        js.executeScript(script);
//    }

    public void scrollToPage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

    }
    public List<WebElement> listElements(By locator){

        return driver.findElements(locator);
    }

    public String getTextAttribute(By locator) {
        return findBy(locator).getAttribute("innerHTML");
    }

}
