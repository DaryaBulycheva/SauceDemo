package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By LOGIN_FIELD = By.id("user-name");
    private final By PASSWORD_FIELD = By.id("password");
    private final By LOGIN_BUTTON = By.id("login-button");
    private final By ADD_BUTTON_BACKPACK = By.id("add-to-cart-sauce-labs-backpack");
    private final By ADD_BUTTON_ONESIE = By.id("add-to-cart-sauce-labs-onesie");
    private final By CART_BUTTON = By.id("shopping_cart_container");
    private final By PAGE_TITLE = By.className("title");
    private final By BUTTON_REMOVE = By.id("remove-sauce-labs-backpack");
    private final By CART_BADGE = By.className("shopping_cart_badge");
    private final By BUTTON_CHECKOIUT = By.id("checkout");
    private final By BUTTON_COUNTINUE_SHOPPING = By.id("continue-shopping");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void login(String user, String password) {
        driver.findElement(LOGIN_FIELD).sendKeys(user);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void addToCartBackpack() {
        driver.findElement(ADD_BUTTON_BACKPACK).click();
    }

    public void addToCartOnesie() {
        driver.findElement(ADD_BUTTON_ONESIE).click();
    }

    public void openCart() {
        driver.findElement(CART_BUTTON).click();
    }

    public boolean isPageOpened() {
        return driver.findElement(PAGE_TITLE).isDisplayed();
    }

    public void removeBackpack() {
        driver.findElement(BUTTON_REMOVE).click();
    }

    public boolean displayCounter() {
        return driver.findElement(CART_BADGE).isDisplayed();
    }

    public void checkout() {
        driver.findElement(BUTTON_CHECKOIUT).click();
    }

    public void countinueShopping() {
        driver.findElement(BUTTON_COUNTINUE_SHOPPING).click();
    }
}
