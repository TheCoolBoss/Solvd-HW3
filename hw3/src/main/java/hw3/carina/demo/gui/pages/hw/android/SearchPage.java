package hw3.carina.demo.gui.pages.hw.android;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import hw3.carina.demo.gui.components.hw.android.ContactSearchComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class SearchPage extends AbstractPage
{
    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Open navigation drawer']")
    private ExtendedWebElement goBackButton;

    @FindBy(xpath = ".//android.view.ViewGroup[@clickable='true']")
    List<ContactSearchComponent> searchResults;


    public SearchPage(WebDriver wd)
    {
        super(wd);
    }

    @Override
    public boolean isPageOpened()
    {
        return goBackButton.isElementPresent();
    }

    public void clickGoBack()
    {
        goBackButton.click();
    }
}
