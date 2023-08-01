package hw3.carina.demo.gui.pages.hw.web;

import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public class LoginPage extends AbstractPage
{
    @FindBy(id = "user-name")
    private ExtendedWebElement usernameInput;

    @FindBy(id = "password")
    private ExtendedWebElement passInput;

    @FindBy(id = "login-button")
    private ExtendedWebElement confirmButton;

    
    public LoginPage(WebDriver wd)
    {
        super(wd);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
        setPageURL(Configuration.getRequired("DEMO.base"));
    }
    
    public void sendLoginInfo(String user, String pass)
    {
        usernameInput.type(user);
        passInput.type(pass);
        confirmButton.click();
    }

    public HomePage loginToHome(String user, String pass)
    {
        sendLoginInfo(user, pass);
        return new HomePage(getDriver());
    }
}
