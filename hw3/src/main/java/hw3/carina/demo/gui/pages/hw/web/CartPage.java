package hw3.carina.demo.gui.pages.hw.web;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage
{
    @FindBy(id = "checkout")
    private ExtendedWebElement checkoutButton;

    public CartPage(WebDriver wd)
    {
        super(wd);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageURL("cart.html");
    }

    public CheckoutInfoPage clickCheckoutButton()
    {
        checkoutButton.click();
        return new CheckoutInfoPage(getDriver());
    }
}
