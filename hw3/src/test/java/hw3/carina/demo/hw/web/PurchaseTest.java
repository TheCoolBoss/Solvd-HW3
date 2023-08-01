package hw3.carina.demo.hw.web;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;
import hw3.carina.demo.gui.pages.hw.web.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PurchaseTest implements IAbstractTest
{
    @Test(dataProvider = "normalInfo")
    public void normalInfo(String user, String pass, String firstName, String lastName, String zip)
    {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        HomePage homePage = loginPage.loginToHome(user, pass);

        CartPage cartPage = homePage.openCartPage();

        CheckoutInfoPage checkoutInfoPage = cartPage.clickCheckoutButton();
        Assert.assertTrue(checkoutInfoPage.isPageOpened(), "Not at info page");
        checkoutInfoPage.fillOutForm(firstName, lastName, zip);

        PaymentPage paymentPage = checkoutInfoPage.clickPaymentButton();
        Assert.assertTrue(paymentPage.isPageOpened(), "Not at payment page");

        PurchaseDonePage purchaseDonePage = paymentPage.submitPayment();
        Assert.assertTrue(purchaseDonePage.isPageOpened(), "Final page not open");
    }

    @Test(dataProvider = "normalInfo")
    public void buyBackpack(String user, String pass, String firstName, String lastName, String zip)
    {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        HomePage homePage = loginPage.loginToHome(user, pass);

        ItemPage backpackPage = homePage.openProductPage("Sauce Labs Backpack");
        Assert.assertTrue(backpackPage.isPageOpened(), "Not at backpack item page");
        backpackPage.clickAddButton();
        String cost = backpackPage.getCost();
        Assert.assertTrue(backpackPage.allElementsPresent(backpackPage.getQuantityIcon()), "Quantity missing");

        CartPage cartPage = backpackPage.clickCartButton();
        Assert.assertTrue(cartPage.isPageOpened(), "Not at cart page");

        CheckoutInfoPage checkoutInfoPage = cartPage.clickCheckoutButton();
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
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        HomePage homePage = loginPage.loginToHome(R.TESTDATA.get("good_user"), R.TESTDATA.get("good_pass"));

        ItemPage lightPage = homePage.openProductPage("Sauce Labs Bike Light");
        Assert.assertTrue(lightPage.isPageOpened());

        lightPage.clickAddButton();
        lightPage.clickRemoveButton();
        Assert.assertFalse(lightPage.isQuantityIconPresent(), "Cart quantity icon is visible");
    }

    @DataProvider(name = "normalInfo")
    public static Object[][] provideGoodLogin()
    {
        return new Object[][]
                {
                        {R.TESTDATA.get("good_user")},
                        {R.TESTDATA.get("good_pass")},
                        {R.TESTDATA.get("checkoutFirstName")},
                        {R.TESTDATA.get("checkoutLastName")},
                        {R.TESTDATA.get("checkoutZip")}
                };
    }
}
