package hw3.carina.demo.hw.services;

import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import hw3.carina.demo.gui.pages.hw.HomePage;
import hw3.carina.demo.gui.pages.hw.LoginPage;
import org.testng.asserts.SoftAssert;

public class LoginService
{
    private static SoftAssert sa = new SoftAssert();
    private static void loginToPage(LoginPage page, String user, String pass, String expectedUrl, String errorMsg)
    {
        page.open();
        page.getUsernameInput().type(user);
        page.getPassInput().type(pass);
        page.getConfirmButton().click();
        sa.assertEquals(page.getCurrentUrl(), expectedUrl, errorMsg);
    }

    public static void doGoodLogin(LoginPage page)
    {
        loginToPage(page,
                "standard_user",
                "secret_sauce",
                Configuration.getRequired("home_url"),
                "Not at main page. :(");
    }

    public static void doBadLogin(LoginPage page)
    {
        LoginService.loginToPage(page,
                "Doriyah!",
                "Ganondorf",
                Configuration.getRequired("home_url"),
                "Not at main page. :(");
    }
}
