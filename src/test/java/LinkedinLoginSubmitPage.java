import org.openqa.selenium.WebDriver;

public class LinkedinLoginSubmitPage {
    static WebDriver webDriver;
    public LinkedinLoginSubmitPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public static String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    public static String getCurrentTitle() {
        return webDriver.getTitle();
    }
}



