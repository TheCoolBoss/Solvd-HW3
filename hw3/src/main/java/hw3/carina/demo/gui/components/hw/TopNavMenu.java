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
    @FindBy(xpath = "//*[@id='shopping_cart_container']/a")
    private ExtendedWebElement cartButton;

    @FindBy(id = "react-burger-menu-btn")
    private ExtendedWebElement burgerButton;

    public TopNavMenu(WebDriver wd, SearchContext sc)
    {
        super(wd, sc);
    }

    public CartPage openCartPage()
    {
        assertElementPresent(cartButton);
        cartButton.click();
        return new CartPage(getDriver());
    }

    public void openBurgerMenu()
    {
        assertElementPresent(burgerButton);
        burgerButton.click(30, ExpectedConditions.elementToBeClickable(burgerButton.getBy()));
    }
}
