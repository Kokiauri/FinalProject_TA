package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    private By signupLink = By.xpath("//a[contains(text(),'Signup')]");
    private By signupNameField = By.xpath("//input[@data-qa='signup-name']");
    private By signupEmailField = By.xpath("//input[@data-qa='signup-email']");
    private By signupButton = By.xpath("//button[@data-qa='signup-button']");
    private By loginHeader = By.xpath("//h2[contains(text(), 'Login to your account')]");
    private By loginEmail = By.xpath("//input[@data-qa='login-email']");
    private By loginPassword = By.xpath("//input[@data-qa='login-password']");
    private By loginButton = By.xpath("//button[@data-qa='login-button']");

    private By genderMale = By.id("id_gender1");
    private By genderFemale = By.id("id_gender2");

    private By accountPassword = By.id("password");

    private By dayDropdown = By.id("days");
    private By monthDropdown = By.id("months");
    private By yearDropdown = By.id("years");

    private By newsletterCheckbox = By.id("newsletter");

    private By firstNameField = By.id("first_name");
    private By lastNameField = By.id("last_name");
    private By companyField = By.id("company");

    private By address1Field = By.id("address1");
    private By address2Field = By.id("address2");

    private By countryDropdown = By.id("country");

    private By stateField = By.id("state");
    private By cityField = By.id("city");
    private By zipCodeField = By.id("zipcode");
    private By mobileNumberField = By.id("mobile_number");
    private By homeSlider = By.id("slider");
    private By logoutBtn = By.xpath("//a[@href='/logout']");
    private By accountCreated = By.xpath("//b[contains(text(), 'Account')]");
    private By wrongLoginText = By.xpath("//p[contains(text(), 'password is incorrect')]");

    private By loggedInText =
            By.xpath("//a[contains(text(),'Logged in as')]");

    private By deleteAccount =
            By.xpath("//a[contains(text(),'Delete Account')]");

    private By createAccountButton =
            By.xpath("//button[@data-qa='create-account']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Check if account created text is visible")
    public boolean isAccountCreated() {
        return !driver.findElements(accountCreated).isEmpty();
    }



    @Step("Click on Signup / Login link")
    public void clickSignupLink() {
        click(signupLink);
    }

    @Step("Enter signup name: {name}")
    public void enterSignupName(String name) {
        type(signupNameField, name);
    }

    @Step("Enter signup email: {email}")
    public void enterSignupEmail(String email) {
        type(signupEmailField, email);
    }

    @Step("Click Signup button")
    public void clickSignupButton() {
        click(signupButton);
    }

    @Step("Login with email: {email} and password: {password}")
    public void login(String email, String password) {
        type(loginEmail, email);
        type(loginPassword, password);
        click(loginButton);
    }

    @Step("Select Male gender")
    public void selectMale() {
        click(genderMale);
    }

    @Step("Select Female gender")
    public void selectFemale() {
        click(genderFemale);
    }

    @Step("Enter account password")
    public void enterAccountPassword(String password) {
        type(accountPassword, password);
    }

    @Step("Select day: {day}")
    public void selectDay(String day) {
        Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(dayDropdown)));
        select.selectByVisibleText(day);
    }

    @Step("Select month: {month}")
    public void selectMonth(String month) {
        Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(monthDropdown)));
        select.selectByVisibleText(month);
    }

    @Step("Select year: {year}")
    public void selectYear(String year) {
        Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(yearDropdown)));
        select.selectByVisibleText(year);
    }

    @Step("Subscribe to newsletter")
    public void subscribeToNewsletter() {
        if (!driver.findElement(newsletterCheckbox).isSelected()) {
            driver.findElement(newsletterCheckbox).click();
        }
    }

    @Step("Enter first name: {firstName}")
    public void enterFirstName(String firstName) {
        type(firstNameField, firstName);
    }

    @Step("Enter last name: {lastName}")
    public void enterLastName(String lastName) {
        type(lastNameField, lastName);
    }

    @Step("Enter company: {company}")
    public void enterCompany(String company) {
        type(companyField, company);
    }

    @Step("Enter address 1: {address}")
    public void enterAddress1(String address) {
        type(address1Field, address);
    }

    @Step("Enter address 2: {address}")
    public void enterAddress2(String address) {
        type(address2Field, address);
    }

    @Step("Select country: {country}")
    public void selectCountry(String country) {
        Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(countryDropdown)));
        select.selectByVisibleText(country);
    }

    @Step("Enter state: {state}")
    public void enterState(String state) {
        type(stateField, state);
    }

    @Step("Enter city: {city}")
    public void enterCity(String city) {
        type(cityField, city);
    }

    @Step("Enter zip code: {zip}")
    public void enterZipCode(String zip) {
        type(zipCodeField, zip);
    }

    @Step("Enter mobile number: {mobile}")
    public void enterMobileNumber(String mobile) {
        type(mobileNumberField, mobile);
    }

    @Step("Click Create Account button")
    public void clickCreateAccount() {
        click(createAccountButton);
    }

    @Step("Check if Login page is visible")
    public boolean isLoginPageVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loginHeader))
                .isDisplayed();
    }

    @Step("Check if 'Logged in as' text is visible")
    public boolean isLoggedInTextVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loggedInText))
                .isDisplayed();
    }

    @Step("Click Delete Account button")
    public void clickDeleteAccount() {
        click(deleteAccount);
    }

    @Step("Check if Logout button is visible")
    public boolean isLogoutVisible() {
        return !driver.findElements(logoutBtn).isEmpty();
    }

    @Step("Logout")
    public void logOut() {
        click(logoutBtn);
    }

    @Step("Check if incorrect credentials error is visible")
    public boolean areCredentialsIncorrect() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(wrongLoginText)).isDisplayed();
    }
}
