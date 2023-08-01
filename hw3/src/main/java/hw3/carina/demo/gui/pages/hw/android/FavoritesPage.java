package hw3.carina.demo.gui.pages.hw.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import hw3.carina.demo.gui.components.hw.android.BottomNavBar;
import hw3.carina.demo.gui.components.hw.android.FaveContactComponent;
import hw3.carina.demo.gui.pages.hw.android.abstracts.FavesBase;
import hw3.carina.demo.gui.pages.hw.android.abstracts.MainContactsBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = FavesBase.class)
public class FavoritesPage extends FavesBase
{
    @FindBy(id = "com.google.android.contacts:id/bottom_nav")
    private BottomNavBar navBar;

    @FindBy(xpath = ".//android.view.ViewGroup[@clickable='true']")
    private List<FaveContactComponent> faveList;

    public FavoritesPage(WebDriver wd)
    {
        super(wd);
    }

    public boolean isNamePresent(String name)
    {
        for (FaveContactComponent cc: faveList)
        {
            if (cc.getName().equals(name))
            {
                return true;
            }
        }

        return false;
    }
}
