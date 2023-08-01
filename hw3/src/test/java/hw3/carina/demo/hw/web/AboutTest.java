package hw3.carina.demo.hw.web;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import hw3.carina.demo.gui.pages.hw.web.AboutPage;
import hw3.carina.demo.gui.pages.hw.web.HomePage;
import hw3.carina.demo.gui.pages.hw.web.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AboutTest implements IAbstractTest
{
    @Test(dataProvider = "goodLoginProvider")
    public void goToAboutLink(String user, String pass)
    {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        HomePage homePage = loginPage.loginToHome(user, pass);

        AboutPage aboutPage = homePage.openAboutPage();
        Assert.assertTrue(aboutPage.isPageOpened(), "Not at about (company) page");
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
}
