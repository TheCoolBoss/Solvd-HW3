package hw3.carina.demo.hw.web;

import com.zebrunner.carina.core.IAbstractTest;
import hw3.carina.demo.gui.pages.hw.*;
import hw3.carina.demo.hw.services.LoginService;
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

        CheckoutInfoPage checkoutInfoPage = cartPage.openCheckoutInfoPage();
        Assert.assertTrue(checkoutInfoPage.isPageOpened(), "Not at info page");
        checkoutInfoPage.fillOutForm("Captain", "Falcon", "07");

        PaymentPage paymentPage = checkoutInfoPage.openPaymentPage();
        Assert.assertTrue(paymentPage.isPageOpened(), "Not at payment page");

        PurchaseDonePage purchaseDonePage = paymentPage.openPurchaseDonePage();
        Assert.assertTrue(purchaseDonePage.isPageOpened(), "Final page not open");
    }

    @Test()
    public void buyBackpack()
    {
        HomePage homePage = LOGIN_SERVICE.doGoodLogin();

        BackpackPage backpackPage = homePage.openBackpackPage();
        Assert.assertTrue(backpackPage.isPageOpened(), "Not at backpack item page");
        backpackPage.addBackpack();
        String cost = backpackPage.getCost();
        Assert.assertTrue(backpackPage.allElementsPresent(backpackPage.getQuantityIcon()), "Quantity missing");

        CartPage cartPage = backpackPage.openCartPage();
        Assert.assertTrue(cartPage.isPageOpened(), "Not at cart page");

        CheckoutInfoPage checkoutInfoPage = cartPage.openCheckoutInfoPage();
        checkoutInfoPage.fillOutForm("Captain", "Falcon", "07");

        PaymentPage paymentPage = checkoutInfoPage.openPaymentPage();
        Assert.assertTrue(paymentPage.isPageOpened(), "Not at payment page");
        Assert.assertTrue(paymentPage.getTotal().contains(cost), "Subtotal not equal");

        PurchaseDonePage purchaseDonePage = paymentPage.openPurchaseDonePage();
        Assert.assertTrue(purchaseDonePage.isPageOpened(), "Final page not open");
    }

    @Test()
    public void cancelLightPurchase()
    {
        HomePage homePage = LOGIN_SERVICE.doGoodLogin();

        LightPage lightPage = homePage.openLightPage();
        Assert.assertTrue(lightPage.isPageOpened());
        lightPage.addLight();
        lightPage.removeLight();
        Assert.assertFalse(lightPage.getQuantityIcon().isElementPresent(), "Cart quantity icon is visible");
    }
}
