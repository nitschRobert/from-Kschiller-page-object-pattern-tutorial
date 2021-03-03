package pages.DemoWebShop_v2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;

public class MainPage2 extends PageObject {

    @FindBy(xpath = "//a[starts-with(@href,'/login') and @class='ico-login']")
    private WebElement loginIcon;

    @FindBy(xpath = "(//*[@class='account'])[1]")
    private WebElement customerInfo;

    @FindBy(xpath = "//ul[@class='top-menu']/li/a[starts-with(@href,'/apparel-shoes')]")
    private WebElement apparelShoesIcon;

    @FindBy(xpath = "//a[starts-with(@href,'/logout') and @class='ico-logout']")
    private WebElement logoutIcon;

    public MainPage2(WebDriver driver) {
        super(driver);
    }

    public String getCustomerInfo() {
        return customerInfo.getText();
    }

    public ApparelShoesPage2 goToApparelShoes() {
        apparelShoesIcon.click();
        return new ApparelShoesPage2(driver);
    }

    public LogInPage2 goToLogin() {
        loginIcon.click();
        return new LogInPage2(driver);
    }

    public MainPage2 logOut() {
        logoutIcon.click();
        return this;
    }

    public boolean loginIconIsDisplyed() { return loginIcon.isDisplayed();}
}
