package DemoWebShop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.Assertion;
import java.util.List;
import java.util.Random;

public class DemoWebShopTest1 {

    @Test
    public void demoShopTest() {
        Random random = new Random();
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

//Start Checkout > Navigate to Shopping Cart
        WebElement shoppingCartButton = driver.findElement(By.xpath("//span[@class='cart-label' and .='Shopping cart']"));
        shoppingCartButton.click();

//Shopping Cart Procedures
        wait.until(ExpectedConditions.titleIs("Demo Web Shop. Shopping Cart"));

        WebElement quantityCartInput = driver.findElement(By.xpath("//input[contains(@class,'qty-input')]"));
        Assertions.assertEquals("25", quantityCartInput.getAttribute("value"));

        WebElement termsOfServiceCheckbox = driver.findElement(By.xpath("//input[@id='termsofservice' and @type='checkbox']"));
        termsOfServiceCheckbox.click();

        WebElement checkoutButton = driver.findElement(By.xpath("//button[@id='checkout' and @type='submit']"));
        checkoutButton.click();

//Checkout Process_Reference
        wait.until(ExpectedConditions.titleIs("Demo Web Shop. Checkout"));

        String actualBillingAddress = "firstName lastName, 222, 111, Alberta 444, Canada";
        WebElement billingAddress = driver.findElement(By.xpath("//select[@name='billing_address_id']/option[1]"));

        Assertions.assertEquals(actualBillingAddress,billingAddress.getText());

        WebElement continueButton = driver.findElement(By.xpath("//div[@id='checkout-step-billing']/div/input[@title='Continue']"));
        continueButton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='PickUpInStore']")));

        WebElement inStorePickupCheckbox = driver.findElement(By.xpath("//input[@id='PickUpInStore']"));
        inStorePickupCheckbox.click();

        WebElement shippingContinueButton = driver.findElement(By.xpath("//div[@id='checkout-step-shipping']/div/input[@title='Continue']"));
        shippingContinueButton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='paymentmethod_2']")));

        WebElement creditCardCheckbox = driver.findElement(By.xpath("//input[@id='paymentmethod_2']"));
        creditCardCheckbox.click();

        WebElement paymentMethodContinueButton = driver.findElement(By.xpath("//input[@onclick='PaymentMethod.save()']"));
        paymentMethodContinueButton.click();

// Payment Information

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='CreditCardType']")));

        Select creditCard = new Select(driver.findElement(By.xpath("//select[@id='CreditCardType']")));
        creditCard.selectByValue("Visa");

        WebElement cardholderName = driver.findElement(By.xpath("//input[@id='CardholderName']"));
        cardholderName.sendKeys("randomText");

        WebElement cardNumber = driver.findElement(By.xpath("//input[@id='CardNumber']"));
        cardNumber.sendKeys("4485564059489345");

        Select expirationMonth = new Select(driver.findElement(By.xpath("//select[@id='ExpireMonth']")));
        expirationMonth.selectByValue("4");

        Select expirationYear = new Select(driver.findElement(By.xpath("//select[@id='ExpireYear']")));
        expirationYear.selectByValue("2024");

        WebElement cardCode = driver.findElement(By.xpath("//input[@id='CardCode']"));
        //cardCode.sendKeys(random.n(1000));
        cardCode.sendKeys("1000");


        driver.close();
    }
}
