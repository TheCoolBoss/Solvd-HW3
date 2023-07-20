package hw3.carina.demo.gui.pages.hw;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class HomePage extends AbstractPage
{
    @FindBy(xpath = "//*[@id='shopping_cart_container']/a/svg")
    private ExtendedWebElement cartButton;

    public HomePage(WebDriver wd)
    {
        super(wd);
    }

    public ExtendedWebElement getCartButton()
    {
        return cartButton;
    }
}
