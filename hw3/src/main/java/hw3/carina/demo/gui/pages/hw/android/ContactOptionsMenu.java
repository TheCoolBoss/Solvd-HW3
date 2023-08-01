package hw3.carina.demo.gui.pages.hw.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import hw3.carina.demo.gui.pages.hw.android.abstracts.ContactOptionsBase;
import hw3.carina.demo.gui.pages.hw.android.abstracts.DeleteConfirmBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ContactOptionsBase.class)
public class ContactOptionsMenu extends ContactOptionsBase
{
    @FindBy(xpath = "//android.widget.TextView[@text='Delete']")
    private ExtendedWebElement deleteButton;

    public ContactOptionsMenu(WebDriver wd)
    {
        super(wd);
    }

    public DeleteConfirmBase clickDelete()
    {
        deleteButton.click();
        return initPage(getDriver(), DeleteConfirmBase.class);
    }
}
