package hw3.carina.demo.gui.services;

import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.IDriverPool;
import hw3.carina.demo.gui.pages.hw.HomePage;
import hw3.carina.demo.gui.pages.hw.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class LoginService implements IDriverPool
{
    public void login(String[] credentials)
    {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        loginPage.login(credentials);
    }
}
