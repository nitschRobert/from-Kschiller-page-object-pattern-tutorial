package DemoWebShop;

import BasicTestClass.BasicTestClass;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DemoWebShop.*;

public class PlaceNewOrderTest2 extends BasicTestClass {

	MainPage mainPage = new MainPage(driver);
	LogInPage logInPage = new LogInPage(driver);
	ApparelShoesPage apparelShoesPage = new ApparelShoesPage(driver);
	BlueJeansPage blueJeansPage = new BlueJeansPage(driver);
	ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
	CheckoutPage checkoutPage = new CheckoutPage(driver);

	@Test
	public void logIn() {
		driver.get("http://demowebshop.tricentis.com");
		wait.until(ExpectedConditions.titleIs("Demo Web Shop"));

		mainPage.goToLogin();

		logInPage.enterLogin("robert.nitsch@outlook.com");
		logInPage.enterPassword("Qwerty1234%");
		logInPage.logIntoWebShop();

		mainPage.goToApparelShoes();

		apparelShoesPage.chooseBlueJeans();
		blueJeansPage.setBlueJeansQty("25");
		blueJeansPage.addToCart();
		blueJeansPage.goToShoppingCart();

		shoppingCartPage.setTermsOfServiceCheckbox();
		shoppingCartPage.goToCheckout();

		checkoutPage.goToShippingAddress();
		checkoutPage.setInStorePickupCheckbox();
		checkoutPage.goToPaymentMethod();
		checkoutPage.selectCreditCard();
		checkoutPage.goToPaymentInformation();
		checkoutPage.selectCreditCardType("Visa");
		checkoutPage.enterCardholderName("randomText");
		checkoutPage.enterCardNumber("4485564059489345");
		checkoutPage.selectExpirationMonth("4");
		checkoutPage.selectExpirationYear("2024");
		checkoutPage.enterCardCode("1000");
		checkoutPage.goToConfirmOrder();

		Assert.assertEquals("25.00", checkoutPage.getSubtotal());
		Assert.assertEquals("0.00", checkoutPage.getShippingCost());
		Assert.assertEquals("25.00", checkoutPage.getTotalPrice());
//void assertEquals(boolean expected, boolean actual) - compares the two given values / objects and checks if they are equal

		Assert.assertFalse(checkoutPage.getTotalPrice() == "0.00");
//void assertFalse(boolean condition) -checks whether the condition is false

		checkoutPage.orderConfirmation();
		Assert.assertEquals("Your order has been successfully processed!", checkoutPage.orderSuccess());

		checkoutPage.orderCompletedContinue();
		mainPage.logOut();
		Assert.assertTrue(mainPage.loginIconIsDisplyed());
//assertTrue(boolean condition) - checks if the condition is true
	}
}