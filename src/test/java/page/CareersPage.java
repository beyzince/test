package page;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CareersPage extends  BasePage{

    static  String PAGE_URL_CAREERS="https://useinsider.com/careers/";
//    @FindBy(id="#career-our-location")
//    private WebElement checkLocationLocator;
//    @FindBy(id="#career-our-location")
//    private WebElement checkTeamsLocator;
//    @FindBy("")
//    private WebElement checkLifeAtInsiderLocator;
//    @FindBy()
//    private WebElement seeAllTeamsButtonLocator;
//    @FindBy()
//    private WebElement qualityAssuranceButtonLocator;
    private By seeAllTeamsButtonLocator = By.cssSelector("a[class='btn btn-outline-secondary rounded text-medium mt-5 mx-auto py-3 loadmore']");
    @FindBy(xpath = "//*[@id=\"career-find-our-calling\"]/div/div/a")
   private WebElement seeAllTeamsButtonLocator1;
    private By qualityAssuranceButtonLocator = By.xpath("(//h3[@class='text-center mb-4 mb-xl-5'])[12]");
    private By checkTeamsLocator = By.cssSelector("a[class='btn btn-outline-secondary rounded text-medium mt-5 mx-auto py-3 loadmore']");
    private By checkLocationsLocator = By.cssSelector("h3[class='category-title-media ml-0']");
    private By checkLifeAtInsiderLocator = By.xpath("(//h2[@class='elementor-heading-title elementor-size-default'])[2]");

    public CareersPage(WebDriver driver) {
        super(driver);
    }


    private String teamsGetText(){
        return getTextAttribute(checkTeamsLocator);
    }
    private String locationGetText(){
        return getTextAttribute(checkLocationsLocator);
    }
    private String lifeAtInsiderGetText(){
        return getTextAttribute(checkLifeAtInsiderLocator);
    }


    public  CareersPage verifyCareersPageOpened(){
        getPage(PAGE_URL_CAREERS);
//        Assert.assertEquals("",getPageTitle(),"Not on home page");
        Assert.assertEquals("Insider Careers",getPageTitle(),"Not on Career Page");
        return  this;
    }


    public CareersPage checkBlocksOfCareerPage() throws InterruptedException {
        Assert.assertEquals("See all teams",teamsGetText(),"no teams");
        Assert.assertEquals("Locations",locationGetText(),"no locations");
        Assert.assertEquals("Life insider",lifeAtInsiderGetText()," no life insider");

        return this;
    }

    public CareersPage checkIsOpenedCareerPage(){
        Assertions.assertEquals("Insider Careers", getPageTitle(), "Not on Career Page");
        return this;
    }

    public CareersPage clickSeeAllTeams() throws InterruptedException {

        scrollToPage();
        click(seeAllTeamsButtonLocator);
        return this;
    }

    public QualityAssurancePage clickQualityAssurance() {
        scrollToPage();
        click(qualityAssuranceButtonLocator);
        return new QualityAssurancePage();


    }
}
