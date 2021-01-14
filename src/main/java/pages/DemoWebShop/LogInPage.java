package pages.DemoWebShop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;

public class LogInPage extends PageObject {

    @FindBy(xpath = "//input[@id='Email' and @class='email']")
    private WebElement loginInput;

    @FindBy(xpath = "//input[@id='Password' and @class='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@class='button-1 login-button' and @type='submit']")
    private WebElement loginButton;

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public void enterLogin(String login) {
        loginInput.clear();
        loginInput.sendKeys(login);
    }

    public void enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public MainPage logIntoWebShop(){
        loginButton.click();
        return new MainPage(driver);
    }
}
