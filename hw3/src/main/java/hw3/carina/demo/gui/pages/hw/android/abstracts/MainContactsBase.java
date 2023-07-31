package hw3.carina.demo.gui.pages.hw.android.abstracts;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class MainContactsBase extends AbstractPage
{
    public MainContactsBase(WebDriver wd)
    {
        super(wd);
    }

    public abstract EnterContactBase clickNewContact();

    public abstract int getContactListSize();

    public abstract boolean isNamePresent(String name);

    public abstract ContactInfoBase clickContactName(String name);

    public abstract SelectBase clickSelectOptions();

    public abstract FavesBase clickFavesButton();
}
