package DemoWebShop;

import BasicTestClass.BasicTestClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.DemoWebShop.*;

public class PlaceNewOrderTest extends BasicTestClass {

	@Test
	public void logIn() throws InterruptedException{
		driver.get("http://demowebshop.tricentis.com");
		wait.until(ExpectedConditions.titleIs("Demo Web Shop"));

		MainPage mainPage = new MainPage(driver);

		LogInPage logInPage = mainPage.goToLogin();
		logInPage.enterLogin("robert.nitsch@outlook.com");
		logInPage.enterPassword("Qwerty1234%");
		logInPage.logIntoWebShop();

		ApparelShoesPage apparelShoesPage = mainPage.goToApparelShoes();

		BlueJeansPage blueJeansPage = apparelShoesPage.chooseBlueJeans();
		blueJeansPage.setBlueJeansQty("25");
		blueJeansPage.addToCart();

		ShoppingCartPage shoppingCartPage = blueJeansPage.goToShoppingCart();
		shoppingCartPage.setTermsOfServiceCheckbox();

		CheckoutPage checkoutPage = shoppingCartPage.goToCheckout();
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

		checkoutPage.orderConfirmation();
		Assert.assertEquals("Your order has been successfully processed!", checkoutPage.orderSuccess());

		MainPage mainPage1 = checkoutPage.orderCompletedContinue();
		mainPage1.logOut();
		Assert.assertTrue(mainPage1.loginIconIsDisplyed());
	}
}