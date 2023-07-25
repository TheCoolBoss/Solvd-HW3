package hw3.carina.demo.gui.components.hw;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import hw3.carina.demo.gui.pages.hw.CartPage;
import hw3.carina.demo.gui.pages.hw.ItemPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductComponent extends AbstractUIObject
{
    @FindBy(className = "inventory_item_name")
    private ExtendedWebElement titleLink;

    @FindBy(className = "btn_inventory")
    private ExtendedWebElement addButton;

    @FindBy(xpath = ".//*[@id='inventory_container']/div/div[2]/div[2]/div[2]/div")
    private ExtendedWebElement costLabel;

    public ProductComponent(WebDriver wd, SearchContext sc)
    {
        super(wd, sc);
    }

    //Not concerned with operations on other elements right now
    public ItemPage clickTitle()
    {
        titleLink.click();
        return new ItemPage(getDriver());
    }

    public String getTitleText()
    {
        return titleLink.getText();
    }
}
