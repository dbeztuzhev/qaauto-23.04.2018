import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class qqq {
    public static void main (String args[]) {
        System.out.println("Hello world!");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.hideez.com/");
    }
}