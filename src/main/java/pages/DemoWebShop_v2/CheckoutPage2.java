package pages.DemoWebShop_v2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.DemoWebShop.MainPage;
import pages.PageObject;

public class CheckoutPage2 extends PageObject {

    @FindBy(xpath = "//div[@id='checkout-step-billing']/div/input[@title='Continue']")
    private WebElement billingAddressContinue;

    @FindBy(xpath = "//input[@id='PickUpInStore']")
    private WebElement inStorePickupCheckbox;

    @FindBy(xpath = "//div[@id='checkout-step-shipping']/div/input[@title='Continue']")
    private WebElement shippingAddressContinue;

    @FindBy(xpath = "//input[@id='paymentmethod_2']")
    private WebElement creditCardPaymentMethod;

    @FindBy(xpath = "//input[@onclick='PaymentMethod.save()']")
    private WebElement paymentMethodContinue;

    @FindBy(xpath = "//select[@id='CreditCardType']")
    private WebElement creditCardType;

    @FindBy(xpath = "//input[@id='CardholderName']")
    private WebElement cardholderName;

    @FindBy(xpath = "//input[@id='CardNumber']")
    private WebElement cardNumber;

    @FindBy(xpath = "//select[@id='ExpireMonth']")
    private WebElement expirationMonth;

    @FindBy(xpath = "//select[@id='ExpireYear']")
    private WebElement expirationYear;

    @FindBy(xpath = "//input[@id='CardCode']")
    private WebElement cardCode;

    @FindBy(xpath = "//*[@class='button-1 payment-info-next-step-button']")
    private WebElement paymentInformationContinue;

    @FindBy(xpath = "(//*[@class='cart-total-right'])[1]")
    private WebElement subTotalPrice;

    @FindBy(xpath = "(//*[@class='cart-total-right'])[2]")
    private WebElement shippingCost;

    @FindBy(xpath = "(//*[@class='cart-total-right'])[4]")
    private WebElement totalPrice;

    @FindBy(xpath = "//input[@value='Confirm']")
    private WebElement confirmOrder;

    @FindBy(xpath = "//div[@class='title']/strong")
    private WebElement orderSuccessMessage;

    @FindBy(xpath = "//input[contains(@class,'button-2 order-completed-continue-button')]")
    private WebElement checkoutCompletedContinue;


    public CheckoutPage2(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage2 goToShippingAddress(){
        billingAddressContinue.click();
        return this;
    }

    public CheckoutPage2 setInStorePickupCheckbox(){
        inStorePickupCheckbox.click();
        return this;
    }

    public CheckoutPage2 goToPaymentMethod(){
        shippingAddressContinue.click();
        return this;
    }

    public CheckoutPage2 selectCreditCard(){
        creditCardPaymentMethod.click();
        return this;
    }

    public CheckoutPage2 goToPaymentInformation(){
        paymentMethodContinue.click();
        return this;
    }

    public CheckoutPage2 selectCreditCardType(String cardType){
        Select creditCardTypeSelect = new Select(creditCardType);
        creditCardTypeSelect.selectByValue(cardType);
        return this;
    }

    public CheckoutPage2 enterCardholderName(String cardholder){
        cardholderName.sendKeys(cardholder);
        return this;
    }

    public CheckoutPage2 enterCardNumber(String cardNo){
        cardNumber.sendKeys(cardNo);
        return this;
    }

    public CheckoutPage2 selectExpirationMonth(String month){
        Select selectMonth = new Select(expirationMonth);
        selectMonth.selectByValue(month);
        return this;
    }

    public CheckoutPage2 selectExpirationYear(String year){
        Select selectYear = new Select(expirationYear);
        selectYear.selectByValue(year);
        return this;
    }

    public CheckoutPage2 enterCardCode(String code){
        cardCode.sendKeys(code);
        return this;
    }

    public CheckoutPage2 goToConfirmOrder(){
        paymentInformationContinue.click();
        return this;
    }

    public String getSubtotal(){
        return subTotalPrice.getText();
    }

    public String getShippingCost(){
        return shippingCost.getText();
    }

    public String getTotalPrice(){
        return totalPrice.getText();
    }

    public CheckoutPage2 orderConfirmation(){
       confirmOrder.click();
        return this;
    }

    public String orderSuccess(){
        return orderSuccessMessage.getText();
    }

    public MainPage2 orderCompletedContinue() {
        checkoutCompletedContinue.click();
        return new MainPage2(driver);
    }
}
