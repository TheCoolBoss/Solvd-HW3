package hw3.carina.demo.gui.pages.hw.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import hw3.carina.demo.gui.components.hw.android.ContactToolbar;
import hw3.carina.demo.gui.components.hw.android.InfoComponent;
import hw3.carina.demo.gui.pages.hw.android.abstracts.ContactInfoBase;
import hw3.carina.demo.gui.pages.hw.android.abstracts.ContactOptionsBase;
import hw3.carina.demo.gui.pages.hw.android.abstracts.DeleteConfirmBase;
import hw3.carina.demo.gui.pages.hw.android.abstracts.EnterContactBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ContactInfoBase.class)
public class ContactInfoPage extends ContactInfoBase
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
        ContactOptionsBase menu = toolbar.openOptionsMenu();
        DeleteConfirmBase deletePage = menu.clickDelete();
        deletePage.clickDelete();
    }

    public EnterContactBase clickEdit()
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
