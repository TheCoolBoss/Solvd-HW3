package hw3.carina.demo.hw;

import com.zebrunner.carina.core.IAbstractTest;
import hw3.carina.demo.gui.pages.hw.HomePage;
import hw3.carina.demo.gui.pages.hw.LoginPage;
import hw3.carina.demo.hw.services.LoginService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class PurchaseTest implements IAbstractTest
{
    private static final WebDriver DRIVER = new ChromeDriver();
    @Test()
    public void buyItem()
    {
        LoginPage loginPage = new LoginPage(DRIVER);
        LoginService.doGoodLogin(loginPage);
        HomePage homePage = loginPage.initPage(DRIVER, HomePage.class);
        homePage.getCartButton().click();
    }

    @AfterTest
    public void closeDriver()
    {
        DRIVER.close();
    }
}
