import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static java.lang.Thread.sleep;

public class BadCodExample {
    public static void main(String args[]) throws InterruptedException {
        System.out.println("Hello world!");
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://www.google.com/");

        WebElement searchField = webDriver.findElement(By.id("lst-ib"));
        searchField.sendKeys("Selenium");
        //sleep(1000);
        //WebElement searchButton = webDriver.findElement(By.xpath("//input[@type='button' and contains(@value, 'Google')]"));

        //searchButton.click();

        searchField.sendKeys(Keys.ENTER);

        sleep(3000);

        List<WebElement> searchResults = webDriver.findElements(
                // название переменной это сеч резалтс
                By.xpath("//div[@class='srg']/div[@class='g']"));
//список "лист" проверил 10 єлементов в результатах поиска
        System.out.println(searchResults.size());
        //вывести результаты поиска
        for (WebElement seachResult : searchResults) {
            //цикл "фор ич" - список результатов, типа веб элементы, по очереди пройти по всем элементам списка
            String searchResultText = seachResult.getText();
            // обявляю переменную типа стринг со значением поиск результа 1 элемента результата поиска
            if (searchResultText.contains("Selenium")) {
                //если условие выполняется - содержит слово силениум
                System.out.println("SearchTerm found!!");
                //то система печатает  - запрос поиска найден
            }
            System.out.println(searchResultText);
            // выполняется 10 раз (за блоком с условием Иф)
        }

        /*for (int i=1; i<=10; i++) {
        //обьявил переменную i, типа инт -целые числа, далее условия - повторять до 10, ++ это цикл с первого до последнего
            WebElement searchResult = webDriver.findElement(
                    By.xpath("//div[@class='srg']/div["+i+"]"));
            String searchResultText = searchResult.getText();
            if (searchResultText.contains("Selenium")) {
                System.out.println("SearchTerm found!!");
            }
            System.out.println(searchResultText);
        }*/
        sleep(5000);

        //webDriver.findElement(By.className("srg"));
        webDriver.close();
    }
}

