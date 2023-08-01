package hw3.carina.demo.gui.components.hw.android;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import hw3.carina.demo.gui.pages.hw.android.abstracts.ContactOptionsBase;
import hw3.carina.demo.gui.pages.hw.android.abstracts.EnterContactBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ContactToolbar extends AbstractUIObject implements ICustomTypePageFactory
{
    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    private ExtendedWebElement goBackButton;

    @FindBy(id = "com.google.android.contacts:id/menu_insert_or_edit")
    private ExtendedWebElement editButton;

    @FindBy(id = "com.google.android.contacts:id/menu_star")
    private ExtendedWebElement faveButton;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='More options']")
    private ExtendedWebElement moreOptionsButton;

    public ContactToolbar(WebDriver wd, SearchContext sc)
    {
        super(wd, sc);
    }

    public void clickGoBack()
    {
        goBackButton.click();
    }

    public void clickFave()
    {
        faveButton.click();
    }

    public ContactOptionsBase openOptionsMenu()
    {
        moreOptionsButton.click();
        return initPage(getDriver(), ContactOptionsBase.class);
    }

    public EnterContactBase openEditPage()
    {
        editButton.click();
        return initPage(getDriver(), EnterContactBase.class);
    }

    public ExtendedWebElement getMoreOptionsButton()
    {
        return moreOptionsButton;
    }
}
