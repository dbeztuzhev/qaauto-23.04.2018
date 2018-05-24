import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;


public class LinkedinLoginTest {
    WebDriver webDriver;

    @BeforeMethod
    public void before() throws InterruptedException {
        webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com/");
        }

    @DataProvider
    public Object[][] ValidDataProvider() {
        return new Object[][]{
                { "db.hideez@gmail.com", "201101" },
                { "DB.HIDEEZ@GMAIL.COM", "201101" },

        };
    }

    @DataProvider
    public Object[][] InvalidDataProviderLoginPage() {
        return new Object[][]{
                {"db.hideez@gmail.com", ""},
                {"", "201101"},
                {"   ", "   "},
        };
    }

    @DataProvider
    public Object[][] InvalidDataProviderLoginSubmitPage() {
        return new Object[][]{
                {"db.hideez#gmail.com", "201101"},
                {"db.hideez@gmail.com", "1"},
                {"hideez@gmail.com", "201101"},
                {"hideez@gmail.com", "1111111"},
        };
    }


    @Test (dataProvider="ValidDataProvider")
    public void successfulLoginTest(String email, String password) throws InterruptedException {

        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);

        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Log In or Sign Up",
                "Login page Title is wrong");

        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
                "Sign In button is not Displayed");

        linkedinLoginPage.login(email,password);

        LinkedinHomePage linkedinHomePage = new LinkedinHomePage(webDriver);

        Assert.assertEquals(linkedinHomePage.getCurrentUrl(),
                "https://www.linkedin.com/feed/",
                "Home page url is wrong.");

        Assert.assertTrue(linkedinHomePage.getCurrentTitle().contains("LinkedIn"),
                "Home page Title is wrong.");

        sleep(3000);
    }

    @Test (dataProvider="InvalidDataProviderLoginPage")
    public void negativeTestReturnedToLoginPage(String email, String password) throws InterruptedException {

        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);

        linkedinLoginPage.login(email,password);

        sleep(3000);

        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Log In or Sign Up",
                "Login-Submit page Title is wrong!");

        Assert.assertEquals(linkedinLoginPage.getCurrentUrl(),
                "https://www.linkedin.com/",
                "Login-Submit page URL is wrong!");
    }


    @Test(dataProvider = "InvalidDataProviderLoginSubmitPage")
    public void negativeTestReturnedToLoginSubmitPage(String email, String password) throws InterruptedException {

        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);

        linkedinLoginPage.login(email,password);

        sleep(3000);

        LinkedinLoginSubmitPage linkedinLoginSubmitPage = new LinkedinLoginSubmitPage(webDriver);

        Assert.assertEquals(linkedinLoginSubmitPage.getCurrentTitle(),
                "Sign In to LinkedIn",
                "Login Submit page Title is wrong!!!");

        Assert.assertEquals(linkedinLoginSubmitPage.getCurrentUrl(),
                "https://www.linkedin.com/uas/login-submit",
                "Login Submit page Url is wrong!!!");

        Assert.assertTrue(linkedinLoginSubmitPage.isPageLoaded(),
                "Login submit page isn't loaded");

        Assert.assertEquals(linkedinLoginSubmitPage.getErrorMessageText(),
                "There were one or more errors in your submission. Please correct the marked fields below.",
                "Error message text isn't displayed!!!");

                    }

    @AfterMethod
    public void after() {
    }

}