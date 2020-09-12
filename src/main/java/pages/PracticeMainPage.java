package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PracticeMainPage extends PageObject {

    @FindBy(className = "icon-credit-card")
    private WebElement creditCardIcon;

    @FindBy(className = "button-search")
    private WebElement searchButton;

    @FindBy(linkText = "Women")
    private WebElement womenButton;

    public PracticeMainPage(WebDriver driver) { super(driver);}

    public boolean creditCardIconIsVisible() { return creditCardIcon.isDisplayed();}

    public boolean searchButtonIsVisible() {return searchButton.isDisplayed();}

    public void goToWomenTab() {
        womenButton.click();
    }
}
