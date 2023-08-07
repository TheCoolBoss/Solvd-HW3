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
    @Test(dataProvider = "credentials")
    public void testLogin(boolean isGood, String user, String pass)
    {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Not on login page");

        if (!isGood)
        {
            loginPage.sendLoginInfo(user, pass);
            Assert.assertTrue(loginPage.isPageOpened(), "Login page should be current page due to failed credentials");
        }

        else
        {
            HomePage homePage = loginPage.loginToHome(user, pass);
            Assert.assertTrue(homePage.isPageOpened(), "Not at home page");
        }
    }

    @DataProvider(name = "credentials")
    public static Object[][] credentialProvider()
    {
        return new Object[][]
                {
                        {
                                false,
                                R.TESTDATA.get("bad_user"),
                                R.TESTDATA.get("bad_pass")
                        },
                        {
                                true,
                                R.TESTDATA.get("good_user"),
                                R.TESTDATA.get("good_pass")
                        }
                };
    }
}
