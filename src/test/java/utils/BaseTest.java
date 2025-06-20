package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter; 

public class BaseTest {
    protected WebDriver driver;
    protected static ExtentReports extent;
    protected static ExtentTest test;

    @BeforeSuite
    public void startReport() {
    	ExtentSparkReporter reporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
    }

    @BeforeMethod
    public void setup() {
    	//System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
    	System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--headless"); // ✅ Run without UI
    	options.addArguments("--no-sandbox");
    	options.addArguments("--disable-dev-shm-usage");
    	options.addArguments("--disable-gpu"); // Good for remote Linux
    	options.addArguments("--remote-allow-origins=*");
    	options.addArguments("--window-size=1920,1080");
    	
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @AfterSuite
    public void flushReports() {
        extent.flush();
    }
}
