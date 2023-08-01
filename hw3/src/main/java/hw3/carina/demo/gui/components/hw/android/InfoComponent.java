package hw3.carina.demo.gui.components.hw.android;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class InfoComponent extends AbstractUIObject
{
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.google.android.contacts:id/header']")
    private ExtendedWebElement infoVal;

    @FindBy(xpath = ".//android.widget.RelativeLayout[@clickable='true']")
    private ExtendedWebElement commType;

    public InfoComponent(WebDriver wd, SearchContext sc)
    {
        super(wd, sc);
    }

    public String getVal()
    {
        return infoVal.getText();
    }

    public String getType()
    {
        return commType.getAttribute("content-desc");
    }
}
