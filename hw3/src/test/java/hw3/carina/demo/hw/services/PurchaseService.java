package hw3.carina.demo.hw.services;

import hw3.carina.demo.gui.pages.hw.*;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class PurchaseService
{
    private static final SoftAssert SA = new SoftAssert();
    public static CartPage openCartPage(HomePage homePage)
    {
        CartPage cartPage = homePage.getCartButton().openCartPage();
        SA.assertTrue(cartPage.isPageOpened(), "Not at cart page");
        return cartPage;
    }

    public static CheckoutInfoPage openInfoPage(WebDriver wd, CartPage cartPage)
    {
        CheckoutInfoPage checkoutInfoPage = cartPage.openCheckoutInfoPage(wd);
        SA.assertTrue(checkoutInfoPage.isPageOpened(), "Not at info page");
        return checkoutInfoPage;
    }

    public static PaymentPage openPaymentPage(WebDriver wd, CheckoutInfoPage checkoutInfoPage)
    {
        PaymentPage paymentPage = checkoutInfoPage.openPaymentPage(wd);
        SA.assertTrue(paymentPage.isPageOpened(), "Not at payment page");
        return paymentPage;
    }

    public static PurchaseDonePage openPurchaseDonePage(WebDriver wd, PaymentPage paymentPage)
    {
        PurchaseDonePage purchaseDonePage = paymentPage.openPurchaseDonePage(wd);
        SA.assertTrue(purchaseDonePage.isPageOpened(), "Not on payment finished page");
        return purchaseDonePage;
    }

}
