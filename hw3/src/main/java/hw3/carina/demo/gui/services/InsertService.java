package hw3.carina.demo.gui.services;

import com.zebrunner.carina.webdriver.IDriverPool;
import hw3.carina.demo.gui.pages.hw.android.ContactInfoPage;
import hw3.carina.demo.gui.pages.hw.android.EnterContactInfoPage;
import hw3.carina.demo.gui.pages.hw.android.MainContactsPage;
import hw3.carina.demo.gui.pages.hw.android.PopupPage;

public class InsertService implements IDriverPool
{
    public MainContactsPage getPastPopup()
    {
        PopupPage popupPage = new PopupPage(getDriver());
        return popupPage.clickSkip();
    }

    public void insertContact(String[] info)
    {
        String firstName = info[0];
        String lastName = info[1];
        String company = info[2];
        String phone = info[3];
        String email = info[4];

        MainContactsPage homePage = new MainContactsPage(getDriver());
        EnterContactInfoPage newContact = homePage.clickNewContact();

        newContact.enterFirstName(firstName);
        newContact.enterLastName(lastName);
        newContact.enterCompany(company);
        newContact.enterPhone(phone);
        newContact.enterEmail(email);
        ContactInfoPage infoPage = newContact.clickSaveButton();

        infoPage.clickGoBack();
    }
}
