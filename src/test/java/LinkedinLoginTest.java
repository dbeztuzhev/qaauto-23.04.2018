import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class LinkedinLoginTest {
    
    @BeforeMethod
    public void before() {
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

    @Test (dataProvider="ValidDataProvider")
    public void successfulLoginTest(String email, String password) {
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
                "Home page url is wrong.");

    }

    /*@Test
    public void notValidEmailCorrectPasswordTest() {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);

        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Log In or Sign Up",
                "Login page Title is wrong");
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
                "Sign In button is not Displayed");

        linkedinLoginPage.login("db.hideez#gmail.com", "201101");

        LinkedinLoginSubmitPage linkedinLoginSubmitPage = new LinkedinLoginSubmitPage(webDriver);

        Assert.assertEquals(LinkedinLoginSubmitPage.getCurrentUrl(),
                "https://www.linkedin.com/uas/login-submit",
                "Login-Submit page url is wrong");

        Assert.assertEquals(LinkedinLoginSubmitPage.getCurrentTitle(),
                "Sign In to LinkedIn",
                "Login-Submit page Title is wrong");

        WebElement errorMessage = (webDriver.findElement(By.xpath("//*[@id=\"session_key-login-error\"]")));
        Assert.assertEquals(errorMessage.getText(),
                "Please enter a valid email address.",
                "Wrong error message text displayed.");
            }

    @Test
    public void wrongEmailWrongPasswordTest() throws InterruptedException {

        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Log In or Sign Up",
                "Login page Title is wrong");
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
                "Sign In button is not Displayed");

        linkedinLoginPage.login("hideez@gmail.com", "201101111");

        sleep(3000);

        LinkedinLoginSubmitPage linkedinLoginSubmitPage = new LinkedinLoginSubmitPage(webDriver);

        Assert.assertEquals(LinkedinLoginSubmitPage.getCurrentUrl(),
                "https://www.linkedin.com/uas/login-submit",
                "Login-Submit page url is wrong");

        Assert.assertEquals(LinkedinLoginSubmitPage.getCurrentTitle(),
                "Sign In to LinkedIn",
                "Login-Submit page Title is wrong");

        WebElement errorMessage = (webDriver.findElement(By.xpath("//*[@id=\"session_key-login-error\"]")));

        Assert.assertEquals(errorMessage.getText(),
                "Hmm, we don't recognize that email. Please try again.",
                "Wrong error message text displayed.");

        WebElement errorMessage2 = (webDriver.findElement(By.xpath("//div[@role='alert']")));

        Assert.assertEquals(errorMessage2.getText(),
                "There were one or more errors in your submission. Please correct the marked fields below.",
                "Wrong error message text displayed.");
        }

    @Test
    public void emptyEmailCorrectPasswordTest() {

        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Log In or Sign Up",
                "Login page Title is wrong");
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
                "Sign In button is not Displayed");

        linkedinLoginPage.login("", "201101");

        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Log In or Sign Up",
                "Login page Title is wrong");

    }

    @Test
    public void negativReturnToLoginSubmitTest() throws InterruptedException {

        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Log In or Sign Up",
                "Login page Title is wrong");
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
                "Sign In button is not Displayed");

        linkedinLoginPage.login("db.hideez@gmail.com", "1");
        sleep(3000);

        LinkedinLoginSubmitPage linkedinLoginSubmitPage = new LinkedinLoginSubmitPage(webDriver);
        Assert.assertTrue(linkedinLoginSubmitPage.isPageLoaded(),
                "Login-Submit page is not loaded");
        Assert.assertEquals(linkedinLoginSubmitPage.getErrorMessageText(), "",
                "Error message text is incorrect");
    }
        *//*Assert.assertEquals(LinkedinLoginSubmitPage.getCurrentUrl(),
                "https://www.linkedin.com/uas/login-submit",
                "Login-Submit page url is wrong");

        Assert.assertEquals(LinkedinLoginSubmitPage.getCurrentTitle(),
                "Sign In to LinkedIn",
                "Login-Submit page Title is wrong");


        WebElement errorMessage = (webDriver.findElement(By.xpath("//div[@role='alert']")));
        Assert.assertEquals(errorMessage.getText(),
                "There were one or more errors in your submission. Please correct the marked fields below.",
                "Wrong error message text displayed.");

        WebElement errorMessage2 = (webDriver.findElement(By.xpath("//*[@id=\"session_password-login-error\"]")));
        Assert.assertEquals(errorMessage2.getText(),
                "The password you provided must have at least 6 characters.",
                "Wrong error message text displayed.");*//*


    @Test
    public void correctEmailWrongPasswordTest() throws InterruptedException {

        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Log In or Sign Up",
                "Login page Title is wrong");
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
                "Sign In button is not Displayed");

        linkedinLoginPage.login("db.hideez@gmail.com", "111111");

        sleep(3000);

        LinkedinLoginSubmitPage linkedinLoginSubmitPage = new LinkedinLoginSubmitPage(webDriver);

        Assert.assertEquals(LinkedinLoginSubmitPage.getCurrentUrl(),
                "https://www.linkedin.com/uas/login-submit",
                "Login-Submit page url is wrong");

        Assert.assertEquals(LinkedinLoginSubmitPage.getCurrentTitle(),
                "Sign In to LinkedIn",
                "Login-Submit page Title is wrong");

        WebElement errorMessage = (webDriver.findElement(By.xpath("//div[@role='alert']")));
        Assert.assertEquals(errorMessage.getText(),
                "There were one or more errors in your submission. Please correct the marked fields below.",
                "Wrong error message text displayed.");
    }
*/
    @AfterMethod
    public void after(){
        webDriver.close();
    }

}