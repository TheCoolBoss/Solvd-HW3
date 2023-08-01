package hw3.carina.demo.hw.web;

import com.zebrunner.carina.utils.R;
import hw3.carina.demo.gui.pages.hw.web.HomePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.zebrunner.carina.core.IAbstractTest;
import hw3.carina.demo.gui.pages.hw.web.LoginPage;

public class LoginTest implements IAbstractTest
{
    @Test(dataProvider = "badLoginProvider")
    public void testFailedLogin(String user, String pass)
    {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        loginPage.sendLoginInfo(user, pass);
        Assert.assertTrue(loginPage.isPageOpened(), "Not on login page");
    }

    @Test(dataProvider = "goodLoginProvider")
    public void testGoodLogin(String user, String pass)
    {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        HomePage homePage = loginPage.loginToHome(user, pass);
        Assert.assertTrue(homePage.isPageOpened(), "Not at home page");
    }

    @DataProvider(name = "goodLoginProvider")
    public static Object[][] provideGoodLogin()
    {
        return new Object[][]
                {
                        {R.TESTDATA.get("good_user")},
                        {R.TESTDATA.get("good_pass")}
                };
    }

    @DataProvider(name = "badLoginProvider")
    public static Object[][] provideBadLogin()
    {
        return new Object[][]
                {
                        {R.TESTDATA.get("bad_user")},
                        {R.TESTDATA.get("bad_pass")}
                };
    }
}
