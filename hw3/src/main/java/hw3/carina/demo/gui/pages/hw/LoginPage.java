package hw3.carina.demo.gui.pages.hw;

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
    }
    
    public void login(String[] credentials)
    {
        usernameInput.type(credentials[0]);
        passInput.type(credentials[1]);
        confirmButton.click();
    }
}
