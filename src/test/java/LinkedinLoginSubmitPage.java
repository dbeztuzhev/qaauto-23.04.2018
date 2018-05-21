import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinLoginSubmitPage {

    private WebElement errorMessage;
    private WebElement emailField;

    public LinkedinLoginSubmitPage(WebDriver webDriver) {
        super(webDriver);
        initElements();
    }

    public void initElements() {
        emailField = webDriver.findElement(By.id("session_key-login"));
        errorMessage = webDriver.findElement(By.xpath("//div[@role='alert']"));
    }
        public String getErrorMessageText () {
            return errorMessage.getText();
        }

        public boolean isPageLoaded() {
        return errorMessage.isDisplayed();
        }

        public String getCurrentUrl () {
            return webDriver.getCurrentUrl();
        }

        public String getCurrentTitle () {
            return webDriver.getTitle();
        }
    }




