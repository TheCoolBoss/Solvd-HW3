package hw3.carina.demo.hw;

import com.zebrunner.carina.core.IAbstractTest;
import hw3.carina.demo.gui.pages.hw.AboutPage;
import hw3.carina.demo.gui.pages.hw.HomePage;
import hw3.carina.demo.gui.pages.hw.LoginPage;
import hw3.carina.demo.hw.services.LoginService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AboutTest implements IAbstractTest
{
    private static final WebDriver DRIVER = new ChromeDriver();
    private static final SoftAssert SA = new SoftAssert();

    @Test()
    public void goToAboutLink()
    {
        LoginPage loginPage = new LoginPage(DRIVER);
        HomePage homePage = LoginService.doGoodLogin(DRIVER, loginPage);
        SA.assertTrue(homePage.isPageOpened(), "Not at home page");

        AboutPage aboutPage = homePage.openAboutPage(DRIVER);
        SA.assertTrue(aboutPage.isPageOpened(), "Not at about (company) page");
    }

    @AfterTest
    public void closeDriver()
    {
        DRIVER.close();
    }
}
