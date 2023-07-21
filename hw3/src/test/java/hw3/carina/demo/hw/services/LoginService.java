package hw3.carina.demo.hw.services;

import hw3.carina.demo.gui.pages.hw.HomePage;
import hw3.carina.demo.gui.pages.hw.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class LoginService
{
    private static final SoftAssert SA = new SoftAssert();
    private static void loginToPage(LoginPage page, String user, String pass, String errorMsg)
    {
        page.open();
        page.getUsernameInput().type(user);
        page.getPassInput().type(pass);
        page.getConfirmButton().click();
    }

    public static HomePage doGoodLogin(WebDriver wd, LoginPage page)
    {
        loginToPage(page,
                "standard_user",
                "secret_sauce",
                "Not at main page. :(");
        HomePage homePage = new HomePage(wd);
        SA.assertTrue(homePage.isPageOpened(), "Not at home page");
        return homePage;
    }

    public static void doBadLogin(LoginPage page)
    {
        LoginService.loginToPage(page,
                "Doriyah!",
                "Ganondorf",
                "Not at main page. :(");
    }
}
