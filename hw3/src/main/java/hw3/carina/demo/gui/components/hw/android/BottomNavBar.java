package hw3.carina.demo.gui.components.hw.android;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class BottomNavBar extends AbstractUIObject
{
    @FindBy(id = "com.google.android.dialer:id/tab_speed_dial")
    private ExtendedWebElement highlightsButton;

    @FindBy(id = "com.google.android.dialer:id/tab_call_history")
    private ExtendedWebElement fixManageButton;

    @FindBy(id = "com.google.android.dialer:id/tab_contacts")
    private ExtendedWebElement contactsButton;

    public BottomNavBar(WebDriver wd, SearchContext sc)
    {
        super(wd, sc);
    }


    public void selectHighlights()
    {
        highlightsButton.click();
    }

    public void selectFixManage()
    {
        fixManageButton.click();
    }

    public void selectContacts()
    {
        contactsButton.click();
    }
}
