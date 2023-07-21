package hw3.carina.demo.gui.pages.hw;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import hw3.carina.demo.gui.components.hw.CartButton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends AbstractPage
{
    @FindBy(xpath = "//*[@id='menu_button_container']/div/div[1]/div")
    private ExtendedWebElement burgerMenu;

    @FindBy(id = "react-burger-menu-btn")
    private ExtendedWebElement burgerButton;

    @FindBy(id = "about_sidebar_link")
    private ExtendedWebElement aboutLink;

    @FindBy(id = "logout_sidebar_link")
    private ExtendedWebElement logoutLink;

    @FindBy(xpath = "//*[@id='shopping_cart_container']/a")
    private CartButton cartButton;

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
        burgerButton.click(30, ExpectedConditions.elementToBeClickable(burgerButton.getBy()));
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
        return cartButton.openCartPage();
    }
}
