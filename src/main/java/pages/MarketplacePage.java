package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MarketplacePage extends BasePage{

    @FindBy(xpath = "//span[contains(@class, 'accountIcon')]")
    private WebElement accountIcon;

    @FindBy(xpath = "//a[contains(@class, 'faveIcon')]")
    private WebElement wishlistIcon;

    @FindBy(xpath = "//a[contains(@class, 'basketIcon')]")
    private WebElement cartIcon;

    @FindBy(xpath = "//button[contains(@class, 'Searchbox')]")
    private WebElement searchBox;

    @FindBy(xpath = "//div[contains(@class, 'settingsBar')]//button[@id='settings']")
    private WebElement settingsButton;

    @FindBy(xpath = "//ul[contains(@class, 'TopBar_siteSections')]")
    private WebElement siteSelections;

    @FindBy(xpath = "//ol[contains(@class, 'topCategories')]")
    private WebElement categories;

    public MarketplacePage(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountIconVisible() {
        return accountIcon.isDisplayed();
    }

    public boolean isCartIconVisible() {
        return cartIcon.isDisplayed();
    }

    public boolean isWishlistIconVisible() {
        return wishlistIcon.isDisplayed();
    }

    public boolean isSearchBoxVisible() {
        return searchBox.isDisplayed();
    }

    public boolean isSettingsButtonVisible() {
        return settingsButton.isDisplayed();
    }

    public boolean isSiteSelectionsVisible() {
        return siteSelections.isDisplayed();
    }

    public boolean isCategoriesVisible() {
        return categories.isDisplayed();
    }

    public WebElement getCategories() {
        return categories;
    }

}
