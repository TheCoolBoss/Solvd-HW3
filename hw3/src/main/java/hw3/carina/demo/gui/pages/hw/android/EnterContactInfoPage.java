package hw3.carina.demo.gui.pages.hw.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import hw3.carina.demo.gui.pages.hw.android.abstracts.ContactInfoBase;
import hw3.carina.demo.gui.pages.hw.android.abstracts.EnterContactBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = EnterContactBase.class)
public class EnterContactInfoPage extends EnterContactBase implements IMobileUtils
{
    //Not too concerned with dropdowns for the moment
    @FindBy(xpath = "//android.widget.EditText[@hint='First name']")
    private ExtendedWebElement firstNameInput;

    @FindBy(xpath = "//android.widget.EditText[@hint='Last name']")
    private ExtendedWebElement lastNameInput;

    @FindBy(xpath = "//android.widget.EditText[@hint='Company']")
    private ExtendedWebElement companyInput;

    @FindBy(xpath = "//android.widget.EditText[@hint='Phone']")
    private ExtendedWebElement phoneInput;

    @FindBy(xpath = "//android.widget.EditText[@hint='Email']")
    private ExtendedWebElement emailInput;

    @FindBy(id = "com.google.android.contacts:id/toolbar_button")
    private ExtendedWebElement saveButton;

    public EnterContactInfoPage(WebDriver wd)
    {
        super(wd);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(saveButton);
    }

    public ContactInfoBase clickSaveButton()
    {
        saveButton.click();
        return initPage(getDriver(), ContactInfoBase.class);
    }

    public void enterFirstName(String name)
    {
        firstNameInput.type(name);
    }

    public void enterLastName(String name)
    {
        lastNameInput.type(name);
    }

    public void enterCompany(String co)
    {
        companyInput.type(co);
    }

    public void enterPhone(String phone)
    {
        phoneInput.type(phone);
    }

    public void enterEmail(String email)
    {
        swipe(emailInput);
        emailInput.type(email);
    }

    public String getPhoneVal()
    {
        return phoneInput.getText();
    }
}
