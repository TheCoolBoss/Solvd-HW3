package hw3.carina.demo.gui.pages.hw.web;

import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class PurchaseDonePage extends AbstractPage
{
    public PurchaseDonePage(WebDriver wd)
    {
        super(wd);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageURL("checkout-complete.html");
    }
}
