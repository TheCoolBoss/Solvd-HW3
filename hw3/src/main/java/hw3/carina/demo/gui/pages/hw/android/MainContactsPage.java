package hw3.carina.demo.gui.pages.hw.android;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import hw3.carina.demo.gui.components.hw.android.ContactComponent;
import hw3.carina.demo.gui.components.hw.android.BottomNavBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class MainContactsPage extends AbstractPage
{
    @FindBy(id = "com.google.android.contacts:id/bottom_nav")
    private BottomNavBar navBar;

    @FindBy(id = "com.google.android.contacts:id/floating_action_button")
    private ExtendedWebElement newContactButton;

    @FindBy(xpath = ".//android.view.ViewGroup[@clickable='true']")
    private List<ContactComponent> contactList;

    @FindBy(id = "com.google.android.contacts:id/open_search_bar")
    private ExtendedWebElement searchBar;

    @FindBy(xpath = ".//android.widget.ImageView[@content-desc='More options']")
    private ExtendedWebElement selectContactsButton;

    public MainContactsPage(WebDriver wd)
    {
        super(wd);
    }

    @Override
    public boolean isPageOpened()
    {
        return newContactButton.isElementPresent();
    }

    public EnterContactInfoPage clickNewContact()
    {
        newContactButton.click();
        return new EnterContactInfoPage(getDriver());
    }

    public int getContactListSize()
    {
        return contactList.size();
    }

    public boolean isNamePresent(String name)
    {
        for (ContactComponent cc: contactList)
        {
            if (cc.getName().equals(name))
            {
                return true;
            }
        }

        return false;
    }

    public ContactInfoPage clickContactName(String name)
    {
        for (ContactComponent contactComponent : contactList)
        {
            if (contactComponent.getName().equals(name))
            {
                return contactComponent.clickContact();
            }
        }

        return null;
    }

    public void searchName(String name)
    {
        searchBar.type(name);
    }

    public SelectPage clickSelectOptions()
    {
        selectContactsButton.click();
        return new SelectPage(getDriver());
    }
}
