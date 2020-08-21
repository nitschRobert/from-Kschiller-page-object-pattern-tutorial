package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AutomationpracticeMainPage extends PageObject {

    @FindBy(className = "icon-credit-card")
    private WebElement creditCardIcon;

    public AutomationpracticeMainPage(WebDriver driver) { super(driver);}

    public boolean isDisplayed() { return creditCardIcon.isDisplayed();}
}
