package hw3.carina.demo.gui.pages.hw.android.abstracts;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SelectBase extends AbstractPage
{
    public SelectBase(WebDriver wd)
    {
        super(wd);
    }

    public abstract void clickClose();

    public abstract void clickSelectChoice();

    public abstract int selectContactByName(String name);

    public abstract boolean checkSelectionByName(String name);
}
