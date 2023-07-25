package hw3.carina.demo.gui.pages.hw;

import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class AboutPage extends AbstractPage
{
    public AboutPage(WebDriver wd)
    {
        super(wd);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageAbsoluteURL("https://saucelabs.com/");
    }
}
