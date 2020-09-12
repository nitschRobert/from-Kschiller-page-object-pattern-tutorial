import org.junit.Test;
import pages.PracticeMainPage;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CreditCardIconTest extends FunctionalTest {

    @Test
    public void LocateElements() {
        driver.get("http://automationpractice.com/index.php");

        PracticeMainPage automationPracticeMainPage = new PracticeMainPage(driver);

        assertTrue(automationPracticeMainPage.creditCardIconIsVisible());
        assertTrue(automationPracticeMainPage.searchButtonIsVisible());

        assertEquals("My Store", driver.getTitle());

        automationPracticeMainPage.goToWomenTab();
    }
}
