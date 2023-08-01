package hw3.carina.demo.gui.pages.hw.web;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutInfoPage extends AbstractPage
{
    @FindBy(id = "first-name")
    private ExtendedWebElement firstNameInput;

    @FindBy(id = "last-name")
    private ExtendedWebElement lastNameInput;

    @FindBy(id = "postal-code")
    private ExtendedWebElement zipInput;

    @FindBy(xpath = "//*[@id='checkout_info_container']/div/form/div[2]/input")
    private ExtendedWebElement continueButton;

    public CheckoutInfoPage(WebDriver wd)
    {
        super(wd);
        setPageURL("checkout-step-one.html");
    }

    public void fillOutForm(String firstName, String lastName, String zip)
    {
        firstNameInput.type(firstName);
        lastNameInput.type(lastName);
        zipInput.type(zip);
    }

    public PaymentPage clickPaymentButton()
    {
        continueButton.click();
        return new PaymentPage(getDriver());
    }
}
