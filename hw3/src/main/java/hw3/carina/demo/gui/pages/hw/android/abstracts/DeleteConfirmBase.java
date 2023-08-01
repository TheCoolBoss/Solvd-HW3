package hw3.carina.demo.gui.pages.hw.android.abstracts;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class DeleteConfirmBase extends AbstractPage
{
    public DeleteConfirmBase(WebDriver wd)
    {
        super(wd);
    }

    public abstract void clickDelete();
}
