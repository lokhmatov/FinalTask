package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public RegisterPage getRegistrationPage() {
        return new RegisterPage(driver);
    }

    public MyAccountPage getMyAccountPage() {
        return new MyAccountPage(driver);
    }

    public SearchResultPage getSearchResultPage() {
        return new SearchResultPage(driver);
    }

    public WishlistPage getWishlistPage() {
        return new WishlistPage(driver);
    }

    public ProductPage getProductPage() {
        return new ProductPage(driver);
    }

    public CartPage getCartPage() {
        return new CartPage(driver);
    }

    public SignInPage getSignInPage() {
        return new SignInPage(driver);
    }

    public MarketplacePage getMarketplacePage() {
        return new MarketplacePage(driver);
    }
}
