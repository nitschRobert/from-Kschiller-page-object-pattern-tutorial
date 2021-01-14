package pages.DemoWebShop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;

public class BlueJeansPage extends PageObject {

    @FindBy(xpath = "//input[contains(@class, 'qty-input')]")
    private WebElement blueJeansQty;

    @FindBy(xpath = "//input[@class='button-1 add-to-cart-button']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//span[@class='cart-label' and .='Shopping cart']")
    private WebElement shoppingCartButton;

    public BlueJeansPage(WebDriver driver) {
        super(driver);
    }

    public void setBlueJeansQty(String quantity){
        blueJeansQty.clear();
        blueJeansQty.sendKeys(quantity);
    }

    public void addToCart(){
        addToCartButton.click();
    }

    public ShoppingCartPage goToShoppingCart(){
        shoppingCartButton.click();
        return new ShoppingCartPage(driver);
    }
}
