package hw3.carina.demo.hw.web;

import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import hw3.carina.demo.gui.pages.hw.HomePage;
import hw3.carina.demo.gui.services.LoginService;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.zebrunner.carina.core.IAbstractTest;
import hw3.carina.demo.gui.pages.hw.LoginPage;

public class LoginTest implements IAbstractTest
{
    private static final LoginService LOGIN_SERVICE = new LoginService();
    @Test(dataProvider = "badLoginProvider")
    public void testFailedLogin(String[] credentials)
    {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        loginPage.login(credentials);
        Assert.assertEquals(loginPage.getCurrentUrl(), Configuration.getRequired("DEMO.base"));
    }

    @Test(dataProvider = "goodLoginProvider")
    public void testGoodLogin(String[] credentials)
    {
        LOGIN_SERVICE.login(credentials);
        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.isPageOpened(), "Not at home page");
    }

    @DataProvider(name = "goodLoginProvider")
    public static Object[][] provideGoodLogin()
    {
        return new Object[][]
                {
                        {R.TESTDATA.get("good_user"), R.TESTDATA.get("good_pass")}
                };
    }

    @DataProvider(name = "badLoginProvider")
    public static Object[][] provideBadLogin()
    {
        return new Object[][]
                {
                        {R.TESTDATA.get("bad_user"), R.TESTDATA.get("bad_pass")}
                };
    }
}
