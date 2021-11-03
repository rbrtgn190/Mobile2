import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.*;
import com.hpe.leanft.selenium.By;
import com.hpe.leanft.selenium.ByEach;

import java.net.URL;
import java.util.HashMap;
import java.util.regex.Pattern;



public class AppWeb  {

    public AppWeb() {
    //Change this constructor to private if you supply your own public constructor
    }

    private static WebDriver driver;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        // Created object of DesiredCapabilities class.
        DesiredCapabilities cap = new DesiredCapabilities();

        //cap.setCapability("deviceName","Nexus");
        cap.setCapability("platformName", "Android");
        //cap.setCapability("appPackage", "com.scores365");
        //cap.setCapability("appActivity", "com.scores365.ui.Splash");
        cap.setCapability("browserName", "chrome");


        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
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
    }
}