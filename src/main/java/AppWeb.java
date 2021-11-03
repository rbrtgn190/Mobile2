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

    // UFTM SaaS
    public static final String UFTM_SERVER = "https://demo.mobilecenter.io";
    public static final String UFTM_SERVER_USERNAME = "xxxx@microfocus.com";
    public static final String UFTM_SERVER_PASSWORD = "xxxxx";
    public static final String UFTM_UDID = "ce08171898ee74520c7e";

    // UFTM NimbusServer
/*    public static final String UFTM_SERVER = "http://nimbusserver.aos.com:8084";
    public static final String UFTM_SERVER_USERNAME = "admin@default.com";
    public static final String UFTM_SERVER_PASSWORD = "Password1";
    // "client=oauth2-WAFwAbtcj99aKpHNQIVH@microfocus.com; secret=8beMYgc4OHhTrlW8KQ0Y; tenant=999999999; url=nimbusserver.aos.com:8084;"
    public static final String UFTM_UDID = "";*/

    // Appium local
/*    public static final String UFTM_SERVER = "http://127.0.0.1:4723";
    public static final String UFTM_SERVER_USERNAME = "";
    public static final String UFTM_SERVER_PASSWORD = "";
    public static final String UFTM_UDID = "";*/


    //Device OS needs to be set to android or iOS
    public static final String DEVICE_OS = "Android";

/*    //The Following is only required if Anonymous Access disabled
    public static final String UFTM_SERVER_CLIENT_ID = "oauth2-…";
    public static final String UFTM_SERVER_CLIENT_SECRET = "ke…";
    public static final String UFTM_SERVER_TENANT_ID = "999999999";
    public static final String UFTM_SERVER_WORKSPACE_NAME = "Default workspace";*/


    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        // Created object of DesiredCapabilities class.
        DesiredCapabilities cap = new DesiredCapabilities();

        //cap.setCapability("deviceName","Nexus");
        cap.setCapability("platformName", "Android");
        cap.setCapability("udid", UFTM_UDID);
        //cap.setCapability("automationName", "UiAutomator1");
        //cap.setCapability("appPackage", "com.scores365");
        //cap.setCapability("appActivity", "com.scores365.ui.Splash");
        cap.setCapability("browserName", "chrome");
        //cap.setCapability("chromedriverUseSystemExecutable", "true");

        cap.setCapability("userName", UFTM_SERVER_USERNAME);
        cap.setCapability("password", UFTM_SERVER_PASSWORD);


        //driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver = new RemoteWebDriver(new URL(UFTM_SERVER + "/wd/hub"), cap);
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


        // /html/body/login-modal/div/div/div[3]/a[2]
        //        <div class="displayed">Username</div>

        ///*WebElement*/ createNewAccountBtn = By.xpath("/html/body/login-modal/div/div/div[3]/a[2]");
 /*       By byCreateNewAccountBtn = By.xpath("/html/body/login-modal/div/div/div[3]/a[2]");
        createNewAccountBtn = wait.until(ExpectedConditions.presenceOfElementLocated(byCreateNewAccountBtn));
        Thread.sleep(5*1000);
        Assert.assertTrue((ElementcreateNewAccountBtn.isDisplayed());*/
        //Assert.assertTrue(driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/a[2]")).isDisplayed());

 /*       // open users page - takes a while so wait until it is clickable
        userBtn = wait.until(ExpectedConditions.elementToBeClickable(org.openqa.selenium.By.xpath("/html/body/header/nav/ul/li[3]/a/a")));
        //userBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("svg#menuUser")));
        //driver.findElement(By.cssSelector("svg#menuUser"));
// or this
        userBtn = driver.findElement(By.xpath("//*[@id='menuUser']"));
        //wait.until(ExpectedConditions.elementToBeClickable(userBtn));
        userBtn.click();
*/

/*
        // createNewAccountBtn = driver.findElement(By.className("create-new-account.ng-scope"));
        // above fails. Selenium sees classNames with a space in them as a "compound selecter" and fails
        createNewAccountBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/login-modal/div/div/div[3]/a[2]")));
        Thread.sleep(1*1000); // even with the above, need to sleep a bit*/

        Thread.sleep(5*1000);
    }
}