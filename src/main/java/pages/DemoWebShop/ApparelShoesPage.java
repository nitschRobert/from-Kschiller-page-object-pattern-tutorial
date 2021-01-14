package pages.DemoWebShop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;

public class ApparelShoesPage extends PageObject {

    @FindBy(xpath = "//h2[@class='product-title']/a[starts-with(@href,'/blue-jeans')]")
    private WebElement blueJeansLink;

    public ApparelShoesPage(WebDriver driver) {
        super(driver);
    }

    public BlueJeansPage chooseBlueJeans(){
        blueJeansLink.click();
        return new BlueJeansPage(driver);
    }
}
