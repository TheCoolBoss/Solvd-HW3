package hw3.carina.demo.hw.web;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import hw3.carina.demo.gui.pages.hw.web.AboutPage;
import hw3.carina.demo.gui.pages.hw.web.HomePage;
import hw3.carina.demo.gui.pages.hw.web.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AboutTest implements IAbstractTest
{
    @Test()
    public void goToAboutLink()
    {
        String user = R.TESTDATA.get("good_user");
        String pass = R.TESTDATA.get("good_pass");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Not on login page");

        HomePage homePage = loginPage.loginToHome(user, pass);
        Assert.assertTrue(homePage.isPageOpened(), "Not at home page");

        AboutPage aboutPage = homePage.openAboutPage();
        Assert.assertTrue(aboutPage.isPageOpened(), "Not at about (company) page");
    }
}
