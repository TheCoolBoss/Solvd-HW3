package hw3.carina.demo.hw;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.Test;
import com.zebrunner.carina.core.IAbstractTest;
import hw3.carina.demo.gui.pages.hw.LoginPage;


public class WebTest implements IAbstractTest
{
    private ChromeDriverService cds = new ChromeDriverService.Builder().usingDriverExecutable(new File("hw3/src/test/resources/chromedriver.exe")).build();

    @Test()
    public void testLogin()
    {
        LoginPage loginPageBase = new LoginPage(new ChromeDriver(cds));
        loginPageBase.open();
        loginPageBase.getUsernameInput().type("Doriyah!");
    }
}
