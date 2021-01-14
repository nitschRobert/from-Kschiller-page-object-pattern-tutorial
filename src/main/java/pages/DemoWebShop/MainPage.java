package pages.DemoWebShop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;

public class MainPage extends PageObject {

    @FindBy(xpath = "//a[starts-with(@href,'/login') and @class='ico-login']")
    private WebElement loginIcon;

    @FindBy(xpath = "(//*[@class='account'])[1]")
    private WebElement customerInfo;

    @FindBy(xpath = "//ul[@class='top-menu']/li/a[starts-with(@href,'/apparel-shoes')]")
    private WebElement apparelShoesIcon;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String getCustomerInfo() {
        return customerInfo.getText();
    }

    public ApparelShoesPage goToApparelShoes() {
        apparelShoesIcon.click();
        return new ApparelShoesPage(driver);
    }

    public LogInPage goToLogin() {
        loginIcon.click();
        return new LogInPage(driver);
    }
}
