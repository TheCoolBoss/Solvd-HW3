package hw3.carina.demo.gui.pages.hw.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import hw3.carina.demo.gui.components.hw.android.SelectContactComponent;
import hw3.carina.demo.gui.pages.hw.android.abstracts.SelectBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SelectBase.class)
public class SelectPage extends SelectBase implements IMobileUtils
{
    @FindBy(xpath = ".//android.widget.ImageButton[@content-desc='close']")
    private ExtendedWebElement closeButton;

    @FindBy(xpath = ".//android.widget.TextView[@text='Select']")
    private ExtendedWebElement selectChoiceButton;

    @FindBy(xpath = ".//android.widget.TextView[@text='Select all']")
    private ExtendedWebElement selectAllButton;

    @FindBy(xpath = ".//ig[@checked='false']")
    List<SelectContactComponent> allContactsList;

    @FindBy(xpath = ".//ig[@checked='true']")
    List<ExtendedWebElement> selectedList;

    public SelectPage(WebDriver wd)
    {
        super(wd);
        setUiLoadedMarker(selectChoiceButton);
    }

    public void clickClose()
    {
        closeButton.click();
    }

    public void clickSelectChoice()
    {
        selectChoiceButton.click();
    }

    public int selectContactByName(String name)
    {
        //Avoid clicking on anything in the favorites
        //Doing so selects the corresponding contact in the "alphabetized" list
        //This deselects it, disrupting the total count
        boolean inFaves = true;
        int faveCount = 0;
        int ret = 0;

        for (SelectContactComponent scc: allContactsList)
        {
            //Swipe in case list is off screen
            swipe(scc.getContactLetterImage());

            if (inFaves)
            {
                //First non favorite
                //The description is just the first initial, which is length 1
                if (scc.getLetterDesc().length() == 1)
                {
                    inFaves = false;
                }

                else
                {
                    faveCount++;
                }
            }

            //Click on non favorites here
            if (scc.getName().equals(name) && !inFaves)
            {
                scc.clickContact();
                ret++;
            }
        }

        return ret + faveCount;
    }

    public boolean checkSelectionByName(String name)
    {
        int count = selectContactByName(name);

        //Intent is to refresh the selected list since it will be of length 0 on startup
        this.refresh();

        return selectedList.size() == count;
    }
}
