package hw3.carina.demo.hw.web;

import com.zebrunner.carina.utils.R;
import hw3.carina.demo.gui.pages.hw.web.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.zebrunner.carina.core.IAbstractTest;
import hw3.carina.demo.gui.pages.hw.web.LoginPage;

public class LoginTest implements IAbstractTest
{
    @Test()
    public void testFailedLogin()
    {
        String user = R.TESTDATA.get("bad_user");
        String pass = R.TESTDATA.get("bad_pass");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Not on login page");

        loginPage.sendLoginInfo(user, pass);
        Assert.assertTrue(loginPage.isPageOpened(), "Not on login page");
    }

    @Test()
    public void testGoodLogin()
    {
        String user = R.TESTDATA.get("good_user");
        String pass = R.TESTDATA.get("good_pass");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Not on login page");

        HomePage homePage = loginPage.loginToHome(user, pass);
        Assert.assertTrue(homePage.isPageOpened(), "Not at home page");
    }
}
