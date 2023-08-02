package hw3.carina.demo.hw.android;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.dataprovider.IAbstractDataProvider;
import com.zebrunner.carina.dataprovider.annotations.XlsDataSourceParameters;
import com.zebrunner.carina.utils.R;
import hw3.carina.demo.gui.pages.hw.android.abstracts.*;
import hw3.carina.demo.gui.services.InsertService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactTest implements IAbstractTest, IAbstractDataProvider
{
    private static final InsertService INSERT_SERVICE = new InsertService();

    @Test(dataProvider = "DataProvider")
    @XlsDataSourceParameters(path = "data_source/solvdTest.xlsx", sheet = "data", dsArgs = "FirstName,LastName,Company,Phone,Email")
    public void makeNewContact(String firstName, String lastName, String company, String phone, String email)
    {
        MainContactsBase homePage = INSERT_SERVICE.getPastPopup();
        Assert.assertTrue(homePage.isPageOpened(), "Contacts page is not opened");
        int initialCount = homePage.getContactListSize();

        INSERT_SERVICE.insertContact(firstName, lastName, company, phone, email);
        Assert.assertTrue(homePage.isPageOpened(), "Contacts page is not opened");
        int newCount = homePage.getContactListSize();

        Assert.assertEquals(newCount, initialCount + 1,  "Size has not been increased by 1");
    }

    @Test(dataProvider = "DataProvider")
    @XlsDataSourceParameters(path = "data_source/solvdTest.xlsx", sheet = "data", dsArgs = "FirstName,LastName,Company,Phone,Email")
    public void selectContactByName(String firstName, String lastName, String company, String phone, String email)
    {
        String combinedName = firstName + " " + lastName;

        MainContactsBase homePage = INSERT_SERVICE.getPastPopup();
        Assert.assertTrue(homePage.isPageOpened(), "Contacts page is not opened");
        INSERT_SERVICE.insertContact(firstName, lastName, company, phone, email);
        Assert.assertTrue(homePage.isPageOpened(), "Contacts page is not opened");

        SelectBase selectPage = homePage.clickSelectOptions();
        Assert.assertTrue(selectPage.isPageOpened(), "Not at selection page");
        selectPage.clickSelectChoice();

        Assert.assertTrue(selectPage.checkSelectionByName(combinedName), "Wrong count selected");
    }

    @Test(dataProvider = "DataProvider")
    @XlsDataSourceParameters(path = "data_source/solvdTest.xlsx", sheet = "data", dsArgs = "FirstName,LastName,Company,Phone,Email")
    public void editContactEmailByName(String firstName, String lastName, String company, String phone, String email)
    {
        String newEmail = R.TESTDATA.get("updatedEmail");
        String combinedName = firstName + " " + lastName;

        MainContactsBase homePage = INSERT_SERVICE.getPastPopup();
        Assert.assertTrue(homePage.isPageOpened(), "Contacts page is not opened");
        INSERT_SERVICE.insertContact(firstName, lastName, company, phone, email);

        Assert.assertTrue(homePage.isPageOpened(), "Contacts page is not opened");
        Assert.assertTrue(homePage.isNamePresent(combinedName), "Name is not present.");
        ContactInfoBase infoPage = homePage.clickContactName(combinedName);
        Assert.assertTrue(infoPage.isPageOpened(), "Not at contact info page");

        EnterContactBase updatedContact = infoPage.clickEdit();
        Assert.assertTrue(updatedContact.isPageOpened(), "Not on new contact input page");

        updatedContact.enterEmail(newEmail);
        ContactInfoBase updatedInfoPage = updatedContact.clickSaveButton();
        Assert.assertTrue(updatedInfoPage.isPageOpened(), "Not at contact info page");

        Assert.assertTrue(updatedInfoPage.verifyEmail(newEmail), "Email is not assigned");
    }

    @Test(dataProvider = "DataProvider")
    @XlsDataSourceParameters(path = "data_source/solvdTest.xlsx", sheet = "data", dsArgs = "FirstName,LastName,Company,Phone,Email")
    public void deleteContact(String firstName, String lastName, String company, String phone, String email)
    {
        String combinedName = firstName + " " + lastName;

        MainContactsBase homePage = INSERT_SERVICE.getPastPopup();
        Assert.assertTrue(homePage.isPageOpened(), "Contacts page is not opened");
        INSERT_SERVICE.insertContact(firstName, lastName, company, phone, email);
        Assert.assertTrue(homePage.isPageOpened(), "Contacts page is not opened");
        Assert.assertTrue(homePage.isNamePresent(combinedName), "Name already not in contacts");

        int initialCount = homePage.getContactListSize() - homePage.getFaveCount();

        ContactInfoBase infoPage = homePage.clickContactName(combinedName);
        Assert.assertTrue(infoPage.isPageOpened(), "Not at contact info");
        infoPage.delete();

        Assert.assertTrue(homePage.isPageOpened(), "Contacts page is not opened");

        int newCount = homePage.getContactListSize() - homePage.getFaveCount();

        Assert.assertEquals(newCount, initialCount - 1,  "Size has not been reduced by 1");
    }

    @Test(dataProvider = "DataProvider")
    @XlsDataSourceParameters(path = "data_source/solvdTest.xlsx", sheet = "data", dsArgs = "FirstName,LastName,Company,Phone,Email")
    public void faveContact(String firstName, String lastName, String company, String phone, String email)
    {
        String combinedName = firstName + " " + lastName;

        MainContactsBase homePage = INSERT_SERVICE.getPastPopup();
        Assert.assertTrue(homePage.isPageOpened(), "Contacts page is not opened");
        INSERT_SERVICE.insertContact(firstName, lastName, company, phone, email);
        Assert.assertTrue(homePage.isPageOpened(), "Contacts page is not opened");

        ContactInfoBase contactInfo = homePage.clickContactName(combinedName);
        Assert.assertTrue(contactInfo.isPageOpened(), "Not at contact info");
        contactInfo.clickFave();
        contactInfo.clickGoBack();

        Assert.assertTrue(homePage.isPageOpened(), "Contacts page is not opened");
        FavesBase faves = homePage.clickFavesButton();
        Assert.assertTrue(faves.isPageOpened(), "Not on favorites page");
        Assert.assertTrue(faves.isNamePresent(combinedName));
    }
}
