import static org.junit.Assert.*;

import org.junit.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.*;
import com.hpe.leanft.selenium.ByEach;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;



public class AppWeb  {

    public AppWeb() {
    //Change this constructor to private if you supply your own public constructor
    }

//    private static WebDriver driver;
    private static WebDriverWait wait;
/*    private static AndroidDriver AWebDriver = null;  //Android Driver
    private static IOSDriver iOSWebDriver = null;	//IOS Driver*/
    private static AppiumDriver driver;

    //Declaring elements for tests
    //Elements for registration test
//    private WebElement userBtn;
//    private WebElement createNewAccountBtn;


    public static final String PLATFORM_NAME = "Android";
    public static final String BROWSER_NAME = "chrome";

/*    public static final String PLATFORM_NAME = "iOS";
    public static final String BROWSER_NAME = "Safari";*/


/*    // UFTM SaaS
    public static final String UFTM_SERVER = "https://demo.mobilecenter.io";
    public static final String UFTM_SERVER_USERNAME = "jeanmatthieu.guerin@microfocus.com";
    public static final String UFTM_SERVER_PASSWORD = "xxxx";
    public static final String UFTM_UDID = "ce08171898ee74520c7e";*/

    // UFTM CAAS
/*    public static final String UFTM_SERVER = "https://uftm-caas.saas.microfocus.com";
    public static final String UFTM_SERVER_USERNAME = "jeanmatthieu.guerin@microfocus.com";
    public static final String UFTM_SERVER_PASSWORD = "Welc0me";
    // "client=oauth2-WAFwAbtcj99aKpHNQIVH@microfocus.com; secret=8beMYgc4OHhTrlW8KQ0Y; tenant=999999999; url=nimbusserver.aos.com:8084;"
    public static final String UFTM_UDID = "";*/

    // UFTM NimbusServer
    public static final String UFTM_SERVER = "http://nimbusserver.aos.com:8084";
    public static final String UFTM_SERVER_USERNAME = "admin@default.com";
    public static final String UFTM_SERVER_PASSWORD = "Password1";
    // "client=oauth2-WAFwAbtcj99aKpHNQIVH@microfocus.com; secret=8beMYgc4OHhTrlW8KQ0Y; tenant=999999999; url=nimbusserver.aos.com:8084;"
    public static final String UFTM_UDID = "";

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
        cap.setCapability("platformName", PLATFORM_NAME);
        cap.setCapability("udid", UFTM_UDID);
        //cap.setCapability("automationName", "UiAutomator1");
        //cap.setCapability("appPackage", "com.scores365");
        //cap.setCapability("appActivity", "com.scores365.ui.Splash");
        cap.setCapability("browserName", BROWSER_NAME);
        //cap.setCapability("chromedriverUseSystemExecutable", "true");

        cap.setCapability("userName", UFTM_SERVER_USERNAME);
        cap.setCapability("password", UFTM_SERVER_PASSWORD);


        //driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
/*
        driver = new RemoteWebDriver(new URL(UFTM_SERVER + "/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
*/
        if(DEVICE_OS.equalsIgnoreCase("android"))
        {
            // Set Device
/*            caps.setCapability("platformName", "Android");
            //caps.setCapability("deviceName", "Pixel 2");
            caps.setCapability("automationName", "android");

            // App Capabilities
            caps.setCapability("appPackage", "com.Advantage.aShopping");
            caps.setCapability("appActivity", "com.Advantage.aShopping.SplashActivity");*/

            // Create Web Driver
            driver = new AndroidDriver(new URL(UFTM_SERVER + "/wd/hub"), cap);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            wait = new WebDriverWait(driver, 10);

            //Create a session to the UFTM server

            System.out.println("UFTM session was successfully created [Android Device]");
            //AWebDriver.quit();

        }


        if(DEVICE_OS.equalsIgnoreCase("iOS"))
        {

            // Set Device
/*
            caps.setCapability("platformName", "iOS");
            caps.setCapability("deviceName", "iPhone 7");

            // App Capabilities
            caps.setCapability("bundleId", "com.hpe.iShopping");
*/

            // Create Web Driver
            driver = new IOSDriver(new URL(UFTM_SERVER + "/wd/hub"), cap);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            wait = new WebDriverWait(driver, 10);


            System.out.println("UFTM session was successfully created [iOS Device]");
            //iOSWebDriver.quit();

        }
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("Quit driver");
        driver.quit();
/*        if(DEVICE_OS.equalsIgnoreCase("android"))
        {
            AWebDriver.quit();
        }
        if(DEVICE_OS.equalsIgnoreCase("iOS"))
        {
            iOSWebDriver.quit();
        }*/
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


        // Retrieve Appium logs
        HashMap<String, String> encoding= new HashMap<String, String>();
        encoding.put("encoding", "UTF-8");
        String logFileContents = (String)  driver.executeScript("mc-wd: downloadLogs", encoding);
        System.out.println(logFileContents);
    }
}