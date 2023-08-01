package hw3.carina.demo.gui.pages.hw.web;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import hw3.carina.demo.gui.components.hw.web.TopNavMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class ItemPage extends AbstractPage
{
    @FindBy(xpath = ".//*[@id='header_container']/div[1]")
    private TopNavMenu topNavMenu;

    @FindBys({@FindBy(className = "btn_primary"), @FindBy(className = "btn_inventory")})
    private ExtendedWebElement addButton;

    @FindBys({@FindBy(className = "btn_secondary"), @FindBy(className = "btn_inventory")})
    private ExtendedWebElement removeButton;

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

    public void clickRemoveButton()
    {
        removeButton.click();
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

    public boolean isQuantityIconPresent()
    {
        return quantityIcon.isElementPresent(5);
    }
}
