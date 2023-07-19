package hw3.carina.demo.gui.pages.hw.common;

import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class LoginPageBase extends AbstractPage
{
    public LoginPageBase(WebDriver wd)
    {
        super(wd);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    @Override
    public void open()
    {
        super.open();
    }
}
