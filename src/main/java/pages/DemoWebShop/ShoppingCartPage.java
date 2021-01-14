package pages.DemoWebShop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;

public class ShoppingCartPage extends PageObject {

    @FindBy(xpath = "//input[@id='termsofservice' and @type='checkbox']")
    private WebElement termsOfServiceCheckbox;

    @FindBy(xpath = "//button[@id='checkout' and @type='submit']")
    private WebElement checkoutButton;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public void setTermsOfServiceCheckbox(){
        termsOfServiceCheckbox.click();
    }

    public CheckoutPage goToCheckout(){
        checkoutButton.click();
        return new CheckoutPage(driver);
    }
}
