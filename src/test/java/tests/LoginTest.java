package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import utils.BaseTest;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() throws InterruptedException {
        test = extent.createTest("Login Test");
        driver.get("https://practicetestautomation.com/practice-test-login/");
        Thread.sleep(5000);
        LoginPage lp = new LoginPage(driver);
        lp.login("student", "Password123");
        test.pass("Login completed");
    }
}
