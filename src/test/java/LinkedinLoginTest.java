import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LinkedinLoginTest {

    @Test
    public void successfulLoginTest() {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com/");

        String actualLoginPageTitle = webDriver.getTitle();

        /*Assert.assertEquals("a", "b", "Probably 'a' is not equal to 'b'");
*/
        Assert.assertEquals(webDriver.getTitle(),
                "LinkedIn: Log In or Sign Up",
                "Login page Title is wrong");


        WebElement emailField = webDriver.findElement(By.id("login-email"));
        WebElement passwordField = webDriver.findElement(By.id("login-password"));
        WebElement signInButton = webDriver.findElement(By.id("login-submit"));

        Assert.assertTrue(signInButton.isDisplayed(), "Sign In button is not Displayed");

        emailField.sendKeys("db.hideez@gmail.com");
        passwordField.sendKeys("201101");
        signInButton.click();

        Assert.assertEquals(webDriver.getCurrentUrl(),
                "https://www.linkedin.com/feed/",
                "Home page url is wrong.");

        Assert.assertEquals(webDriver.getTitle(),
                "LinkedIn",
                "Home page url is wrong.");
        //или

        String actualHomePageTitle = webDriver.getTitle();

        Assert.assertNotEquals(actualLoginPageTitle,actualHomePageTitle,
                "Page title did not change after Sign In");

        Assert.assertTrue(webDriver.getTitle().contains("LinkedIn"),
                 "Home page url is wrong.");



        /*WebElement emailField = webDriver.findElement(By.xpath("//*[@id=\"login-email\"]"));
        emailField.sendKeys("db.hideez@gmail.com");

        WebElement passwordField = ((FirefoxDriver) webDriver).findElementByXPath("//*[@id=\"login-password\"]");
        passwordField.sendKeys("201101");

        WebElement signInButton = webDriver.findElement(By.xpath("//*[@id=\"login-submit\"]"));
                                                        // (By.id("login-submit")
        signInButton.click();

        String currentUrl = webDriver.getCurrentUrl();
        Assert.assertEquals( currentUrl , "https://www.linkedin.com/feed/");

        Assert.assertEquals(webDriver.getTitle(), "LinkedIn", "Home page Title is wrong");

        *//*String actualString = webDriver.findElement(By.xpath("//*[@id=\"ember4072\"]")).getText();
        Assert.assertTrue(actualString.contains("Добро пожаловать, Den!"));*/

        webDriver.close();
    }
}
