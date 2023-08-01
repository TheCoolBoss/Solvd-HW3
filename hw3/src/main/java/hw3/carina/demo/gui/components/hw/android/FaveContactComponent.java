package hw3.carina.demo.gui.components.hw.android;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FaveContactComponent extends AbstractUIObject
{
    @FindBy(id = "com.google.android.contacts:id/name")
    private ExtendedWebElement contactName;

    public FaveContactComponent(WebDriver wd, SearchContext sc)
    {
        super(wd, sc);
    }

    public String getName()
    {
        return contactName.getText();
    }
}
