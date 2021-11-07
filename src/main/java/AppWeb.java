import static org.junit.Assert.*;

import org.junit.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.*;
import com.hpe.leanft.selenium.ByEach;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;



public class AppWeb  {

    public AppWeb() {
    //Change this constructor to private if you supply your own public constructor
    }

    private static WebDriver driver;
    private static WebDriverWait wait;
    //Declaring elements for tests
    //Elements for registration test
    private WebElement userBtn;
    private WebElement createNewAccountBtn;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        // Created object of DesiredCapabilities class.
        DesiredCapabilities cap = new DesiredCapabilities();

        //cap.setCapability("deviceName","Nexus");
        cap.setCapability("platformName", "Android");
        //cap.setCapability("automationName", "UiAutomator1");
        //cap.setCapability("appPackage", "com.scores365");
        //cap.setCapability("appActivity", "com.scores365.ui.Splash");
        cap.setCapability("browserName", "chrome");


        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        driver.quit();
    }

    @Before
    public void setUp() throws Exception {


    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() throws Exception {
        driver.navigate().to("http://advantageonlineshopping.com");
        Thread.sleep(10*1000);


        driver.findElement(By.xpath("//div[@id='mobile-btn']")).click();
        Thread.sleep(1*1000);
        driver.findElement(By.xpath("//*[@id='mobileUser']")).click();

        Thread.sleep(5*1000);
    }
}