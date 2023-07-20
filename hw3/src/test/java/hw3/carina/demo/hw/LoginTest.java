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
    private static final LoginPage LOGIN_PAGE = new LoginPage(DRIVER);

    @Test()
    public void testFailedLogin()
    {
        LoginService.doBadLogin(LOGIN_PAGE);
    }

    @Test()
    public void testGoodLogin()
    {
        LoginService.doGoodLogin(LOGIN_PAGE);
    }

    @AfterTest
    public void closeDriver()
    {
        DRIVER.close();
    }
}
