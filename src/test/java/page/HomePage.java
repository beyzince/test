package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage extends BasePage{

    static  String PAGE_URL="https://useinsider.com/";

    private By acceptCookiesButton = By.id("wt-cli-accept-all-btn");
    private By moreButtonLocator = By.id("mega-menu-1");

    private By careersButtonLocator = By.xpath("//a[@class='d-flex flex-column flex-fill' and @href='https://useinsider.com/careers/']");
    private  By  careesButton=By.cssSelector(".dropdown-item .flex-row a h5");

    private By navLogoInsider = By.xpath("//*[@id=\"announce\"]");


    public HomePage(WebDriver driver) {

        super(driver);
    }

    @Step("Go to Insider Home Page")
    public  HomePage getInsiderPage(){
        getPage(PAGE_URL);
        return this;
    }

    @Step("Accepting cookies")
    public  HomePage  acceptCookies(){
        click(acceptCookiesButton);
        return  this;
    }

    @Step("Verify Insider Page is opened")
    public HomePage isInsiderMainPageOpened(){
        Assert.assertEquals(isElementDisplayed(navLogoInsider),true,"home page is not opened");
        return  this;
    }

//    @Step("Page Title")
//    public  String getInsiderTitle(){
//        Assert.assertEquals("https://useinsider.com/",getPageTitle(),"Not on home page");
//        return getPageTitle();
//    }


    public  HomePage clickCareersButton(){
        System.out.println("before more button");
        click(moreButtonLocator);
        click(careersButtonLocator);
        return  this;



    }
}
