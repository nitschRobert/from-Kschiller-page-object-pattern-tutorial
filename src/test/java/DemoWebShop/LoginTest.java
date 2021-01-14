package DemoWebShop;

import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.DemoWebShop.LogInPage;
import pages.DemoWebShop.MainPage;
import BasicTestClass.BasicTestClass;

import static org.junit.Assert.assertEquals;

public class LoginTest extends BasicTestClass {

	@Test
	public void logIn(){
		driver.get("http://demowebshop.tricentis.com");
		
		MainPage mainPage = new MainPage(driver);
		wait.until(ExpectedConditions.titleIs("Demo Web Shop"));

		LogInPage logInPage = mainPage.goToLogin();

		logInPage.enterLogin("robert.nitsch@outlook.com");
		logInPage.enterPassword("Qwerty1234%");
		logInPage.logIntoWebShop();

		assertEquals("robert.nitsch@outlook.com", mainPage.getCustomerInfo());
	}	
}