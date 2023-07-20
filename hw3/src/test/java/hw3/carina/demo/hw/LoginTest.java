package hw3.carina.demo.hw;

import hw3.carina.demo.hw.services.LoginService;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.config.Configuration;
import hw3.carina.demo.gui.pages.hw.LoginPage;

public class LoginTest implements IAbstractTest
{
    @Test()
    public void testFailedLogin()
    {
        LoginPage loginPage = new LoginPage(new ChromeDriver());
        LoginService.loginToPage(loginPage,
                "Doriyah!",
                "Ganondorf",
                Configuration.getRequired("DEMO.base"),
                "Not at home page. :(");
    }

    @Test()
    public void testGoodLogin()
    {
        LoginPage loginPage = new LoginPage(new ChromeDriver());
        LoginService.loginToPage(loginPage,
                "standard_user",
                "secret_sauce",
                Configuration.getRequired("home_url"),
                "Not at main page. :(");
    }
}
