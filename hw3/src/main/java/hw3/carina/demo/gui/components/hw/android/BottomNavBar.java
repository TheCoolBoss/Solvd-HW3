package hw3.carina.demo.gui.components.hw.android;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import hw3.carina.demo.gui.pages.hw.android.abstracts.FavesBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class BottomNavBar extends AbstractUIObject implements ICustomTypePageFactory
{
    @FindBy(id = "com.google.android.contacts:id/highlights")
    private ExtendedWebElement highlightsButton;

    @FindBy(id = "com.google.android.contacts:id/nav_manage")
    private ExtendedWebElement fixManageButton;

    @FindBy(id = "com.google.android.contacts:id/contacts")
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

    public FavesBase clickFaves()
    {
        highlightsButton.click();
        return initPage(getDriver(), FavesBase.class);
    }
}
