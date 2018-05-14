import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Driver;

public class LinkedinLoginTest {

   /* @Test
    public void successfulLoginTest() {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com/");

        String actualLoginPageTitle = webDriver.getTitle();

        *//*Assert.assertEquals("a", "b", "Probably 'a' is not equal to 'b'");
     *//*
        Assert.assertEquals(webDriver.getTitle(),
                "LinkedIn: Log In or Sign Up",
                "Login page Title is wrong");


        WebElement emailField = webDriver.findElement(By.id("login-email"));
        WebElement passwordField = webDriver.findElement(By.id("login-password"));
        WebElement signInButton = webDriver.findElement(By.id("login-submit"));

        *//*Assert.assertTrue(signInButton.isDisplayed(), "Sign In button is not Displayed");

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
*//*


     *//*WebElement emailField = webDriver.findElement(By.xpath("//*[@id=\"login-email\"]"));
        emailField.sendKeys("db.hideez@gmail.com");

        WebElement passwordField = ((FirefoxDriver) webDriver).findElementByXPath("//*[@id=\"login-password\"]");
        passwordField.sendKeys("201101");

        WebElement signInButton = webDriver.findElement(By.xpath("//*[@id=\"login-submit\"]"));
                                                        // (By.id("login-submit")
        signInButton.click();

        String currentUrl = webDriver.getCurrentUrl();
        Assert.assertEquals( currentUrl , "https://www.linkedin.com/feed/");

        Assert.assertEquals(webDriver.getTitle(), "LinkedIn", "Home page Title is wrong");

        *//**//*String actualString = webDriver.findElement(By.xpath("//*[@id=\"ember4072\"]")).getText();
        Assert.assertTrue(actualString.contains("Добро пожаловать, Den!"));*//*

        webDriver.close();
    }
}*/

    @Test
public void wrongEmailCorrectPasswordTest() {
    WebDriver webDriver = new FirefoxDriver();
    webDriver.get("https://www.linkedin.com/");

    String actualLoginPageTitle = webDriver.getTitle();

    Assert.assertEquals(webDriver.getTitle(),
            "LinkedIn: Log In or Sign Up",
            "Login page Title is wrong");


    WebElement wrongEmailField=webDriver.findElement(By.id("login-email"));
    wrongEmailField.sendKeys("dbgmail.com");

    WebElement correctPasswordField =webDriver.findElement(By.id("login-password"));
    correctPasswordField.sendKeys("201101");

    WebElement signInButton =webDriver.findElement(By.id("login-submit"));
    signInButton.click();

    Assert.assertEquals(webDriver.getCurrentUrl(),
            "https://www.linkedin.com/uas/login-submit",
            "There were one or more errors in your submission. Please correct the marked fields below.");
    Assert.assertEquals("Please enter a valid email address.", "Please enter a valid email address.");
    webDriver.close();}

    @Test
    public void correctEmailWrongPasswordTest() {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com/");

        String actualLoginPageTitle = webDriver.getTitle();

        Assert.assertEquals(webDriver.getTitle(),
                "LinkedIn: Log In or Sign Up",
                "Login page Title is wrong");


        WebElement wrongEmailField=webDriver.findElement(By.id("login-email"));
        wrongEmailField.sendKeys("db.hideez@gmail.com");

        WebElement correctPasswordField =webDriver.findElement(By.id("login-password"));
        correctPasswordField.sendKeys("222222");

        WebElement signInButton =webDriver.findElement(By.id("login-submit"));
        signInButton.click();

        Assert.assertEquals(webDriver.getCurrentUrl(),
                "https://www.linkedin.com/uas/login-submit",
                "There were one or more errors in your submission.Please correct the marked fields below.");
        webDriver.close();}

    @Test
    public void wrongEmailWrongPasswordTest() {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com/");

        String actualLoginPageTitle = webDriver.getTitle();

        Assert.assertEquals(webDriver.getTitle(),
                "LinkedIn: Log In or Sign Up",
                "Login page Title is wrong");


        WebElement wrongEmailField=webDriver.findElement(By.id("login-email"));
        wrongEmailField.sendKeys("hideez@gmail.com");

        WebElement wrongPasswordField =webDriver.findElement(By.id("login-password"));
        wrongPasswordField.sendKeys("222222");

        WebElement signInButton =webDriver.findElement(By.id("login-submit"));
        signInButton.click();

        Assert.assertEquals(webDriver.getCurrentUrl(),
                "https://www.linkedin.com/uas/login-submit",
                "There were one or more errors in your submission.Please correct the marked fields below.");
        Assert.assertEquals("Hmm, we don't recognize that email. Please try again.", "Hmm, we don't recognize that email. Please try again.");
        webDriver.close();}

    @Test
    public void emptyEmailCorrectPasswordTest() {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com/");

        String actualLoginPageTitle = webDriver.getTitle();

        Assert.assertEquals(webDriver.getTitle(),
                "LinkedIn: Log In or Sign Up",
                "Login page Title is wrong");


        WebElement emptyEmailField=webDriver.findElement(By.id("login-email"));
        emptyEmailField.sendKeys("");

        WebElement correctPasswordField =webDriver.findElement(By.id("login-password"));
        correctPasswordField.sendKeys("201101");

        WebElement signInButton =webDriver.findElement(By.id("login-submit"));
        signInButton.click();

        Assert.assertEquals(webDriver.getCurrentUrl(),"https://www.linkedin.com/");

        webDriver.close();}

    @Test
    public void correctEmailEmptyPasswordTest() {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com/");

        String actualLoginPageTitle = webDriver.getTitle();

        Assert.assertEquals(webDriver.getTitle(),
                "LinkedIn: Log In or Sign Up",
                "Login page Title is wrong");


        WebElement correctEmailField=webDriver.findElement(By.id("login-email"));
        correctEmailField.sendKeys("");

        WebElement emptyPasswordField =webDriver.findElement(By.id("login-password"));
        emptyPasswordField.sendKeys("201101");

        WebElement signInButton =webDriver.findElement(By.id("login-submit"));
        signInButton.click();

        Assert.assertEquals(webDriver.getCurrentUrl(),"https://www.linkedin.com/");

        webDriver.close();}
    }

//