package hw3.carina.demo.gui.components.hw;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import hw3.carina.demo.gui.pages.hw.AboutPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class BurgerMenu extends AbstractUIObject
{
    @FindBy(id = "about_sidebar_link")
    private ExtendedWebElement aboutLink;

    @FindBy(id = "logout_sidebar_link")
    private ExtendedWebElement logoutLink;

    public BurgerMenu(WebDriver wd, SearchContext sc)
    {
        super(wd, sc);
    }

    public AboutPage goToAboutLink()
    {
        aboutLink.click();
        return new AboutPage(getDriver());
    }
}
