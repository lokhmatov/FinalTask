package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends BasePage {

    @FindBy(xpath = "//input[@class='qa-email-textbox']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@class='qa-firstname-textbox']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@class='qa-lastname-textbox']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@class='qa-password-textbox']")
    private WebElement passwordInput;

    @FindBy(xpath = "//select[@class='qa-birthday-textbox']")
    private WebElement birthdayInput;

    @FindBy(xpath = "//select[@class='qa-birthmonth-textbox']")
    private WebElement birthmonthInput;

    @FindBy(xpath = "//select[@class='qa-birthyear-textbox']")
    private WebElement birthyearInput;

    @FindBy(xpath = "//input[@id='register']")
    private WebElement registerButton;

    @FindBy(xpath = "//span[@id='Email-error']")
    private WebElement emailError;

    @FindBy(xpath = "//span[@id='Password-error']")
    private WebElement passwordError;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public boolean isEmailInputVisible() {
        return emailInput.isDisplayed();
    }

    public boolean isFirstNameInputVisible() {
        return firstNameInput.isDisplayed();
    }

    public boolean isLastNameInputVisible() {
        return lastNameInput.isDisplayed();
    }

    public boolean isPasswordInputVisible() {
        return passwordInput.isDisplayed();
    }

    public boolean isBirthdayVisible() {
        return birthdayInput.isDisplayed();
    }

    public boolean isBirthmonthVisible() {
        return birthmonthInput.isDisplayed();
    }

    public boolean isBirthyearVisible() {
        return birthyearInput.isDisplayed();
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

    public void fillInEmailField(final String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void fillInFirstNameField(final String firstName) {
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
    }

    public void fillInLastNameField(final String lastName) {
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
    }

    public void fillInPasswordField(final String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void selectBirthday(final String birthday) {
        Select select = new Select(birthdayInput);
        select.selectByVisibleText(birthday);
    }

    public void selectBirthmonth(final String birthmonth) {
        Select select = new Select(birthmonthInput);
        select.selectByVisibleText(birthmonth);
    }

    public void selectBirthyear(final String birthyear) {
        Select select = new Select(birthyearInput);
        select.selectByVisibleText(birthyear);
    }

    public WebElement getEmailInput() {
        return emailInput;
    }

    public boolean isEmailErrorVisible() {
        return emailError.isDisplayed();
    }

    public boolean isPasswordErrorVisible() {
        return passwordError.isDisplayed();
    }



}
