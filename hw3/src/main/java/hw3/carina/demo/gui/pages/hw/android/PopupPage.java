package hw3.carina.demo.gui.pages.hw.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import hw3.carina.demo.gui.pages.hw.android.abstracts.MainContactsBase;
import hw3.carina.demo.gui.pages.hw.android.abstracts.PopupBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PopupBase.class)
public class PopupPage extends PopupBase
{
    @FindBy(id = "android:id/button2")
    private ExtendedWebElement skipButton;

    public PopupPage(WebDriver wd)
    {
        super(wd);
    }

    public MainContactsBase clickSkip()
    {
        skipButton.click();
        return initPage(getDriver(), MainContactsBase.class);
    }
}
