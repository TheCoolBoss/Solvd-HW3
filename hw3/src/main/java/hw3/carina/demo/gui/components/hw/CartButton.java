package hw3.carina.demo.gui.components.hw;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import hw3.carina.demo.gui.pages.hw.CartPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartButton extends AbstractUIObject
{
    @FindBy(xpath = "//*[@id='shopping_cart_container']/a")
    private ExtendedWebElement cartButton;

    public CartButton(WebDriver wd, SearchContext sc)
    {
        super(wd, sc);
    }

    public CartPage openCartPage()
    {
        cartButton.click();
        return new CartPage(driver);
    }
}
