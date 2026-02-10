package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactUsPage extends BasePage{
    private By contactUsLink = By.xpath("//a[@href='/contact_us']");
    private By contactUsForm = By.id("contact-us-form");
    private By getInTouchHeader = By.xpath("//h2[contains(text(), 'Get In Touch')]");
    private By nameField = By.xpath("//input[@name='name']");
    private By emailField = By.xpath("//input[@name='email']");
    private By subjectField = By.xpath("//input[@name='subject']");
    private By messageField = By.xpath("//*[@id='message']");
    private By uploadFile = By.xpath("//input[@name='upload_file']");
    private By submitBtn = By.xpath("//input[@type='submit']");
    private By successMsg = By.xpath("//div[contains(@class, 'status alert alert-success')]");
    private By homeBtn = By.xpath("//span[contains(text(), 'Home')]");

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on 'Contact Us' button")
    public void clickContactUs() {
        click(contactUsLink);
    }

    @Step("Check if 'GET IN TOUCH' is visible")
    public boolean isGetInTouchVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(getInTouchHeader)).isDisplayed();
    }

    @Step("Fill contact us form: name={name}, email={email}, subject={subject}, message={message}")
    public void fillContactForm(String name, String email, String subject, String message) {
        type(nameField, name);
        type(emailField, email);
        type(subjectField, subject);
        type(messageField, message);
    }

    @Step("Upload file: {filePath}")
    public void uploadFile(String filePath) {
        driver.findElement(uploadFile).sendKeys(filePath);
    }

    @Step("Click 'Submit' button")
    public void clickSubmit() {
        click(submitBtn);
    }

    @Step("Click OK on the alert")
    public void handleAlert() {
        driver.switchTo().alert().accept();
    }

    @Step("Verify success message is visible")
    public boolean isSuccessMessageVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg)).isDisplayed();
    }

    @Step("Click 'Home' button")
    public void clickHome() {
        click(homeBtn);
    }

    @Step("Navigate to Contact Us Page")
    public void navigateToContactUsPage() {
        driver.get(baseUrl + "/contact_us");
    }

    @Step("Check if Contact Us form page is visible")
    public boolean isContactUsPageVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(contactUsForm))
                .isDisplayed();
    }
}
