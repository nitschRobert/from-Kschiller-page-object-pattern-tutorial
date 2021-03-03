package DemoWebShop;

import BasicTestClass.BasicTestClass;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DemoWebShop_v2.*;

public class PlaceNewOrderTest3 extends BasicTestClass {

	MainPage2 mainPage = new MainPage2(driver);
	CheckoutPage2 checkoutPage = new CheckoutPage2(driver);

	@Test
	public void logIn() {
		driver.get("http://demowebshop.tricentis.com");
		wait.until(ExpectedConditions.titleIs("Demo Web Shop"));

		mainPage.goToLogin()
				.enterLogin("robert.nitsch@outlook.com")
				.enterPassword("Qwerty1234%")
				.logIntoWebShop()
				.goToApparelShoes()
				.chooseBlueJeans()
				.setBlueJeansQty("25")
				.addToCart()
				.goToShoppingCart()
				.setTermsOfServiceCheckbox()
				.goToCheckout()
				.goToShippingAddress()
				.setInStorePickupCheckbox()
				.goToPaymentMethod()
				.selectCreditCard()
				.goToPaymentInformation()
				.selectCreditCardType("Visa")
				.enterCardholderName("randomText")
				.enterCardNumber("4485564059489345")
				.selectExpirationMonth("4")
				.selectExpirationYear("2024")
				.enterCardCode("1000")
				.goToConfirmOrder();

		Assert.assertEquals("25.00", checkoutPage.getSubtotal());
		Assert.assertEquals("0.00", checkoutPage.getShippingCost());
		Assert.assertEquals("25.00", checkoutPage.getTotalPrice());

		checkoutPage.orderConfirmation();

		Assert.assertEquals("Your order has been successfully processed!", checkoutPage.orderSuccess());

		checkoutPage.orderCompletedContinue()
				.logOut();

		Assert.assertTrue(mainPage.loginIconIsDisplyed());
	}
}