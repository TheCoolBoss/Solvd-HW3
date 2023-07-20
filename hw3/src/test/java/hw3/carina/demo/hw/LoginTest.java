package hw3.carina.demo.hw;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.config.Configuration;
import hw3.carina.demo.gui.pages.hw.LoginPage;

public class LoginTest implements IAbstractTest
{
    private SoftAssert softAssert = new SoftAssert();

    @Test()
    public void testFailedLogin()
    {
        LoginPage loginPage = new LoginPage(new ChromeDriver());
        loginPage.open();
        loginPage.getUsernameInput().type("Doriyah!");
        loginPage.getPassInput().type("Wizkick");
        loginPage.getConfirmButton().click();
        softAssert.assertEquals(loginPage.getCurrentUrl(), Configuration.getRequired("DEMO.base"));
        softAssert.assertAll();
    }

    @Test()
    public void testGoodLogin()
    {

    }
}
