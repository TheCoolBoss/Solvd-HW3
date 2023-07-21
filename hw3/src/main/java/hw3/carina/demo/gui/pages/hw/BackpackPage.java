package hw3.carina.demo.gui.pages.hw;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import hw3.carina.demo.gui.components.hw.CartButton;
import hw3.carina.demo.gui.pages.hw.abstracts.ItemPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class BackpackPage extends ItemPage
{
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private ExtendedWebElement addButton;

    @FindBy(className = "shopping_cart_badge")
    private ExtendedWebElement quantityIcon;

    @FindBy(xpath = "//*[@id='inventory_item_container']/div/div/div[2]/div[3]/text()[2]")
    private ExtendedWebElement costLabel;

    @FindBy(xpath = "//*[@id='shopping_cart_container']/a")
    private CartButton cartButton;

    public BackpackPage(WebDriver wd)
    {
        super(wd);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageURL("inventory-item.html?id=4");
    }

    public void addBackpack()
    {
        addButton.click();
    }

    public ExtendedWebElement getQuantityIcon()
    {
        return quantityIcon;
    }

    public ExtendedWebElement getCost()
    {
        return costLabel;
    }

    public CartButton getCartButton()
    {
        return cartButton;
    }
}
