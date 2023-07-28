package hw3.carina.demo.hw.android;

import com.zebrunner.carina.core.IAbstractTest;
import hw3.carina.demo.gui.pages.hw.android.MainContactsPage;
import hw3.carina.demo.gui.pages.hw.android.EnterContactInfoPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputTest implements IAbstractTest
{
    private static final Pattern NUM_REGEX = Pattern.compile("[0-9- ]+");
    private static final Pattern EMPTY_REGEX = Pattern.compile("");

    //Ignore these tests for now
    //Intent is test feature where inputting a letter instead does its corresponding number on the keypad
    //i.e. "a" turns into 2
    //Send keys currently does actual vals instead of converting
    @Test()
    public void testPhoneLetterInput()
    {
        MainContactsPage homePage = new MainContactsPage(getDriver());
        Assert.assertTrue(homePage.isPageOpened(), "Contacts page is not opened");

        EnterContactInfoPage newContact = homePage.clickNewContact();
        Assert.assertTrue(newContact.isPageOpened(), "Not on new contact input page");

        newContact.enterPhone("abc");
        //Matcher matcher = NUM_REGEX.matcher(newContact.getPhoneVal());
        //Assert.assertTrue(matcher.find(), "Phone num has characters that are not numbers");
        newContact.clickSaveButton();
    }

    @Test
    public void testInvalidPhoneInput()
    {
        MainContactsPage homePage = new MainContactsPage(getDriver());
        Assert.assertTrue(homePage.isPageOpened(), "Contacts page is not opened");

        EnterContactInfoPage newContact = homePage.clickNewContact();
        Assert.assertTrue(newContact.isPageOpened(), "Not on new contact input page");

        newContact.enterPhone("[]{}");
        Matcher matcher = EMPTY_REGEX.matcher(newContact.getPhoneVal());
        Assert.assertTrue(matcher.find(), "Phone num is not empty.");
    }
}
