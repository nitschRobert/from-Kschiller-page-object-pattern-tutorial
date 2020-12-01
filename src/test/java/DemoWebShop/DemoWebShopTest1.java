package DemoWebShop;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoWebShopTest1 {

    @Test
    public void demoShopTest() {
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("http://demowebshop.tricentis.com");

        driver.close();
    }
}
