package hw3.carina.demo.hw.services;

import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.IDriverPool;
import hw3.carina.demo.gui.pages.hw.HomePage;
import hw3.carina.demo.gui.pages.hw.LoginPage;
import org.testng.Assert;

import static com.zebrunner.agent.core.webdriver.RemoteWebDriverFactory.getDriver;

public class LoginService implements IDriverPool
{
    public HomePage doGoodLogin()
    {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        loginPage.login(R.TESTDATA.get("good_user"), R.TESTDATA.get("good_pass"));
        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.isPageOpened(), "Not at home page");
        return homePage;
    }
}
