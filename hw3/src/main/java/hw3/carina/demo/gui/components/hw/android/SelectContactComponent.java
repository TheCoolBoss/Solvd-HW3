package hw3.carina.demo.gui.components.hw.android;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SelectContactComponent extends AbstractUIObject
{
    @FindBy(xpath = ".//android.widget.TextView[@resource-id='com.google.android.contacts:id/cliv_name_textview']")
    private ExtendedWebElement contactName;

    public SelectContactComponent(WebDriver wd, SearchContext sc)
    {
        super(wd, sc);
    }

    public String getName()
    {
        return contactName.getText();
    }

    public void clickContact()
    {
        contactName.click();
    }
}
