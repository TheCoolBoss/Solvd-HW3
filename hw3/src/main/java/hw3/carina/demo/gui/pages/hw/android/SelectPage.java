package hw3.carina.demo.gui.pages.hw.android;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import hw3.carina.demo.gui.components.hw.android.SelectContactComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class SelectPage extends AbstractPage
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
        int ret = 0;
        for (SelectContactComponent scc: allContactsList)
        {
            if (scc.getName().equals(name))
            {
                scc.clickContact();
                ret++;
            }
        }

        return ret;
    }

    public boolean checkSelectionByName(String name)
    {
        int count = selectContactByName(name);

        //Intent is to refresh the selected list since it will be of length 0 on startup
        this.refresh();

        return selectedList.size() == count;
    }
}
