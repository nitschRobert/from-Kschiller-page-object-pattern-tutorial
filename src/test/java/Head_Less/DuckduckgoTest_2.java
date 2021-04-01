package Head_Less;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class DuckduckgoTest_2 {
    @Test
    public void searchTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("window-size=1400,800");
        WebDriver driver = new ChromeDriver(options);
        // open duckduckgo website
        driver.get("https://duckduckgo.com/");

        // find search input and type "google"
        WebElement searchInput = driver.findElement(By.id("search_form_input_homepage"));
        searchInput.sendKeys("Google");

        // find search button and click it
        WebElement searchButton = driver.findElement(By.id("search_button_homepage"));
        searchButton.click();

        // find all search results
        List<WebElement> searchResults = driver.findElements(By.className("result__body"));

        for (WebElement result : searchResults) {
            // find 'deeper' in each element
            // find title in each result and print text from it
            System.out.println(result.findElement(By.className("result__title")).getText());
            // find url in each result and print text from it
            System.out.println(result.findElement(By.className("result__extras__url")).getText());
        }

        // get text from the title of sidebar
        String sidebarTitle = driver.findElement(By.cssSelector(".module__title__link")).getText();

        // assert that sidebar title text equals "Google"
        Assert.assertEquals(sidebarTitle, "Google");
    }
}
