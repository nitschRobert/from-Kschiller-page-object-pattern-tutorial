package pages.DemoWebShop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.PageObject;

public class CheckoutPage extends PageObject {

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


    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void goToShippingAddress(){
        billingAddressContinue.click();
    }

    public void setInStorePickupCheckbox(){
        inStorePickupCheckbox.click();
    }

    public void goToPaymentMethod(){
        shippingAddressContinue.click();
    }

    public void selectCreditCard(){
        creditCardPaymentMethod.click();
    }

    public void goToPaymentInformation(){
        paymentMethodContinue.click();
    }

    public void selectCreditCardType(String cardType){
        Select creditCardTypeSelect = new Select(creditCardType);
        creditCardTypeSelect.selectByValue(cardType);
    }

    public void enterCardholderName(String cardholder){
        cardholderName.sendKeys(cardholder);
    }

    public void enterCardNumber(String cardNo){
        cardNumber.sendKeys(cardNo);
    }

    public void selectExpirationMonth(String month){
        Select selectMonth = new Select(expirationMonth);
        selectMonth.selectByValue(month);
    }

    public void selectExpirationYear(String year){
        Select selectYear = new Select(expirationYear);
        selectYear.selectByValue(year);
    }

    public void enterCardCode(String code){
        cardCode.sendKeys(code);
    }

    public void goToConfirmOrder(){
        paymentInformationContinue.click();
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

    public void orderConfirmation(){
       confirmOrder.click();
    }
}
