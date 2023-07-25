package hw3.carina.demo.gui.pages.hw;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import hw3.carina.demo.gui.components.hw.BurgerMenu;
import hw3.carina.demo.gui.components.hw.ProductComponent;
import hw3.carina.demo.gui.components.hw.TopNavMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends AbstractPage
{
    @FindBy(xpath = ".//*[@id='header_container']/div[1]")
    private TopNavMenu topNavMenu;

    @FindBy(id = "item_4_title_link")
    private ExtendedWebElement backpackLink;

    @FindBy(id = "item_0_title_link")
    private ExtendedWebElement lightLink;

    @FindBy(className = "inventory_item")
    private List<ProductComponent> products;

    public HomePage(WebDriver wd)
    {
        super(wd);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageURL("inventory.html");
    }

    public AboutPage openAboutPage()
    {
        BurgerMenu burgerMenu = topNavMenu.openBurgerMenu();
        return burgerMenu.goToAboutLink();
    }

    public ItemPage openProductPage(String productName)
    {
        for (ProductComponent pc: products)
        {
            if (pc.getTitleText().equals(productName))
            {
                return pc.clickTitle();
            }
        }

        return null;
    }

    public CartPage openCartPage()
    {
        return topNavMenu.openCartPage();
    }
}
