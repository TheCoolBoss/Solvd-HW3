package hw3.carina.demo.hw.services;

import com.zebrunner.carina.utils.config.Configuration;
import hw3.carina.demo.gui.pages.hw.LoginPage;
import org.testng.asserts.SoftAssert;

public class LoginService
{
    private static SoftAssert sa = new SoftAssert();
    public static void loginToPage(LoginPage page, String user, String pass, String expectedUrl, String errorMsg)
    {
        page.open();
        page.getUsernameInput().type(user);
        page.getPassInput().type(pass);
        page.getConfirmButton().click();
        sa.assertEquals(page.getCurrentUrl(), expectedUrl, errorMsg);
    }
}
