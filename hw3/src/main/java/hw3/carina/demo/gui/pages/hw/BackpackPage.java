package hw3.carina.demo.gui.pages.hw;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import hw3.carina.demo.gui.components.hw.TopNavMenu;
import hw3.carina.demo.gui.pages.hw.abstracts.ItemPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class BackpackPage extends ItemPage
{
    @FindBy(xpath = "//*[@id='header_container']/div[1]")
    private TopNavMenu topNavMenu;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private ExtendedWebElement addButton;

    @FindBy(className = "shopping_cart_badge")
    private ExtendedWebElement quantityIcon;

    @FindBy(xpath = "//*[@id='inventory_item_container']/div/div/div[2]/div[3]")
    private ExtendedWebElement costLabel;

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

    public String getCost()
    {
        return costLabel.getText();
    }

    public CartPage openCartPage()
    {
        return topNavMenu.openCartPage();
    }
}
