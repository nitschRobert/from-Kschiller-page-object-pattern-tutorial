package pages.DemoWebShop_v2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageObject;

public class LogInPage2 extends PageObject {

    @FindBy(xpath = "//input[@id='Email' and @class='email']")
    private WebElement loginInput;

    @FindBy(xpath = "//input[@id='Password' and @class='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@class='button-1 login-button' and @type='submit']")
    private WebElement loginButton;

    public LogInPage2(WebDriver driver) {
        super(driver);
    }

    public LogInPage2 enterLogin(String login) {
        loginInput.clear();
        loginInput.sendKeys(login);
        return this;
    }

    public LogInPage2 enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }

    public MainPage2 logIntoWebShop(){
        loginButton.click();
        return new MainPage2(driver);
    }
}
