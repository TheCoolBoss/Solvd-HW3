package hw3.carina.demo.gui.pages.hw;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import hw3.carina.demo.gui.components.hw.CartButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends AbstractPage
{
    @FindBy(xpath = "//*[@id='menu_button_container']/div/div[1]/div")
    private ExtendedWebElement burgerMenu;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement burgerButton;

    @FindBy(id = "about_sidebar_link")
    private ExtendedWebElement aboutLink;

    @FindBy(id = "logout_sidebar_link")
    private ExtendedWebElement logoutLink;

    @FindBy(xpath = "//*[@id='shopping_cart_container']/a")
    private CartButton cartButton;

    @FindBy(id = "item_4_title_link")
    private ExtendedWebElement backpackLink;

    @FindBy(id = "item_0_title_link")
    private ExtendedWebElement lightLink;


    public HomePage(WebDriver wd)
    {
        super(wd);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL_AND_ELEMENT);
        setPageURL("inventory.html");
        setUiLoadedMarker(cartButton.getUiLoadedMarker());
    }

    public AboutPage openAboutPage(WebDriver wd)
    {
        //burgerMenu.click();
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(30));
        burgerButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-burger-menu-btn")));
        burgerButton.click();
        aboutLink.click();
        return new AboutPage(wd);
    }

    public BackpackPage openBackpackPage(WebDriver wd)
    {
        backpackLink.click();
        return new BackpackPage(wd);
    }

    public LightPage openLightPage(WebDriver wd)
    {
        lightLink.click();
        return new LightPage(wd);
    }

    public CartButton getCartButton()
    {
        return cartButton;
    }
}
