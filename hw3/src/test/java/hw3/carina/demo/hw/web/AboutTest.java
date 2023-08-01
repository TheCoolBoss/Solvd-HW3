package hw3.carina.demo.hw.web;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import hw3.carina.demo.gui.pages.hw.AboutPage;
import hw3.carina.demo.gui.pages.hw.HomePage;
import hw3.carina.demo.gui.services.LoginService;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AboutTest implements IAbstractTest
{
    private static final LoginService LOGIN_SERVICE = new LoginService();

    @Test(dataProvider = "goodLoginProvider")
    public void goToAboutLink(String[] credentials)
    {
        LOGIN_SERVICE.login(credentials);

        HomePage homePage = new HomePage(getDriver());
        AboutPage aboutPage = homePage.openAboutPage();
        Assert.assertTrue(aboutPage.isPageOpened(), "Not at about (company) page");
    }

    @DataProvider(name = "goodLoginProvider")
    public static Object[][] provideGoodLogin()
    {
        return new Object[][]
                {
                        {R.TESTDATA.get("good_user"), R.TESTDATA.get("good_pass")}
                };
    }
}
