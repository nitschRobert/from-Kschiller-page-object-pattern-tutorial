package BasicTestClass;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * <strong>FunctionalTest</strong> handles setup and teardown of WebDriver.
 * @author Kim Schiller
 */
public class BasicTestClass {

	public static WebDriver driver;
	public static WebDriverWait wait;
	
	@BeforeClass
	public static void setUp(){
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		wait = new WebDriverWait(driver,6);
	}

	@After
	public void cleanUp(){
		driver.manage().deleteAllCookies();
	}
	
	@AfterClass
	public static void tearDown(){
		driver.close();
	}
}
