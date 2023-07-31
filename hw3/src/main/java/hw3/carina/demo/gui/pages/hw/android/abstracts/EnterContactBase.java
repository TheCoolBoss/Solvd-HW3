package hw3.carina.demo.gui.pages.hw.android.abstracts;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class EnterContactBase extends AbstractPage
{
    public EnterContactBase(WebDriver wd)
    {
        super(wd);
    }

    public abstract ContactInfoBase clickSaveButton();

    public abstract void enterFirstName(String name);

    public abstract void enterLastName(String name);

    public abstract void enterCompany(String co);

    public abstract void enterPhone(String phone);

    public abstract void enterEmail(String email);

    public abstract String getPhoneVal();
}
