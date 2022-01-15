package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage{

    @FindBy(xpath = "//input[@id='signin']")
    private WebElement signInButton;

    @FindBy(xpath = "//input[@class='qa-email-textbox']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@class='qa-password-textbox']")
    private WebElement passwordInput;

    @FindBy(xpath = "//span[@class='qa-email-validation field-validation-error']")
    private WebElement emailError;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public boolean isEmailInputVisible() {
        return emailInput.isDisplayed();
    }

    public boolean isPasswordInputVisible() {
        return passwordInput.isDisplayed();
    }

    public boolean isEmailErrorVisible() {
        return emailError.isDisplayed();
    }

    public WebElement getSignInButton() {
        return signInButton;
    }

    public void fillInEmailField(final String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void fillInPasswordField(final String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }



}
