package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QualityAssurancePage extends  BasePage{



    private By allQAJobsButtonLocator=By.cssSelector("a[class='btn btn-outline-secondary rounded text-medium mt-2 py-3 px-lg-5 w-100 w-md-50']");

    public QualityAssurancePage(WebDriver driver) {
        super(driver);
    }

//    public AllOpenPositionPage  clickAllQAJobs(){
//        click(allQAJobsButtonLocator);
//        return  new AllOpenPositionPage();
//    }
}
