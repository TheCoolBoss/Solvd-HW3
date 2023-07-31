package hw3.carina.demo.gui.pages.hw.android.abstracts;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import hw3.carina.demo.gui.pages.hw.android.EnterContactInfoPage;
import org.openqa.selenium.WebDriver;

public abstract class ContactInfoBase extends AbstractPage
{
    public ContactInfoBase(WebDriver wd)
    {
        super(wd);
    }

    public abstract void clickGoBack();

    public abstract void delete();

    public abstract EnterContactBase clickEdit();

    public abstract boolean verifyEmail(String email);
}
