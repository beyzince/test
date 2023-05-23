package page;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LeverAppFormPage extends  BasePage{


    public LeverAppFormPage(WebDriver driver) {
        super(driver);
    }

    public LeverAppFormPage checkIsOpenedLeverApplicationPage() {
        Assert.assertEquals("Insider open positions | Insider", getPageTitle(), "Not on Lever App page!");
        return this;
    }
}
