package hw3.carina.demo.gui.pages.hw.android;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import hw3.carina.demo.gui.components.hw.android.ContactToolbar;
import hw3.carina.demo.gui.components.hw.android.InfoComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ContactInfoPage extends AbstractPage
{
    @FindBy(id = "com.google.android.contacts:id/toolbar")
    private ContactToolbar toolbar;

    @FindBy(xpath = ".//android.widget.RelativeLayout[@clickable='true']")
    private List<InfoComponent> infoTypes;

    public ContactInfoPage(WebDriver wd)
    {
        super(wd);
    }

    public void clickGoBack()
    {
        toolbar.clickGoBack();
    }

    public void delete()
    {
        ContactOptionsMenu menu = toolbar.openOptionsMenu();
        DeleteConfirmationPage deletePage = menu.clickDelete();
        deletePage.clickDelete();
    }

    public EnterContactInfoPage clickEdit()
    {
        return toolbar.openEditPage();
    }

    public boolean verifyEmail(String email)
    {
        for (InfoComponent ic : infoTypes)
        {
            if (ic.getType().contains("Email") && ic.getVal().equals(email))
            {
                return true;
            }
        }

        return false;
    }
}
