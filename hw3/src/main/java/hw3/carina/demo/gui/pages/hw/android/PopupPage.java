package hw3.carina.demo.gui.pages.hw.android;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PopupPage extends AbstractPage
{
    @FindBy(id = "android:id/button2")
    private ExtendedWebElement skipButton;

    public PopupPage(WebDriver wd)
    {
        super(wd);
    }

    public MainContactsPage clickSkip()
    {
        skipButton.click();
        return new MainContactsPage(getDriver());
    }
}
