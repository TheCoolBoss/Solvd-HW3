package hw3.carina.demo.hw.services;

import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.IDriverPool;
import hw3.carina.demo.gui.pages.hw.HomePage;
import hw3.carina.demo.gui.pages.hw.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class LoginService implements IDriverPool
{
    public HomePage doGoodLogin()
    {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        loginPage.login(dataProvider()[0][0].toString(), dataProvider()[0][1].toString());
        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.isPageOpened(), "Not at home page");
        return homePage;
    }

    @DataProvider(name = "credentialProvider")
    public static Object[][] dataProvider()
    {
        return new Object[][]
                {
                    {R.TESTDATA.get("good_user"), R.TESTDATA.get("good_pass")},
                    {R.TESTDATA.get("bad_user"), R.TESTDATA.get("bad_pass")}
                };
    }
}
