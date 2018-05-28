import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinLoginPage extends LinkedinBasePage {

    @FindBy(id = "login-email")
    private WebElement emailField;

    @FindBy(id = "login-password")
    private WebElement passwordField;

    @FindBy(id = "login-submit")
    private WebElement signinButton;

    public LinkedinLoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded() {
        return signinButton.isDisplayed();
    }

    /*public LinkedinHomePage loginSuccess(String email, String password) {
        loginTry(email, password);
        //return PageFactory.initElements(webDriver, LinkedinHomePage.class);
        return new LinkedinHomePage(webDriver);
    }

    public LinkedinLoginSubmitPage loginError(String email, String password) {
        loginTry(email, password);
        return PageFactory.initElements(webDriver, LinkedinLoginSubmitPage.class);
    }

    public void loginTry(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signinButton.click();
    }*/

    public <T> T login(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signinButton.click();
        if (getCurrentTitle().contains("/feed")) {
            return (T) new LinkedinHomePage(webDriver);
        }
        if (getCurrentTitle().contains("/login-submit")) {
            return (T) new LinkedinLoginSubmitPage(webDriver);
        } else {
            return (T) this;
        }

    }
    }



