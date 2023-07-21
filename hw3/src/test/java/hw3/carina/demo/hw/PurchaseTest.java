package hw3.carina.demo.hw;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import hw3.carina.demo.gui.pages.hw.*;
import hw3.carina.demo.hw.services.LoginService;
import hw3.carina.demo.hw.services.PurchaseService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PurchaseTest implements IAbstractTest
{
    private static final WebDriver DRIVER = new ChromeDriver();
    private static final SoftAssert SA = new SoftAssert();

    @Test()
    public void buyNothing()
    {
        LoginPage loginPage = new LoginPage(DRIVER);
        HomePage homePage = LoginService.doGoodLogin(DRIVER, loginPage);

        CartPage cartPage = PurchaseService.openCartPage(homePage);

        CheckoutInfoPage checkoutInfoPage = PurchaseService.openInfoPage(DRIVER, cartPage);
        checkoutInfoPage.fillOutForm("Captain", "Falcon", "07");

        PaymentPage paymentPage = PurchaseService.openPaymentPage(DRIVER, checkoutInfoPage);

        PurchaseService.openPurchaseDonePage(DRIVER, paymentPage);
    }

    @Test()
    public void buyBackpack()
    {
        LoginPage loginPage = new LoginPage(DRIVER);
        HomePage homePage = LoginService.doGoodLogin(DRIVER, loginPage);

        BackpackPage backpackPage = homePage.openBackpackPage(DRIVER);
        SA.assertTrue(backpackPage.isPageOpened(), "Not at backpack item page");
        backpackPage.addBackpack();
        ExtendedWebElement cost = backpackPage.getCost();
        SA.assertTrue(backpackPage.allElementsPresent(backpackPage.getQuantityIcon()), "Quantity missing");

        CartPage cartPage = backpackPage.getCartButton().openCartPage();
        SA.assertTrue(cartPage.isPageOpened(), "Not at cart page");

        CheckoutInfoPage checkoutInfoPage = PurchaseService.openInfoPage(DRIVER, cartPage);
        checkoutInfoPage.fillOutForm("Captain", "Falcon", "07");

        PaymentPage paymentPage = PurchaseService.openPaymentPage(DRIVER, checkoutInfoPage);
        SA.assertEquals(cost, paymentPage.getTotal(), "Subtotal not equal");

        PurchaseService.openPurchaseDonePage(DRIVER, paymentPage);
    }

    @Test()
    public void cancelLightPurchase()
    {
        LoginPage loginPage = new LoginPage(DRIVER);
        HomePage homePage = LoginService.doGoodLogin(DRIVER, loginPage);

        LightPage lightPage = homePage.openLightPage(DRIVER);
        SA.assertTrue(lightPage.isPageOpened());
        lightPage.addLight();
        lightPage.removeLight();
        SA.assertFalse(lightPage.getQuantityIcon().isElementPresent(), "Cart quantity icon is visible");
    }

    @AfterTest
    public void closeDriver()
    {
        DRIVER.close();
    }
}
