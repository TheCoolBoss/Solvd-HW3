package hw3.carina.demo.hw.android;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import hw3.carina.demo.gui.pages.hw.android.abstracts.*;
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
        MainContactsBase homePage = INSERT_SERVICE.getPastPopup();
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

        MainContactsBase homePage = INSERT_SERVICE.getPastPopup();
        Assert.assertTrue(homePage.isPageOpened(), "Contacts page is not opened");
        INSERT_SERVICE.insertContact(info);

        SelectBase selectPage = homePage.clickSelectOptions();
        selectPage.clickSelectChoice();

        Assert.assertTrue(selectPage.checkSelectionByName(combinedName), "Wrong count selected");
    }

    @Test(dataProvider = "allInfo")
    public void editContactEmailByName(String[] info)
    {
        String firstName = info[0];
        String lastName = info[1];
        String newEmail = R.TESTDATA.get("updatedEmail");
        String combinedName = firstName + " " + lastName;

        MainContactsBase homePage = INSERT_SERVICE.getPastPopup();
        Assert.assertTrue(homePage.isPageOpened(), "Contacts page is not opened");
        INSERT_SERVICE.insertContact(info);

        Assert.assertTrue(homePage.isNamePresent(combinedName), "Name is not present.");
        ContactInfoBase infoPage = homePage.clickContactName(combinedName);

        EnterContactBase updatedContact = infoPage.clickEdit();
        Assert.assertTrue(updatedContact.isPageOpened(), "Not on new contact input page");

        updatedContact.enterEmail(newEmail);
        ContactInfoBase updatedInfoPage = updatedContact.clickSaveButton();

        Assert.assertTrue(updatedInfoPage.verifyEmail(newEmail), "Email is not assigned");
    }

    @Test(dataProvider = "allInfo")
    public void deleteContact(String[] info)
    {
        String firstName = info[0];
        String lastName = info[1];
        String combinedName = firstName + " " + lastName;

        MainContactsBase homePage = INSERT_SERVICE.getPastPopup();
        INSERT_SERVICE.insertContact(info);
        Assert.assertTrue(homePage.isPageOpened(), "Contacts page is not opened");
        Assert.assertTrue(homePage.isNamePresent(combinedName), "Name already not in contacts");

        int initialCount = homePage.getContactListSize();
        ContactInfoBase infoPage = homePage.clickContactName(combinedName);
        infoPage.delete();
        int newCount = homePage.getContactListSize();

        Assert.assertEquals(newCount, initialCount - 1,  "Size has not been reduced by 1");
    }

    @Test(dataProvider = "allInfo")
    public void faveContact(String[] info)
    {
        String firstName = info[0];
        String lastName = info[1];
        String combinedName = firstName + " " + lastName;

        MainContactsBase homePage = INSERT_SERVICE.getPastPopup();
        Assert.assertTrue(homePage.isPageOpened(), "Contacts page is not opened");
        INSERT_SERVICE.insertContact(info);

        ContactInfoBase contactInfo = homePage.clickContactName(combinedName);
        contactInfo.clickFave();
        contactInfo.clickGoBack();
        FavesBase faves = homePage.clickFavesButton();
        Assert.assertTrue(faves.isNamePresent(combinedName));
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
                            R.TESTDATA.get("phone"),
                            R.TESTDATA.get("email")
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
