package hw3.carina.demo.hw.android;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import hw3.carina.demo.gui.pages.hw.android.*;
import hw3.carina.demo.gui.services.InsertService;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactTest implements IAbstractTest
{
    private static final InsertService INSERT_SERVICE = new InsertService();
    @Test(dataProvider = "allInfo")
    public void makeNewContact(String[] info)
    {
        MainContactsPage homePage = INSERT_SERVICE.getPastPopup();
        int initialCount = homePage.getContactListSize();

        INSERT_SERVICE.insertContact(info);
        int newCount = homePage.getContactListSize();

        Assert.assertTrue(homePage.isPageOpened());
        Assert.assertEquals(newCount, initialCount + 1,  "Size has not been increased by 1");
    }

    @Test(dataProvider = "allInfo")
    public void selectContactByName(String[] info)
    {
        String firstName = info[0];
        String lastName = info[1];
        String combinedName = firstName + " " + lastName;

        MainContactsPage homePage = INSERT_SERVICE.getPastPopup();
        Assert.assertTrue(homePage.isPageOpened(), "Contacts page is not opened");

        SelectPage selectPage = homePage.clickSelectOptions();
        selectPage.clickSelectChoice();

        Assert.assertTrue(selectPage.checkSelectionByName(combinedName), "Wrong count selected");
    }

    @Test(dataProvider = "editEmailInfo")
    public void editContactEmailByName(String[] info)
    {
        String firstName = info[0];
        String lastName = info[1];
        String newEmail = info[2];
        String combinedName = firstName + " " + lastName;

        MainContactsPage homePage = INSERT_SERVICE.getPastPopup();
        Assert.assertTrue(homePage.isPageOpened(), "Contacts page is not opened");

        Assert.assertTrue(homePage.isNamePresent(combinedName), "Name is not present.");
        ContactInfoPage infoPage = homePage.clickContactName(combinedName);

        EnterContactInfoPage updatedContact = infoPage.clickEdit();
        Assert.assertTrue(updatedContact.isPageOpened(), "Not on new contact input page");

        updatedContact.enterEmail(newEmail);
        ContactInfoPage updatedInfoPage = updatedContact.clickSaveButton();

        Assert.assertTrue(updatedInfoPage.verifyEmail(newEmail), "Email is not assigned");
    }

    @Test(dataProvider = "allInfo")
    public void deleteContact(String[] info)
    {
        String firstName = info[0];
        String lastName = info[1];
        String combinedName = firstName + " " + lastName;

        MainContactsPage homePage = INSERT_SERVICE.getPastPopup();
        INSERT_SERVICE.insertContact(info);
        Assert.assertTrue(homePage.isPageOpened(), "Contacts page is not opened");
        Assert.assertTrue(homePage.isNamePresent(combinedName), "Name already not in contacts");

        int initialCount = homePage.getContactListSize();
        ContactInfoPage infoPage = homePage.clickContactName(combinedName);
        infoPage.delete();
        int newCount = homePage.getContactListSize();

        Assert.assertEquals(newCount, initialCount - 1,  "Size has not been reduced by 1");
    }

    @DataProvider(name = "allInfo")
    public Object[][] allInfoProvider()
    {
        return new Object[][]
                {
                    {
                        R.TESTDATA.get("firstName"),
                        R.TESTDATA.get("lastName"),
                        R.TESTDATA.get("company"),
                        R.TESTDATA.get("phone"), R.TESTDATA.get("email")
                    }
                };
    }

    @DataProvider(name = "editEmailInfo")
    public Object[][] editEmailProvider()
    {
        return new Object[][]
                {
                        {
                                R.TESTDATA.get("firstName"),
                                R.TESTDATA.get("lastName"),
                                R.TESTDATA.get("updatedEmail")
                        }
                };
    }
}
