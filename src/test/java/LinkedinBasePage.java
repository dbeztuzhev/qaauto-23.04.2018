import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class LinkedinBasePage {
    protected WebDriver webDriver;

    public LinkedinBasePage (WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    public String getCurrentTitle() {
        return webDriver.getTitle();
    }

    abstract boolean isPageLoaded();



}

