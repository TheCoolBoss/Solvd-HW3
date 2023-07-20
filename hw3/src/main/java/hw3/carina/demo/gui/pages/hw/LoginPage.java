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


    @Override
    public void open()
    {
        super.open();
    }
    
    public ExtendedWebElement getUsernameInput() 
    {
        return usernameInput;
    }


    public ExtendedWebElement getPassInput() 
    {
        return passInput;
    }


    public ExtendedWebElement getConfirmButton() 
    {
        return confirmButton;
    }
}
