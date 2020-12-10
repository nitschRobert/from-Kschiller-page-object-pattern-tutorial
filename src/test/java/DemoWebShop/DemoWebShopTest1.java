package DemoWebShop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.Assertion;

import java.util.List;

public class DemoWebShopTest1 {

    @Test
    public void demoShopTest() {
        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver,3);

        //Open Web Shop
        driver.navigate().to("http://demowebshop.tricentis.com");

        driver.manage().window().maximize();

        //Navigate to Log in Page
        WebElement loginIcon = driver.findElement(By.xpath("//a[starts-with(@href,'/login') and @class='ico-login']"));
        loginIcon.click();

        //Log in
        String loginPageTitle = "Demo Web Shop. Login";
        wait.until(ExpectedConditions.titleIs(loginPageTitle));

        WebElement loginInput = driver.findElement(By.xpath("//input[@id='Email' and @class='email']"));
        loginInput.sendKeys("robert.nitsch@outlook.com");

        WebElement passInput = driver.findElement(By.xpath("//input[@id='Password' and @class='password']"));
        passInput.sendKeys("Qwerty1234%");

        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button' and @type='submit']"));
        loginButton.click();

        WebElement logoutIcon = driver.findElement(By.xpath("//a[starts-with(@href,'/logout') and @class='ico-logout']"));
        //wait.until(ExpectedConditions.visibilityOfAllElements(loginIcon));
        Assertions.assertTrue(logoutIcon.isEnabled());

        //Navigate to Apparel and Shoes
                /*   WebElement apparelShoesIcon = driver.findElement(By.xpath("//a[starts-with(@href,'/apparel-shoes')]"));

                  List<WebElement> apparelShoes = driver.findElements(By.xpath("//a[starts-with(@href,'/apparel-shoes')]"));
                  WebElement apparelShoesIcon = apparelShoes.get(0); */

        WebElement apparelShoesIcon = driver.findElement(By.xpath("//ul[@class='top-menu']/li/a[starts-with(@href,'/apparel-shoes')]"));
        apparelShoesIcon.click();

        WebElement apparelShoesPageTitle = driver.findElement(By.xpath("//strong[@class='current-item']"));
        Assertions.assertEquals("APPAREL & SHOES", apparelShoesPageTitle.getText());

        //Navigate to Blue Jeans
        WebElement blueJeansLink = driver.findElement(By.xpath("//h2[@class='product-title']/a[starts-with(@href,'/blue-jeans')]"));
        blueJeansLink.click();

        wait.until(ExpectedConditions.titleIs("Demo Web Shop. Blue Jeans"));

        //Navigate to Blue Jeans > Order Blue Jeans

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@class, 'qty-input')]")));
        WebElement quantityInput = driver.findElement(By.xpath("//input[contains(@class, 'qty-input')]"));
        quantityInput.clear();
        quantityInput.sendKeys("25");

        WebElement addToCartButton =driver.findElement(By.xpath("//input[@class='button-1 add-to-cart-button']"));
        addToCartButton.click();



        driver.close();
    }
}
