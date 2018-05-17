import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

class LinkedinLoginPage {
    private WebDriver webDriver;

    private WebElement EmailField = webDriver.findElement(By.id("login-email"));
    private WebElement PasswordField = webDriver.findElement(By.id("login-password"));
    private WebElement SignInButton = webDriver.findElement(By.id("login-submit"));

    public Boolean login(String email, String password) {
        EmailField.sendKeys(email);
        PasswordField.sendKeys(password);

        Boolean SignInButtonDisplayed = null;
        {
            SignInButton.click();
        }

        /*Boolean signInButton;
        {
            {
                boolean resut = false;
                Boolean result = signInButton();
                return result;
            }
        }
    }

    private Boolean signInButton() {

        return null;
    }*/

        return SignInButtonDisplayed;
    }
}

        