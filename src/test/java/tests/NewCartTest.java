package tests;

import jdk.jfr.Description;
import org.testng.annotations.Test;

public class NewCartTest extends BaseTest {

    @Test(priority = 1,
            testName = "Тест добавления товара в корзину",
            description = "Проверка добавления товара в корзину")
    @Description("Проверка, что товар в корзину добавился")
    public void checkAddToCart() {
        cartPage.open();
        cartPage.login("standard_user", "secret_sauce");
        cartPage.addToCartBackpack();
        cartPage.openCart();
        cartPage.isPageOpened();
        String name = cartPage.findName();
        softAssert.assertEquals(name, "Sauce Labs Backpack", "Ошибка: товар в корзину не был добавлен");
    }

    @Test(priority = 2,
            testName = "Тест удаления товара из корзины",
            description = "Проверка удаления товара из корзины")
    @Description("Проверка, что товар из корзины удалился")
    public void checkRemove() {
        cartPage.open();
        cartPage.login("standard_user", "secret_sauce");
        cartPage.addToCartBackpack();
        cartPage.addToCartOnesie();
        cartPage.openCart();
        cartPage.isPageOpened();
        cartPage.removeBackpack();
        String counter = cartPage.findCounter();
        softAssert.assertEquals(counter, "1", "Ошибка: товар из корзины не удален");
    }

    @Test(priority = 3,
            testName = "Тест счетчика товаров в корзине",
            description = "Проверка счетчика товаров в корзине")
    @Description("Проверка, что счетчик товаров в корзине считает корректно")
    public void checkCounterDisplay() {
        cartPage.open();
        cartPage.login("standard_user", "secret_sauce");
        cartPage.addToCartBackpack();
        cartPage.addToCartOnesie();
        cartPage.openCart();
        cartPage.isPageOpened();
        cartPage.displayCounter();
        cartPage.removeBackpack();
        String counter = cartPage.findCounter();
        softAssert.assertEquals(counter, "1", "Ошибка: счетчик считает некорректно/товар не был удален");
    }

    @Test(priority = 3,
            testName = "Тест перехода к оформлению заказа",
            description = "Проверка перехода к оформлению заказа")
    @Description("Проверка, что осуществляется переход к оформлению заказа")
    public void checkCheckout() {
        cartPage.open();
        cartPage.login("standard_user", "secret_sauce");
        cartPage.addToCartBackpack();
        cartPage.openCart();
        cartPage.isPageOpened();
        cartPage.checkout();
        String title = cartPage.findTitle();
        softAssert.assertEquals(title, "Checkout: Your Information", "Ошибка: не был осуществлен переход на страницу оформления заказа");
    }

    @Test(priority = 4,
            testName = "Тест перехода на страницу продолжения покупок",
            description = "Проверка перехода на страницу продолжения покупок")
    @Description("Проверка, что осуществляется переход на страницу продолжения покупок")
    public void checkCountinueShopping() {
        cartPage.open();
        cartPage.login("standard_user", "secret_sauce");
        cartPage.addToCartBackpack();
        cartPage.openCart();
        cartPage.isPageOpened();
        cartPage.countinueShopping();
        String title = cartPage.findTitle();
        softAssert.assertEquals(title, "Products", "Ошибка: не был осуществлен переход на страницу продолжения покупок");
    }
}
