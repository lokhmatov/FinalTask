package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//a[@icontype= 'bagUnfilled']")
    private WebElement cart;

    @FindBy(xpath = "//a[@icontype= 'heartUnfilled']")
    private WebElement wishlist;

    @FindBy(xpath = "//button[@class= '_6iPIuvw _2SSHFPv']")
    private WebElement myAaccountButton;

    @FindBy(xpath = "//input[@type= 'search']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@class='kH5PAAC']")
    private WebElement searchButton;

    @FindBy(xpath = "//a[@id= 'men-floor']")
    private WebElement menButton;

    @FindBy(xpath = "//a[@id= 'women-floor']")
    private WebElement womenButton;

    @FindBy(xpath = "//ul[@class = '_1sqB8tC']//button[@class= 'w9hgW1d _19PGtzt']")
    private WebElement countrySelectorButton;

    @FindBy(xpath = "//a[@data-testid='signup-link']")
    private WebElement signUpButton;

    @FindBy(xpath = "//a[@data-testid='signin-link']")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@class='_3hSCfS2']//span[@class='tiqiyps']")
    private WebElement myAccountPopUpTitle;

    @FindBy(xpath = "//button[@data-testid='signout-link']")
    private WebElement signOutButton;

    @FindBy(xpath = "//a[@data-testid='marketplace']")
    private WebElement marketplaceButton;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public boolean isCartVisible() {
        return cart.isDisplayed();
    }

    public boolean isWishListVisible() {
        return wishlist.isDisplayed();
    }

    public boolean isMyAaccountButtonVisible() {
        return myAaccountButton.isDisplayed();
    }

    public boolean isSearchFieldVisible() {
        return searchField.isDisplayed();
    }

    public boolean isCountrySelectorButtonVisible() {
        return countrySelectorButton.isDisplayed();
    }

    public boolean isMenButtonVisible() {
        return menButton.isDisplayed();
    }

    public boolean isWomenButtonVisible() {
        return womenButton.isDisplayed();
    }

    public void clickMenButton() {
        menButton.click();
    }

    public void clickWomenButton() {
        womenButton.click();
    }

    public void clickMyAccountButton() {
        myAaccountButton.click();
    }

    public void clickSignUpButton() {
        signUpButton.click();
    }

    public WebElement getSignUpButton() {
        return signUpButton;
    }

    public void enterTextToSearchField(final String searchText) {
        searchField.clear();
        searchField.sendKeys(searchText, Keys.ENTER);
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public WebElement getMyAccountButton() {
        return myAaccountButton;
    }

    public WebElement getSignOutButton() {
        return signOutButton;
    }

    public boolean isSignOutBittonVisible() {
        return signOutButton.isDisplayed();
    }

    public boolean isMarketplaceButtonVisible() {
        return marketplaceButton.isDisplayed();
    }

    public void clickMarketplaceButton() {
        marketplaceButton.click();
    }
}
