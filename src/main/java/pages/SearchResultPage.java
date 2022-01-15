package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage{

    @FindBy(xpath = "//button[@class='_2HTnAzH M3dcC1z']")
    private List<WebElement> wishListIcons;

    @FindBy(xpath = "//a[@class='_3TqU78D']")
    private List<WebElement> products;

    @FindBy(xpath = "//a[@icontype= 'heartUnfilled']")
    private WebElement wishlist;

    @FindBy(xpath = "//a[@data-auto-id='loadMoreProducts']")
    private WebElement loadMoreButton;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public void clickWishListIcon() {
        wishListIcons.get(0).click();
    }

    public void clickWishlistButton() {
        wishlist.click();
    }

    public void clickProduct() {
        products.get(0).click();
    }

    public WebElement getLoadMoreButton() {
        return loadMoreButton;
    }

    public void clickLoadMoreButton() {
        loadMoreButton.click();
    }

    public boolean getSearchResultsAmount(int searchResultsAmount) {
       return products.size() == searchResultsAmount;
    }
}
