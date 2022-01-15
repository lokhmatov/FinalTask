package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Locale;

public class ProductPage extends BasePage{

    @FindBy(xpath = "//button[@id='product-add-button']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//a[@data-test-id='bag-link']")
    private WebElement viewBagButton;

    @FindBy(xpath = "//a[@data-test-id='checkout-link']")
    private WebElement checkoutButton;

    @FindBy(xpath = "//button[@data-testid='miniBagIcon']")
    private WebElement cartButton;

    @FindBy(xpath = "//div[@class='image-container zoomable']//img[@class='gallery-image']")
    private WebElement productImage;

    @FindBy(xpath = "//div[@id='aside-content']//h1")
    private WebElement productTitle;

    @FindBy(xpath = "//span[@data-id='current-price']")
    private WebElement productPrice;

    @FindBy(xpath = "//button[@class='i5hAj _5AuCN']")
    private WebElement wishlist;

    @FindBy(xpath = "//a[@class='show']")
    private WebElement showButton;

    @FindBy(xpath = "//div[@class='product-details']")
    private WebElement productDetails;

    @FindBy(xpath = "//button[@data-test-id='reviewsViewAll']")
    private WebElement reviewsButton;

    @FindBy(xpath = "//div[@id='sideModal7094']")
    private WebElement reviewsWindow;

    @FindBy(xpath = "//button[@data-test-id='closeModal']")
    private WebElement closeReviewsButton;

    @FindBy(xpath = "//div[@class='_2Z4oR']")
    private WebElement reviewsContainer;

    @FindBy(xpath = "//div[@data-test-id='miniBagHeader']//span[@data-test-id='miniBagItemCount']")
    private WebElement cartPopupHeader;

    @FindBy(xpath = "//ul[@class = '_1sqB8tC']//button[@data-testid= 'country-selector-btn']")
    private WebElement preferencesButton;

    @FindBy(xpath = "//select[@id='country']")
    private WebElement countrySelector;

    @FindBy(xpath = "//select[@id='currency']")
    private WebElement currencySelector;

    @FindBy(xpath = "//button[@data-testid='save-country-button']")
    private WebElement updatePreferencessButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean isViewBagButtonVisible() {
        return viewBagButton.isDisplayed();
    }

    public boolean isCheckoutButtonVisible() {
        return checkoutButton.isDisplayed();
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public void clickCartButton() {
        cartButton.click();
    }

    public void clickViewButton() {
        viewBagButton.click();
    }

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    public boolean isAddToCartVisible() {
        return addToCartButton.isDisplayed();
    }

    public WebElement getCartButton() {
        return cartButton;
    }

    public boolean isProductImageVisible() {
        return productImage.isDisplayed();
    }

    public boolean isProductTitleVisible() {
        return productTitle.isDisplayed();
    }

    public boolean isProductPriceVisible() {
        return productPrice.isDisplayed();
    }

    public boolean isWishlistButtonVisible() {
        return wishlist.isDisplayed();
    }

    public void clickShowButton() {
        showButton.click();
    }

    public boolean isProductDetailsVisible() {
        return productDetails.isDisplayed();
    }

    public void clickReviewsButton() {
        reviewsButton.click();
    }

    public boolean isReviewsWindowVisible() {
        return reviewsContainer.isDisplayed();
    }

    public void clickCloseReviewsButton() {
        closeReviewsButton.click();
    }

    public WebElement getCloseReviewsButton() {
        return closeReviewsButton;
    }

    public String getCartPopupHeaderText() {
        return cartPopupHeader.getText();
    }

    public WebElement getCartPopupHeader() {
        return cartPopupHeader;
    }

    public void clickPreferencesButton() {
        preferencesButton.click();
    }

    public boolean isCountrySelectorVisible() {
        return countrySelector.isDisplayed();
    }

    public boolean isCurrencySelectorVisible() {
        return currencySelector.isDisplayed();
    }

    public void clickUpdatePreferencessButton() {
        updatePreferencessButton.click();
    }

    public WebElement getProductPrice() {
        return productPrice;
    }

    public WebElement getUpdatePreferencessButton() {
        return updatePreferencessButton;
    }

    public void selectCurrency(final String currency) {
        Select select = new Select(currencySelector);
        select.selectByVisibleText(currency);
    }

    public String getPriceText() {
        return productPrice.getText();
    }

    public WebElement getViewBagButton() {
        return viewBagButton;
    }
}
