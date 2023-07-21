package hw3.carina.demo.gui.pages.hw.abstracts;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import hw3.carina.demo.gui.components.hw.CartButton;
import org.openqa.selenium.WebDriver;

public abstract class ItemPage extends AbstractPage
{
    public ItemPage(WebDriver wd)
    {
        super(wd);
    }

    public abstract ExtendedWebElement getQuantityIcon();

    public abstract String getCost();

    public abstract CartButton getCartButton();
}
