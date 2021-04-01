package Seleniumui_Moderntester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class AutomationPracticeForm {

    @Test
    public void practiceFormReview() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(option);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.navigate().to("https://seleniumui.moderntester.pl/form.php");
       // driver.manage().window().maximize();
        Assert.assertEquals(driver.getCurrentUrl(),"https://seleniumui.moderntester.pl/form.php");

        WebElement header = driver.findElement(By.className("display-4"));
        Assert.assertEquals(header.getText(),"Automation Pratice Form");

        WebElement firstName = driver.findElement(By.id("inputFirstName3"));
        Actions actions = new Actions(driver);
        Action clickAndHold = actions.clickAndHold(firstName).build();
        clickAndHold.perform();
        Action doubleClick = actions.doubleClick(firstName).build();
        doubleClick.perform();

//        WebElement lastName;
//        WebElement emailAddress;
//        WebElement age;
//        WebElement continents;
//        WebElement seleniumCommands;
        WebElement fileUpload = driver.findElement(By.cssSelector("input[id='chooseFile']"));
        fileUpload.sendKeys("C:\\Users\\rnicz\\Downloads\\qwerty.txt");

        driver.quit();
    }
}
