import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;
import static org.testng.Assert.*;

public class LinkedinLoginTest {
    WebDriver webDriver;

    @BeforeMethod
    public void before() {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com/");

    }

    @Test
    public void successfulLoginTest(WebElement signInButton) {

        String actualLoginPageTitle = webDriver.getTitle();

        //*Assert.assertEquals("a", "b", "Probably 'a' is not equal to 'b'");

        assertEquals(webDriver.getTitle(),
                "LinkedIn: Log In or Sign Up",
                "Login page Title is wrong");

        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage();
        linkedinLoginPage.login("db.hideez#gmail.com", "201101");

        signInButton.click();

        LinkedinLoginPage.Assert.assertTrue(signInButton.isDisplayed(), "Sign In button is not Displayed");

        assertEquals(webDriver.getCurrentUrl(),
                "https://www.linkedin.com/feed/",
                "Home page url is wrong.");

        assertEquals(webDriver.getTitle(),
                "LinkedIn",
                "Home page url is wrong.");
        //или

        String actualHomePageTitle = webDriver.getTitle();

        assertNotEquals(actualLoginPageTitle, actualHomePageTitle,
                "Page title did not change after Sign In");

        assertTrue(webDriver.getTitle().contains("LinkedIn"),
                "Home page url is wrong.");


        WebElement emailField = webDriver.findElement(By.xpath("//*[@id=\"login-email\"]"));
        emailField.sendKeys("db.hideez@gmail.com");

        WebElement passwordField = ((FirefoxDriver) webDriver).findElementByXPath("//*[@id=\"login-password\"]");
        passwordField.sendKeys("201101");

        signInButton = webDriver.findElement(By.xpath("//*[@id=\"login-submit\"]"));
        // (By.id("login-submit")
        signInButton.click();

        String currentUrl = webDriver.getCurrentUrl();
        assertEquals(currentUrl, "https://www.linkedin.com/feed/");

        assertEquals(webDriver.getTitle(), "LinkedIn", "Home page Title is wrong");

        String actualString = webDriver.findElement(By.xpath("//*[@id=\"ember4072\"]")).getText();
        assertTrue(actualString.contains("Добро пожаловать, Den!"));

        webDriver.close();
    }



    @Test
    public void wrongEmailCorrectPasswordTest() {

        String actualLoginPageTitle = webDriver.getTitle();

        assertEquals(webDriver.getTitle(),
                "LinkedIn: Log In or Sign Up",
                "Login page Title is wrong");

        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage();
        linkedinLoginPage.login("db.hideez#gmail.com", "201101");

        WebElement signInButton = webDriver.findElement(By.id("login-submit"));
        signInButton.click();

        assertEquals(webDriver.getCurrentUrl(),
                "https://www.linkedin.com/uas/login-submit",
                "There were one or more errors in your submission. Please correct the marked fields below.");
        assertEquals("Please enter a valid email address.", "Please enter a valid email address.");
        webDriver.close();
    }

    @Test
    public void correctEmailWrongPasswordTest() {

        String actualLoginPageTitle = webDriver.getTitle();

        assertEquals(webDriver.getTitle(),
                "LinkedIn: Log In or Sign Up",
                "Login page Title is wrong");


        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage();
        linkedinLoginPage.login("db.hideez#gmail.com", "201101");

        WebElement signInButton = webDriver.findElement(By.id("login-submit"));
        signInButton.click();

        String actualString = webDriver.findElement(By.xpath("//*[@id=\"global-alert-queue\"]")).getText();
        assertTrue(actualString.contains("Hmm, we don't recognize that email. Please try again."));

        webDriver.close();
    }

    @Test
    public void wrongEmailWrongPasswordTest() {

        String actualLoginPageTitle = webDriver.getTitle();

        assertEquals(webDriver.getTitle(),
                "LinkedIn: Log In or Sign Up",
                "Login page Title is wrong");


        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage();
        linkedinLoginPage.login("db.hideez#gmail.com", "201101");

        WebElement signInButton = webDriver.findElement(By.id("login-submit"));
        signInButton.click();

        assertEquals(webDriver.getCurrentUrl(),
                "https://www.linkedin.com/uas/login-submit",
                "There were one or more errors in your submission.Please correct the marked fields below.");

        String actualString = webDriver.findElement(By.xpath("//*[@id=\"session_password-login-error\"]")).getText();
        assertTrue(actualString.contains("Hmm, that's not the right password. Please try again or request a new one."));
        webDriver.close();
    }

    @Test
    public void emptyEmailCorrectPasswordTest() {

        String actualLoginPageTitle = webDriver.getTitle();

        assertEquals(webDriver.getTitle(),
                "LinkedIn: Log In or Sign Up",
                "Login page Title is wrong");


        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage();
        linkedinLoginPage.login("db.hideez#gmail.com", "201101");

        WebElement signInButton = webDriver.findElement(By.id("login-submit"));
        signInButton.click();

        assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/");

        webDriver.close();
    }

    @Test
    public void correctEmailEmptyPasswordTest() {

        String actualLoginPageTitle = webDriver.getTitle();

        assertEquals(webDriver.getTitle(),
                "LinkedIn: Log In or Sign Up",
                "Login page Title is wrong");


        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage();
        linkedinLoginPage.login("db.hideez#gmail.com", "201101");

        WebElement signInButton = webDriver.findElement(By.id("login-submit"));
        signInButton.click();

        assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/");

        webDriver.close();
    }

    @Test
    public void negativeTest() throws InterruptedException {

        String actualLoginPageTitle = webDriver.getTitle();

        assertEquals(webDriver.getTitle(),
                "LinkedIn: Log In or Sign Up",
                "Login page Title is wrong");

        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage();
        linkedinLoginPage.login("db.hideez#gmail.com","201101");

        WebElement correctEmailField = webDriver.findElement(By.id("login-email"));
        WebElement wrongPasswordField = webDriver.findElement(By.id("login-password"));
        WebElement signInButton = webDriver.findElement(By.id("login-submit"));

        correctEmailField.sendKeys("db.hideez@gmail.com");
        wrongPasswordField.sendKeys("1");
        signInButton.click();

        sleep(3000);

        String currentPageUrl = webDriver.getCurrentUrl();
        String currentPageTitle = webDriver.getTitle();

        assertEquals(currentPageUrl, "https://www.linkedin.com/uas/login-submit",
                "Login-Submit page url is wrong");
        assertEquals(currentPageTitle, "Sign In to LinkedIn",
                "Login-Submit page Title is wrong");


        WebElement errorMessage = ((FirefoxDriver) webDriver).findElement(By.xpath("//div[@role='alert']"));
        assertEquals(errorMessage.getText(),
                "There were one or more errors in your submission. Please correct the marked fields below.",
                "Wrong error message text displayed.");
    }

    @AfterMethod
    public void after(){
        webDriver.close();
    }

}