package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    @FindBy(xpath = "//span[@class='_1z5n7CN']")
    private WebElement cartIcon;

    @FindBy(xpath = "//ul[@class='bag-items']")
    private WebElement cartItem;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCartItemVisible() {
        return cartItem.isDisplayed();
    }

    public WebElement getCartItem() {
        return cartItem;
    }

    public String getCartIconTest() {
        return cartIcon.getText();
    }
}
