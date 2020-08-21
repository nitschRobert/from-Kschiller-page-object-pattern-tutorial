
import org.junit.Test;
import pages.AutomationpracticeMainPage;
import static org.junit.Assert.assertTrue;

public class FindCreditCardIcon extends FunctionalTest {

    @Test
    public void findCreditCardIcon() {
        driver.get("http://automationpractice.com/index.php");

        AutomationpracticeMainPage automationpracticeMainPage = new AutomationpracticeMainPage(driver);
        assertTrue(automationpracticeMainPage.isDisplayed());
    }
}
