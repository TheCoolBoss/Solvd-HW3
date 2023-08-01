package hw3.carina.demo.gui.pages.hw.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import hw3.carina.demo.gui.components.hw.android.ContactComponent;
import hw3.carina.demo.gui.components.hw.android.BottomNavBar;
import hw3.carina.demo.gui.pages.hw.android.abstracts.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MainContactsBase.class)
public class MainContactsPage extends MainContactsBase
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
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(newContactButton);
    }

    public EnterContactBase clickNewContact()
    {
        newContactButton.click();
        return initPage(getDriver(), EnterContactBase.class);
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

    public ContactInfoBase clickContactName(String name)
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

    public SelectBase clickSelectOptions()
    {
        selectContactsButton.click();
        return initPage(getDriver(), SelectBase.class);
    }

    public FavesBase clickFavesButton()
    {
        return navBar.clickFaves();
    }
}
