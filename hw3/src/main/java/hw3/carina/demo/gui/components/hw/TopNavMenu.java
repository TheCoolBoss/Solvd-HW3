package hw3.carina.demo.gui.components.hw;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import hw3.carina.demo.gui.pages.hw.CartPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TopNavMenu extends AbstractUIObject
{
    @FindBy(xpath = ".//*[@id='shopping_cart_container']/a")
    private ExtendedWebElement cartButton;

    @FindBy(id = "react-burger-menu-btn")
    private ExtendedWebElement burgerButton;

    private final BurgerMenu BURGER_MENU;


    public TopNavMenu(WebDriver wd, SearchContext sc)
    {
        super(wd, sc);
        BURGER_MENU = new BurgerMenu(wd, sc);
    }

    public CartPage openCartPage()
    {
        cartButton.click();
        return new CartPage(getDriver());
    }

    public BurgerMenu openBurgerMenu()
    {
        burgerButton.click(30, ExpectedConditions.elementToBeClickable(burgerButton.getBy()));
        return BURGER_MENU;
    }
}
