package hw3.carina.demo.gui.pages.hw.web;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends AbstractPage
{
    @FindBy(css = ".cart_button")
    private ExtendedWebElement payButton;

    @FindBy(xpath = "//*[@id='checkout_summary_container']/div/div[2]/div[6]")
    private ExtendedWebElement total;

    public PaymentPage(WebDriver wd)
    {
        super(wd);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageURL("checkout-step-two.html");
    }

    public PurchaseDonePage submitPayment()
    {
        payButton.click();
        return new PurchaseDonePage(getDriver());
    }

    public String getTotal()
    {
        return total.getText();
    }
}
