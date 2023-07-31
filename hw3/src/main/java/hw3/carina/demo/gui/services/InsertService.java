package hw3.carina.demo.gui.services;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.webdriver.IDriverPool;
import hw3.carina.demo.gui.pages.hw.android.EnterContactInfoPage;
import hw3.carina.demo.gui.pages.hw.android.abstracts.ContactInfoBase;
import hw3.carina.demo.gui.pages.hw.android.abstracts.EnterContactBase;
import hw3.carina.demo.gui.pages.hw.android.abstracts.MainContactsBase;
import hw3.carina.demo.gui.pages.hw.android.abstracts.PopupBase;

public class InsertService implements IDriverPool, IAbstractTest
{
    public MainContactsBase getPastPopup()
    {
        PopupBase popupPage = initPage(getDriver(), PopupBase.class);
        return popupPage.clickSkip();
    }

    public void insertContact(String[] info)
    {
        String firstName = info[0];
        String lastName = info[1];
        String company = info[2];
        String phone = info[3];
        String email = info[4];

        MainContactsBase homePage = initPage(getDriver(), MainContactsBase.class);
        EnterContactBase newContact = homePage.clickNewContact();

        newContact.enterFirstName(firstName);
        newContact.enterLastName(lastName);
        newContact.enterCompany(company);
        newContact.enterPhone(phone);
        newContact.enterEmail(email);
        ContactInfoBase infoPage = newContact.clickSaveButton();

        infoPage.clickGoBack();
    }
}
