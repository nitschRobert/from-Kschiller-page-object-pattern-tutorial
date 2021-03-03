package pages.DemoWebShop_v2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;

public class BlueJeansPage2 extends PageObject {

    @FindBy(xpath = "//input[contains(@class, 'qty-input')]")
    private WebElement blueJeansQty;

    @FindBy(xpath = "//input[@class='button-1 add-to-cart-button']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//span[@class='cart-label' and .='Shopping cart']")
    private WebElement shoppingCartButton;

    public BlueJeansPage2(WebDriver driver) {
        super(driver);
    }

    public BlueJeansPage2 setBlueJeansQty(String quantity){
        blueJeansQty.clear();
        blueJeansQty.sendKeys(quantity);
        return this;
    }

    public BlueJeansPage2 addToCart(){
        addToCartButton.click();
        return this;
    }

    public ShoppingCartPage2 goToShoppingCart(){
        shoppingCartButton.click();
        return new ShoppingCartPage2(driver);
    }
}
