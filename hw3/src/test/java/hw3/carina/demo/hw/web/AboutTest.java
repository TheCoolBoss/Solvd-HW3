package hw3.carina.demo.hw.web;

import com.zebrunner.carina.core.IAbstractTest;
import hw3.carina.demo.gui.pages.hw.AboutPage;
import hw3.carina.demo.gui.pages.hw.HomePage;
import hw3.carina.demo.hw.services.LoginService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AboutTest implements IAbstractTest
{
    private static final LoginService LOGIN_SERVICE = new LoginService();

    @Test()
    public void goToAboutLink()
    {
        HomePage homePage = LOGIN_SERVICE.doGoodLogin();

        AboutPage aboutPage = homePage.openAboutPage();
        Assert.assertTrue(aboutPage.isPageOpened(), "Not at about (company) page");
    }
}
