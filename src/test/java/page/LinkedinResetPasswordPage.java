package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

abstract class LinkedinResetPasswordPage extends LinkedinBasePage

{
    @FindBy(xpath = "//*[@class='content__header']")
    private WebElement message;
    @FindBy(id = "username")
    private WebElement emailField;
    @FindBy(id = "reset-password-submit-button")
    private WebElement SubmitButton;


    public boolean MessageDisplayed() {
        return message.isDisplayed();
    }
    public boolean EmailFieldDisplayed() {
        return emailField.isDisplayed();
    }
    public boolean SubmitButtonDisplayed() {
        return SubmitButton.isDisplayed();
    }
    public void clickOnSubmitButton() {
        SubmitButton.click();
    }
    public String getMessage() {
        return message.getText();
    }
    public LinkedinResetPasswordPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }
}
