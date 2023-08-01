package hw3.carina.demo.gui.pages.hw;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import hw3.carina.demo.gui.components.hw.TopNavMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends AbstractPage
{
    @FindBy(xpath = ".//*[@id='header_container']/div[1]")
    private TopNavMenu topNavMenu;

    @FindBy(className = "btn_inventory")
    private ExtendedWebElement addButton;

    @FindBy(xpath = ".//*[@id='inventory_item_container']/div/div/div[2]/div[3]")
    private ExtendedWebElement costLabel;

    @FindBy(className = "shopping_cart_badge")
    private ExtendedWebElement quantityIcon;

    public ItemPage(WebDriver wd)
    {
        super(wd);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(addButton);
    }

    public void clickAddButton()
    {
        addButton.click();
    }

    public String getCost()
    {
        return costLabel.getText();
    }

    public ExtendedWebElement getQuantityIcon()
    {
        return quantityIcon;
    }

    public CartPage clickCartButton()
    {
        return topNavMenu.openCartPage();
    }
}
