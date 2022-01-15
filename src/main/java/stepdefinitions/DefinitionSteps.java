package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 20;

    WebDriver driver;
    PageFactoryManager pageFactoryManager;
    HomePage homePage;
    RegisterPage registerPage;
    MyAccountPage myAccountPage;
    SearchResultPage searchResultPage;
    WishlistPage wishlistPage;
    ProductPage productPage;
    CartPage cartPage;
    SignInPage signInPage;
    MarketplacePage marketplacePage;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User checks cart visibility")
    public void checkCartVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.isCartVisible();
    }

    @And("User checks wishlist visibility")
    public void checkWishlistVisibility() {
        homePage.isWishListVisible();
    }

    @And("User checks my Account visibility")
    public void checkMyAccountVisibility() {
        homePage.isMyAaccountButtonVisible();
    }

    @And("User checks search field visibility")
    public void checksSearchFieldVisibility() {
        homePage.isSearchFieldVisible();
    }

    @And("User checks country selector button visibility")
    public void checksCountrySelectorButtonVisibility() {
        homePage.isCountrySelectorButtonVisible();
    }

    @And("User checks men button visibility")
    public void checksMenButtonVisibility() {
        homePage.isMenButtonVisible();
    }

    @And("User checks women button visibility")
    public void checksWomenButtonVisibility() {
        homePage.isWomenButtonVisible();
    }

    @When("User clicks {string} button button")
    public void clicksMenOrWomenButtonButton(final String menOrWomen) {
        if (menOrWomen.equals("women")) {
            homePage.clickWomenButton();
        } else {
            homePage.clickMenButton();
        }
    }

    @Then("User checks that url contains {string}")
    public void checksThatUrlContainsMenOrWomen(final String menOrWomen) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        assertTrue(driver.getCurrentUrl().contains(menOrWomen));
    }

    @And("User clicks my Account button")
    public void clickMyAccountButton() {
        homePage.clickMyAccountButton();
    }

    @And("User clicks SignUp button")
    public void clickSignUpButton() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getSignUpButton());
        homePage.clickSignUpButton();
    }

    @And("User checks email field visibility")
    public void checkEmailFieldVisibility() {
        registerPage = pageFactoryManager.getRegistrationPage();
        registerPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, registerPage.getEmailInput());
        registerPage.isEmailInputVisible();
    }

    @And("User enters email that contains {string} and {string}")
    public void fillInEmailField(String firstName, String lastName) {
        String mail = firstName + "." + lastName + "+" + RandomStringUtils.randomNumeric(4) + "@gmail.com";
        registerPage.fillInEmailField(mail);
    }

    @And("User enters {string}")
    public void enterIncorrectEmail(String incorrectEmail) {
        registerPage = pageFactoryManager.getRegistrationPage();
        registerPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, registerPage.getEmailInput());
        registerPage.fillInEmailField(incorrectEmail);
    }

    @And("User checks first name field visibility")
    public void checkFirstNameFieldVisibility() {
        registerPage.isFirstNameInputVisible();
    }

    @And("User enters {string} in first name field")
    public void enterFirstNameInFirstNameField(String firstName) {
        registerPage.fillInFirstNameField(firstName);
    }


    @And("User checks last name field visibility")
    public void checksLastNameFieldVisibility() {
        registerPage.isLastNameInputVisible();
    }

    @And("User enters {string} in last name field")
    public void enterLastNameInLastNameField(String lastName) {
        registerPage.fillInLastNameField(lastName);
    }


    @And("User checks password field visibility")
    public void checkPasswordFieldVisibility() {
        registerPage.isPasswordInputVisible();
    }

    @And("User enters {string} in password field")
    public void enterPasswordInPasswordField(String password) {
        registerPage.fillInPasswordField(password);
    }


    @And("User checks birthDate field visibility")
    public void checkBirthDateFieldVisibility() {
        registerPage.isBirthdayVisible();
        registerPage.isBirthmonthVisible();
        registerPage.isBirthyearVisible();
    }

    @And("User selects {string} in birthday field")
    public void selectBirthdayInBirthdayField(String birthday) {
        registerPage.selectBirthday(birthday);
    }

    @And("User selects {string} in birthmonth field")
    public void selectBirthmonthInBirthmonthField(String birthmonth) {
        registerPage.selectBirthmonth(birthmonth);
    }

    @And("User selects {string} in birthyear field")
    public void selectBirthyearInBirthyearField(String birthyear) {
        registerPage.selectBirthyear(birthyear);
    }

    @When("User clicks on register button")
    public void clicksOnRegisterButton() {
        registerPage.clickRegisterButton();
    }

    @Then("User checks myAccountOverview visibility")
    public void checkMyAccountOverviewVisibility() {
            myAccountPage = pageFactoryManager.getMyAccountPage();
            myAccountPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, myAccountPage.getMyAccountOverview());
            assertTrue(myAccountPage.isMyAccountOverviewVisible());
    }

    @Then("User checks email and password errors visibility")
    public void checkEmailAndPasswordErrorsVisibility() {
        assertTrue(registerPage.isEmailErrorVisible());
        assertTrue(registerPage.isPasswordErrorVisible());
    }

    @When("User makes search by {string}")
    public void enterKeyword(final String keyword) {
        homePage.enterTextToSearchField(keyword);
    }

    @And("User clicks wishlist button")
    public void clicksWishlistButton() {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultPage.clickWishListIcon();
    }

    @And("User opens wishlist page")
    public void openWishlistPage() {
        searchResultPage.clickWishlistButton();
    }

    @Then("User checks that wishlist contains 1 product")
    public void checksThatWishlistContainsProduct() {
        wishlistPage = pageFactoryManager.getWishlistPage();
        wishlistPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        wishlistPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, wishlistPage.getProduct());
        assertEquals(1, wishlistPage.getProductCardsAmmount());
    }


    @And("User clicks on first product")
    public void clickOnFirstProduct() {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultPage.clickProduct();
    }

    @And("User clicks Add to Bag button")
    public void clickAddToBagButton() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getAddToCartButton());
        productPage.clickAddToCartButton();

    }

    @And("User checks View Bag button visibility")
    public void checkViewBagButtonVisibility() {
        productPage.isViewBagButtonVisible();
    }

    @And("User checks Checkout button visibility")
    public void checkCheckoutButtonVisibility() {
        productPage.isCheckoutButtonVisible();
    }

    @And("User clicks Cart button")
    public void clickCartButton() {
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getCartButton());
        productPage.clickCartButton();
    }


    @And("User clicks View Bag button")
    public void clickViewBagButton() {
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getViewBagButton());
        productPage.clickViewButton();
    }

    @Then("User checks that cart contains cart item")
    public void checkCartContainsKeyword() {
        cartPage = pageFactoryManager.getCartPage();
        cartPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, cartPage.getCartItem());
        assertTrue(cartPage.isCartItemVisible());
    }

    @And("User checks that cart icon contains 1")
    public void checkCartIconContains() {
        assertEquals("1", cartPage.getCartIconTest());
    }

    @And("User checks product title visibility")
    public void checkProductTitleVisibility() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getAddToCartButton());
        productPage.isProductTitleVisible();
    }

    @And("User checks image visibility")
    public void checkImageVisibility() {
        productPage.isProductImageVisible();
    }

    @And("User checks price visibility")
    public void checkPriceVisibility() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getProductPrice());
        productPage.isProductPriceVisible();
    }


    @And("User checks Add to Bag button visibility")
    public void checkAddToBagButtonVisibility() {
        productPage.isAddToCartVisible();
    }


    @And("User checks wishlist button visibility")
    public void checkWishlistButtonVisibility() {
        productPage.isWishlistButtonVisible();
    }


    @And("User clicks Show More button")
    public void clickShowMoreButton() {
        productPage.clickShowButton();
    }

    @And("User checks product details visibility")
    public void checkProductDetailsVisibility() {
        productPage.isProductDetailsVisible();
    }


    @And("User clicks reviews button")
    public void clickReviewsButton() {
        productPage.clickReviewsButton();
    }

    @And("User checks reviews window visibility")
    public void checkReviewsWindowVisibility() {
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getCloseReviewsButton());
        productPage.isReviewsWindowVisible();
    }

    @And("User clicks close reviews button")
    public void clickCloseReviewsButton() {
        productPage.clickCloseReviewsButton();
    }

    @Then("User checks that cart popup header contains 1 item")
    public void checkCartPopupHeader() {
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getCartPopupHeader());
        assertTrue(productPage.getCartPopupHeaderText().contains("1 item"));
    }

    @And("User clicks SignIn button")
    public void clickSignInButton() {
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getSignUpButton());
        homePage.clickSignInButton();
    }

    @And("User checks email input visibility")
    public void checkEmailInputVisibility() {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, signInPage.getSignInButton());
        signInPage.isEmailInputVisible();
    }

    @And("User fills in email input with {string}")
    public void fillInEmailInput(final String incorrectEmail) {
        signInPage.fillInEmailField(incorrectEmail);
    }

    @And("User checks password input visibility")
    public void checksPasswordInputVisibility() {
        signInPage.isPasswordInputVisible();
    }

    @And("User fills in password input with{string}")
    public void fillsInPasswordInput(final String incorrectPassword) {
        signInPage.fillInPasswordField(incorrectPassword);
    }

    @When("User clicks on sign in button")
    public void clickOnSignInButton() {
        signInPage.clickSignInButton();
    }

    @Then("User checks email error visibility")
    public void checkEmailErrorVisibility() {
        assertTrue(signInPage.isEmailErrorVisible());
    }

    @Then("User checks myAccount popup contains sign out button")
    public void checkMyAccountPopupContainsSignOutButton() {
        homePage = pageFactoryManager.getHomePage();
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getMyAccountButton());
        homePage.clickMyAccountButton();
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getSignOutButton());
        assertTrue(homePage.isSignOutBittonVisible());
    }

    @And("User clicks preferences button")
    public void clickPreferencesButton() {
        productPage.clickPreferencesButton();
    }


    @And("User checks country selector visibility")
    public void checkCountrySelectorVisibility() {
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getUpdatePreferencessButton());
        productPage.isCountrySelectorVisible();
    }

    @And("User checks currency selector visibility")
    public void checkCurrencySelectorVisibility() {
        productPage.isCurrencySelectorVisible();
    }

    @When("User selects {string}")
    public void selectCurrency(final String currency) {
        productPage.selectCurrency(currency);
    }

    @And("clicks update preferences button")
    public void clickUpdatePreferencesButton() {
        productPage.clickUpdatePreferencessButton();
    }


    @Then("User checks that price contains {string}")
    public void checkPriceContainsCurrencySymbol(final String currencySymbol) {
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getProductPrice());
        assertTrue(productPage.getPriceText().contains(currencySymbol));
    }

    @And("User checks market place button visibility")
    public void checkMarketPlaceButtonVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.isMarketplaceButtonVisible();
    }

    @When("User clicks marketplace button")
    public void clickMarketplaceButton() {
        homePage.clickMarketplaceButton();
    }


    @Then("User checks that url contains marketplace")
    public void checkThatUrlContainsMarketplace() {
        marketplacePage = pageFactoryManager.getMarketplacePage();
        marketplacePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, marketplacePage.getCategories());
        assertTrue(driver.getCurrentUrl().contains("marketplace"));
    }

    @And("User checks account icon visibility")
    public void checkAccountIconVisibility() {
        marketplacePage.isAccountIconVisible();
    }

    @And("User checks wishlist icon visibility")
    public void checkWishlistIconVisibility() {
        marketplacePage.isWishlistIconVisible();
    }

    @And("User checks cart icon visibility")
    public void checkCartIconVisibility() {
        marketplacePage.isCartIconVisible();
    }

    @And("User checks search box visibility")
    public void checkSearchBoxVisibility() {
        marketplacePage.isSearchBoxVisible();
    }


    @And("User checks settings button visibility")
    public void checkSettingsButtonVisibility() {
        marketplacePage.isSettingsButtonVisible();
    }

    @And("User checks site selections visibility")
    public void checkSiteSelectionsVisibility() {
        marketplacePage.isSiteSelectionsVisible();
    }

    @And("User checks categories visibility")
    public void checkCategoriesVisibility() {
        marketplacePage.isCategoriesVisible();
    }

    @And("User checks search results amount is {int}")
    public void checksSearchResultsAmount(int searchResultsAmount) {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultPage.getLoadMoreButton());
        assertTrue(searchResultPage.getSearchResultsAmount(searchResultsAmount));
    }

    @When("User clicks Load More")
    public void clickLoadMore() {
        searchResultPage.clickLoadMoreButton();
    }

    @Then("User checks loaded search results amount is {int}")
    public void checkLoadMoreAmount(int loadMoreAmount) {
        searchResultPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultPage.getLoadMoreButton());
        assertTrue(searchResultPage.getSearchResultsAmount(loadMoreAmount));
    }
}
