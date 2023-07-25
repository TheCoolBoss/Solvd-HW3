package hw3.carina.demo.hw.web;

import com.zebrunner.carina.core.IAbstractTest;
import hw3.carina.demo.gui.pages.hw.*;
import hw3.carina.demo.gui.services.LoginService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchaseTest implements IAbstractTest
{
    private static final LoginService LOGIN_SERVICE = new LoginService();

    @Test()
    public void buyNothing()
    {
        HomePage homePage = LOGIN_SERVICE.doGoodLogin();

        CartPage cartPage = homePage.openCartPage();

        CheckoutInfoPage checkoutInfoPage = cartPage.goToCheckout();
        Assert.assertTrue(checkoutInfoPage.isPageOpened(), "Not at info page");
        checkoutInfoPage.fillOutForm("Captain", "Falcon", "07");

        PaymentPage paymentPage = checkoutInfoPage.goToPayment();
        Assert.assertTrue(paymentPage.isPageOpened(), "Not at payment page");

        PurchaseDonePage purchaseDonePage = paymentPage.submitPayment();
        Assert.assertTrue(purchaseDonePage.isPageOpened(), "Final page not open");
    }

    @Test()
    public void buyBackpack()
    {
        HomePage homePage = LOGIN_SERVICE.doGoodLogin();

        ItemPage backpackPage = homePage.openProductPage("Sauce Labs Backpack");
        Assert.assertTrue(backpackPage.isPageOpened(), "Not at backpack item page");
        backpackPage.clickAddButton();
        String cost = backpackPage.getCost();
        Assert.assertTrue(backpackPage.allElementsPresent(backpackPage.getQuantityIcon()), "Quantity missing");

        CartPage cartPage = backpackPage.clickCartButton();
        Assert.assertTrue(cartPage.isPageOpened(), "Not at cart page");

        CheckoutInfoPage checkoutInfoPage = cartPage.goToCheckout();
        checkoutInfoPage.fillOutForm("Captain", "Falcon", "07");

        PaymentPage paymentPage = checkoutInfoPage.goToPayment();
        Assert.assertTrue(paymentPage.isPageOpened(), "Not at payment page");
        Assert.assertTrue(paymentPage.getTotal().contains(cost), "Subtotal not equal");

        PurchaseDonePage purchaseDonePage = paymentPage.submitPayment();
        Assert.assertTrue(purchaseDonePage.isPageOpened(), "Final page not open");
    }

    @Test()
    public void cancelLightPurchase()
    {
        HomePage homePage = LOGIN_SERVICE.doGoodLogin();

        ItemPage lightPage = homePage.openProductPage("Sauce Labs Bike Light");
        Assert.assertTrue(lightPage.isPageOpened());

        //Remove button is the same one, so doing this for now
        lightPage.clickAddButton();
        lightPage.clickAddButton();
        Assert.assertFalse(lightPage.getQuantityIcon().isElementPresent(5), "Cart quantity icon is visible");
    }
}
