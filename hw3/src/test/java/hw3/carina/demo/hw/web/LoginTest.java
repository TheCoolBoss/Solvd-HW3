package hw3.carina.demo.hw.web;

import com.zebrunner.carina.utils.config.Configuration;
import hw3.carina.demo.gui.services.LoginService;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.zebrunner.carina.core.IAbstractTest;
import hw3.carina.demo.gui.pages.hw.LoginPage;

public class LoginTest implements IAbstractTest
{
    private static final LoginService LOGIN_SERVICE = new LoginService();
    @Test()
    public void testFailedLogin()
    {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        loginPage.login(LoginService.dataProvider()[1][0].toString(), LoginService.dataProvider()[1][1].toString());
        Assert.assertEquals(loginPage.getCurrentUrl(), Configuration.getRequired("DEMO.base"));
    }

    @Test()
    public void testGoodLogin()
    {
        LOGIN_SERVICE.doGoodLogin();
    }
}
