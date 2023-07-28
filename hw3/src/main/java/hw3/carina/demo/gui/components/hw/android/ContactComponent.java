package hw3.carina.demo.gui.components.hw.android;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import hw3.carina.demo.gui.pages.hw.android.ContactInfoPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ContactComponent extends AbstractUIObject
{
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.google.android.contacts:id/cliv_name_textview']")
    private ExtendedWebElement contactName;

    public ContactComponent(WebDriver wd, SearchContext sc)
    {
        super(wd, sc);
    }

    public String getName()
    {
        return contactName.getText();
    }

    public ContactInfoPage clickContact()
    {
        contactName.click();
        return new ContactInfoPage(getDriver());
    }
}
