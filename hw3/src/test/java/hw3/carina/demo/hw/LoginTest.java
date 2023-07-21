package hw3.carina.demo.hw;

import hw3.carina.demo.hw.services.LoginService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.zebrunner.carina.core.IAbstractTest;
import hw3.carina.demo.gui.pages.hw.LoginPage;

public class LoginTest implements IAbstractTest
{
    private static final WebDriver DRIVER = new ChromeDriver();

    @Test()
    public void testFailedLogin()
    {
        LoginPage loginPage = new LoginPage(DRIVER);
        LoginService.doBadLogin(loginPage);
    }

    @Test()
    public void testGoodLogin()
    {
        LoginPage loginPage = new LoginPage(DRIVER);
        LoginService.doGoodLogin(DRIVER, loginPage);
    }

    @AfterTest
    public void closeDriver()
    {
        DRIVER.close();
    }
}
