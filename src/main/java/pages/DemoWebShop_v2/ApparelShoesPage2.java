package pages.DemoWebShop_v2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;

public class ApparelShoesPage2 extends PageObject {

    @FindBy(xpath = "//h2[@class='product-title']/a[starts-with(@href,'/blue-jeans')]")
    private WebElement blueJeansLink;

    public ApparelShoesPage2(WebDriver driver) {
        super(driver);
    }

    public BlueJeansPage2 chooseBlueJeans(){
        blueJeansLink.click();
        return new BlueJeansPage2(driver);
    }
}
