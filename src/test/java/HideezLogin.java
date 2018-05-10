import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HideezLogin {

    @Test
    public void successfulLoginTesth() {

        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://my.hideez.com");

        /*Assert.assertEquals("a", "b", "Probably 'a' is not equal to 'b'");
         */
        /*Assert.assertEquals(webDriver.getTitle(),
                "LinkedIn: Log In or Sign Up",
                "Login page Title is wrong");*/

        //актуальный результат и ожидаемый результат (титул страницы сайта)

        WebElement inputLogin = webDriver.findElement(By.xpath("//*[@id=\"UserName\"]"));
        inputLogin.sendKeys("db.hideez@gmail.com");

        WebElement inputPassword = ((FirefoxDriver) webDriver).findElementByXPath("//*[@id=\"password\"]");
        inputPassword.sendKeys("hideeztest");

        WebElement searchButton = webDriver.findElement(By.xpath("//*[@class=\"Rectangle-19 col-xs-5\"]"));
        searchButton.click();

        String currentUrl = webDriver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://my.hideez.com/Home/Cabinet");

        String actualString = webDriver.findElement(By.xpath("//*//div[@id=\"mainDiv\"]/h2")).getText();
        Assert.assertTrue(actualString.contains("Hello, Denys Beztuzhev!"));

        webDriver.close();
    }
}

