package hw3.carina.demo.gui.pages.hw.android;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class DeleteConfirmationPage extends AbstractPage
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
