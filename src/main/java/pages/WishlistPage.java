package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WishlistPage extends BasePage{

    @FindBy(xpath = "//div[@class='productTile_KcKf2']")
    private List<WebElement> productCards;

    @FindBy(xpath = "//div[@class='productTile_KcKf2']")
    private WebElement product;

    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    public int getProductCardsAmmount() {
        return productCards.size();
    }

    public WebElement getProduct() {
        return product;
    }

}
