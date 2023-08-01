package hw3.carina.demo.gui.pages.hw.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import hw3.carina.demo.gui.pages.hw.android.abstracts.DeleteConfirmBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = DeleteConfirmBase.class)
public class DeleteConfirmationPage extends DeleteConfirmBase
{
    @FindBy(id = "android:id/button1")
    private ExtendedWebElement confirmDeleteButton;

    public DeleteConfirmationPage(WebDriver wd)
    {
        super(wd);
    }

    public void clickDelete()
    {
        confirmDeleteButton.click();
    }
}
