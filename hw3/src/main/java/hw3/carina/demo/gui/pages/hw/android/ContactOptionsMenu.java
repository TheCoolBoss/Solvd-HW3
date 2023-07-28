package hw3.carina.demo.gui.pages.hw.android;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ContactOptionsMenu extends AbstractPage
{
    @FindBy(xpath = "//android.widget.TextView[@text='Delete']")
    private ExtendedWebElement deleteButton;

    public ContactOptionsMenu(WebDriver wd)
    {
        super(wd);
    }

    public DeleteConfirmationPage clickDelete()
    {
        deleteButton.click();
        return new DeleteConfirmationPage(getDriver());
    }
}
