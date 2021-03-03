package pages.DemoWebShop_v2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;

public class ShoppingCartPage2 extends PageObject {

    @FindBy(xpath = "//input[@id='termsofservice' and @type='checkbox']")
    private WebElement termsOfServiceCheckbox;

    @FindBy(xpath = "//button[@id='checkout' and @type='submit']")
    private WebElement checkoutButton;

    public ShoppingCartPage2(WebDriver driver) {
        super(driver);
    }

    public ShoppingCartPage2 setTermsOfServiceCheckbox(){
        termsOfServiceCheckbox.click();
        return this;
    }

    public CheckoutPage2 goToCheckout(){
        checkoutButton.click();
        return new CheckoutPage2(driver);
    }
}
