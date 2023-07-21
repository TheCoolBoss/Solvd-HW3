package hw3.carina.demo.gui.pages.hw;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import hw3.carina.demo.gui.components.hw.TopNavMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage
{
    @FindBy(xpath = "//*[@id='header_container']/div[1]")
    private TopNavMenu topNavMenu;

    @FindBy(id = "about_sidebar_link")
    private ExtendedWebElement aboutLink;

    @FindBy(id = "logout_sidebar_link")
    private ExtendedWebElement logoutLink;

    @FindBy(id = "item_4_title_link")
    private ExtendedWebElement backpackLink;

    @FindBy(id = "item_0_title_link")
    private ExtendedWebElement lightLink;


    public HomePage(WebDriver wd)
    {
        super(wd);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageURL("inventory.html");
    }

    public AboutPage openAboutPage()
    {
        topNavMenu.openBurgerMenu();
        aboutLink.click();
        return new AboutPage(getDriver());
    }

    public BackpackPage openBackpackPage()
    {
        backpackLink.click();
        return new BackpackPage(getDriver());
    }

    public LightPage openLightPage()
    {
        lightLink.click();
        return new LightPage(getDriver());
    }

    public CartPage openCartPage()
    {
        return topNavMenu.openCartPage();
    }
}
