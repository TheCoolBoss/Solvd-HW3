package hw3.carina.demo.hw.web;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import hw3.carina.demo.gui.pages.hw.web.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchaseTest implements IAbstractTest
{
    @Test()
    public void buyNothing()
    {
        String user = R.TESTDATA.get("good_user");
        String pass = R.TESTDATA.get("good_pass");
        String firstName = R.TESTDATA.get("checkoutFirstName");
        String lastName = R.TESTDATA.get("checkoutLastName");
        String zip = R.TESTDATA.get("checkoutZip");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Not on login page");
        HomePage homePage = loginPage.loginToHome(user, pass);
        Assert.assertTrue(homePage.isPageOpened(), "Not at home page");

        CartPage cartPage = homePage.openCartPage();
        Assert.assertTrue(cartPage.isPageOpened(), "Not at cart page");

        CheckoutInfoPage checkoutInfoPage = cartPage.clickCheckoutButton();
        Assert.assertTrue(checkoutInfoPage.isPageOpened(), "Not at info page");
        checkoutInfoPage.fillOutForm(firstName, lastName, zip);

        PaymentPage paymentPage = checkoutInfoPage.clickPaymentButton();
        Assert.assertTrue(paymentPage.isPageOpened(), "Not at payment page");

        PurchaseDonePage purchaseDonePage = paymentPage.submitPayment();
        Assert.assertTrue(purchaseDonePage.isPageOpened(), "Final page not open");
    }

    @Test()
    public void buyBackpack()
    {
        String user = R.TESTDATA.get("good_user");
        String pass = R.TESTDATA.get("good_pass");
        String firstName = R.TESTDATA.get("checkoutFirstName");
        String lastName = R.TESTDATA.get("checkoutLastName");
        String zip = R.TESTDATA.get("checkoutZip");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Not on login page");
        HomePage homePage = loginPage.loginToHome(user, pass);
        Assert.assertTrue(homePage.isPageOpened(), "Not at home page");

        ItemPage backpackPage = homePage.openProductPage("Sauce Labs Backpack");
        Assert.assertTrue(backpackPage.isPageOpened(), "Not at backpack item page");
        backpackPage.clickAddButton();
        String cost = backpackPage.getCost();
        Assert.assertTrue(backpackPage.allElementsPresent(backpackPage.getQuantityIcon()), "Quantity missing");

        CartPage cartPage = backpackPage.clickCartButton();
        Assert.assertTrue(cartPage.isPageOpened(), "Not at cart page");

        CheckoutInfoPage checkoutInfoPage = cartPage.clickCheckoutButton();
        Assert.assertTrue(checkoutInfoPage.isPageOpened(), "Not at info page");
        checkoutInfoPage.fillOutForm(firstName, lastName, zip);

        PaymentPage paymentPage = checkoutInfoPage.clickPaymentButton();
        Assert.assertTrue(paymentPage.isPageOpened(), "Not at payment page");
        Assert.assertTrue(paymentPage.getTotal().contains(cost), "Subtotal not equal");

        PurchaseDonePage purchaseDonePage = paymentPage.submitPayment();
        Assert.assertTrue(purchaseDonePage.isPageOpened(), "Final page not open");
    }

    @Test()
    public void cancelLightPurchase()
    {
        String user = R.TESTDATA.get("good_user");
        String pass = R.TESTDATA.get("good_pass");

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Not on login page");
        HomePage homePage = loginPage.loginToHome(user, pass);
        Assert.assertTrue(homePage.isPageOpened(), "Not at home page");

        ItemPage lightPage = homePage.openProductPage("Sauce Labs Bike Light");
        Assert.assertTrue(lightPage.isPageOpened());

        lightPage.clickAddButton();
        lightPage.clickRemoveButton();
        Assert.assertFalse(lightPage.isQuantityIconPresent(), "Cart quantity icon is visible");
    }
}
