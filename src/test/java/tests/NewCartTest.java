package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class NewCartTest extends BaseTest {

    @Test(priority = 1,
            testName = "Тест добавления товара в корзину",
            description = "Проверка добавления товара в корзину")
    public void checkAddToCart() {
        cartPage.addToCartBackpack();
        cartPage.openCart();
        cartPage.isPageOpened();
        String name = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
        softAssert.assertEquals(name, "Sauce Labs Backpack", "Ошибка: товар в корзину не был добавлен");
    }

    @Test(priority = 2,
            testName = "Тест удаления товара из корзины",
            description = "Проверка удаления товара из корзины")
    public void checkRemove() {
        cartPage.addToCartBackpack();
        cartPage.addToCartOnesie();
        cartPage.openCart();
        cartPage.isPageOpened();
        cartPage.removeBackpack();
        String counter = driver.findElement(By.className("shopping_cart_badge")).getText();
        softAssert.assertEquals(counter, "1", "Ошибка: товар из корзины не удален");
    }

    @Test(priority = 3,
            testName = "Тест счетчика товаров в корзине",
            description = "Проверка счетчика товаров в корзине")
    public void checkCounterDisplay() {
        cartPage.addToCartBackpack();
        cartPage.addToCartOnesie();
        cartPage.openCart();
        cartPage.isPageOpened();
        cartPage.displayCounter();
        cartPage.removeBackpack();
        String counter = driver.findElement(By.className("shopping_cart_badge")).getText();
        softAssert.assertEquals(counter, "1", "Ошибка: счетчик считает некорректно/товар не был удален");

    }

    @Test(priority = 3,
            testName = "Тест перехода к оформлению заказа",
            description = "Проверка перехода к оформлению заказа")
    public void checkCheckout() {
        cartPage.addToCartBackpack();
        cartPage.openCart();
        cartPage.isPageOpened();
        cartPage.checkout();
        String title = driver.findElement(By.className("title")).getText();
        softAssert.assertEquals(title, "Checkout: Your Information", "Ошибка: не был осуществлен переход на страницу оформления заказа");
    }

    @Test(priority = 4,
            testName = "Тест перехода на страницу продолжения покупок",
            description = "Проверка перехода на страницу продолжения покупок")
    public void checkCountinueShopping() {
        cartPage.addToCartBackpack();
        cartPage.openCart();
        cartPage.isPageOpened();
        cartPage.countinueShopping();
        String title = driver.findElement(By.className("title")).getText();
        softAssert.assertEquals(title, "Products", "Ошибка: не был осуществлен переход на страницу продолжения покупок");
    }
}
