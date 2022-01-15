package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

    @FindBy(xpath = "//span[@class='WkTCjySeTZVCmsExD5tWL']")
    private WebElement myAccountTitle;

    @FindBy(xpath = "//a[@class='DrvAPUms9TXGB7LgSTgFW _1r0vUu7pnBDIUGnfQzhxky']")
    private WebElement myAccountOverview;


    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean isMyAccountOverviewVisible() {
        return myAccountOverview.isDisplayed();
    }

    public WebElement getMyAccountOverview() {
        return myAccountOverview;
    }

}
