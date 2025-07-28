package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
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
    private final By PRODUCT_NAME = By.xpath("//div[@class='inventory_item_name']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы авторизации")
    public void open() {
        log.info("Open Login page");
        driver.get(BASE_URL);
    }

    @Step("Вход в систему с именем пользователя: {user} и паролем: {password}")
    public void login(String user, String password) {
        log.info("Log in with credential: {}, {} ", user, password);
        driver.findElement(LOGIN_FIELD).sendKeys(user);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Step("Добавление в корзину рюкзака")
    public void addToCartBackpack() {
        log.info("Adding a backpack to the cart");
        driver.findElement(ADD_BUTTON_BACKPACK).click();
    }

    @Step("Добавление в корзину детского комбинезона")
    public void addToCartOnesie() {
        log.info("Adding a onesie to the cart");
        driver.findElement(ADD_BUTTON_ONESIE).click();
    }

    @Step("Открытие корзины")
    public void openCart() {
        log.info("Open Cart page");
        driver.findElement(CART_BUTTON).click();
    }

    @Step("Проверка открытия корзины")
    public boolean isPageOpened() {
        log.info("Checking the opening of the cart");
        return driver.findElement(PAGE_TITLE).isDisplayed();
    }

    @Step("Поиск наименования элемента в корзине")
    public String findName() {
        log.info("Find product name in the cart");
        return driver.findElement(PRODUCT_NAME).getText();
    }

    @Step("Удаление из корзины рюкзака")
    public void removeBackpack() {
        log.info("Removing a backpack from the cart");
        driver.findElement(BUTTON_REMOVE).click();
    }

    @Step("Поиск количества элемента в корзине")
    public String findCounter() {
        log.info("Find number of items in the cart");
        return driver.findElement(CART_BADGE).getText();
    }

    @Step("Проверка отсутствия товаров в корзине")
    public boolean displayCounter() {
        log.info("Checking for missing items in the cart");
        return driver.findElement(CART_BADGE).isDisplayed();
    }

    @Step("Переход к оформлению заказа")
    public void checkout() {
        log.info("Going to checkout");
        driver.findElement(BUTTON_CHECKOIUT).click();
    }

    @Step("Поиск наименования страницы")
    public String findTitle() {
        log.info("Find title page");
        return driver.findElement(PAGE_TITLE).getText();
    }

    @Step("Переход к продолжению покупок")
    public void countinueShopping() {
        log.info("Going to countinue shopping");
        driver.findElement(BUTTON_COUNTINUE_SHOPPING).click();
    }

    @Step("Проверка перехода к продолжению покупок")
    public String checkCountinueShopping() {
        log.info("Checking the transition to the continuation shopping");
        return driver.findElement(PAGE_TITLE).getText();
    }
}
