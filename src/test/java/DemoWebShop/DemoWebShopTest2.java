package DemoWebShop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DemoWebShopTest2 {

    @Test
    public void demoShopTest() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,6);

//Open Web Shop
        driver.navigate().to("http://demowebshop.tricentis.com");
        driver.manage().window().maximize();

        wait.until(ExpectedConditions.titleIs("Demo Web Shop"));

//Navigate to Log in Page
        WebElement loginIcon = driver.findElement(By.xpath("//a[starts-with(@href,'/login') and @class='ico-login']"));
        loginIcon.click();

        wait.until(ExpectedConditions.titleIs("Demo Web Shop. Login"));

//Log in
        WebElement loginInput = driver.findElement(By.xpath("//input[@id='Email' and @class='email']"));
        loginInput.sendKeys("robert.nitsch@outlook.com");

        WebElement passInput = driver.findElement(By.xpath("//input[@id='Password' and @class='password']"));
        passInput.sendKeys("Qwerty1234%");

        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button' and @type='submit']"));
        loginButton.click();

        WebElement logoutButton= driver.findElement(By.xpath("//a[starts-with(@href,'/logout') and @class='ico-logout']"));
        Assertions.assertTrue(logoutButton.isEnabled());

//Navigate to Apparel and Shoes
        WebElement apparelShoesIcon = driver.findElement(By.xpath("//ul[@class='top-menu']/li/a[starts-with(@href,'/apparel-shoes')]"));
        apparelShoesIcon.click();

        wait.until(ExpectedConditions.titleIs("Demo Web Shop. Apparel & Shoes"));

//Navigate to Blue Jeans
        WebElement blueJeansLink = driver.findElement(By.xpath("//h2[@class='product-title']/a[starts-with(@href,'/blue-jeans')]"));
        blueJeansLink.click();

        wait.until(ExpectedConditions.titleIs("Demo Web Shop. Blue Jeans"));

//Order Blue Jeans & Start Checkout > Navigate to Shopping Cart
        WebElement quantityInput = driver.findElement(By.xpath("//input[contains(@class, 'qty-input')]"));
        quantityInput.clear();
        quantityInput.sendKeys("25");

        WebElement addToCartButton =driver.findElement(By.xpath("//input[@class='button-1 add-to-cart-button']"));
        addToCartButton.click();

        WebElement shoppingCartButton = driver.findElement(By.xpath("//span[@class='cart-label' and .='Shopping cart']"));
        shoppingCartButton.click();

        wait.until(ExpectedConditions.titleIs("Demo Web Shop. Shopping Cart"));

//Shopping Cart Procedures
       // WebElement quantityCartInput = driver.findElement(By.xpath("//input[contains(@class,'qty-input')]"));
      //  Assertions.assertEquals("25", quantityCartInput.getAttribute("value"));

        WebElement termsOfServiceCheckbox = driver.findElement(By.xpath("//input[@id='termsofservice' and @type='checkbox']"));
        termsOfServiceCheckbox.click();

        WebElement checkoutButton = driver.findElement(By.xpath("//button[@id='checkout' and @type='submit']"));
        checkoutButton.click();

        wait.until(ExpectedConditions.titleIs("Demo Web Shop. Checkout"));

//Checkout Process_Reference
       // String actualBillingAddress = "firstName lastName, 222, 111, Alberta 444, Canada";
       // WebElement billingAddress = driver.findElement(By.xpath("//select[@name='billing_address_id']/option[1]"));
       // Assertions.assertEquals(actualBillingAddress,billingAddress.getText());

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

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='CreditCardType']")));

// Payment Information
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
        cardCode.sendKeys("1000");

        WebElement paymentInfoContinueButton = driver.findElement(By.xpath("//*[@class='button-1 payment-info-next-step-button']"));
        paymentInfoContinueButton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class='cart-total-right'])[1]")));

//Verification of Prices
        WebElement subTotalPrice = driver.findElement(By.xpath("(//*[@class='cart-total-right'])[1]"));
        Assertions.assertEquals("25.00", subTotalPrice.getText());

        WebElement shippingCost = driver.findElement(By.xpath("(//*[@class='cart-total-right'])[2]"));
        Assertions.assertEquals("0.00",shippingCost.getText());

        WebElement totalPrice = driver.findElement(By.xpath("(//*[@class='cart-total-right'])[4]"));
        Assertions.assertEquals("25.00", totalPrice.getText());

//Confirm the Order
        WebElement confirmOrderButton = driver.findElement(By.xpath("//input[@value='Confirm']"));
        confirmOrderButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='title']/strong")));

//Verify the Order Success
        WebElement orderSuccessMessage = driver.findElement(By.xpath("//div[@class='title']/strong"));
        Assertions.assertEquals("Your order has been successfully processed!", orderSuccessMessage.getText());

//Close Web Shop
        WebElement orderSuccessContinue = driver.findElement(By.xpath("//input[contains(@class,'button-2 order-completed-continue-button')]"));
        orderSuccessContinue.click();

        wait.until(ExpectedConditions.titleIs("Demo Web Shop"));

        WebElement logout = driver.findElement(By.xpath("//a[starts-with(@href,'/logout') and @class='ico-logout']"));
        logout.click();
        driver.close();
    }
}
