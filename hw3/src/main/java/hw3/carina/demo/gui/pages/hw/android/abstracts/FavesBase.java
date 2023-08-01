package hw3.carina.demo.gui.pages.hw.android.abstracts;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class FavesBase extends AbstractPage
{
    public FavesBase(WebDriver wd)
    {
        super(wd);
    }

    public abstract boolean isNamePresent(String name);
}
