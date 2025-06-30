package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class NewCartTest extends BaseTest {

    @Test
    public void checkAddToCart() {
        cartPage.addToCartBackpack();
        cartPage.openCart();
        cartPage.isPageOpened();
        String name = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
        softAssert.assertEquals(name, "Sauce Labs Backpack", "Ошибка: товар в корзину не был добавлен");
    }

    @Test
    public void checkRemove() {
        cartPage.addToCartBackpack();
        cartPage.addToCartOnesie();
        cartPage.openCart();
        cartPage.isPageOpened();
        cartPage.removeBackpack();
        String counter = driver.findElement(By.className("shopping_cart_badge")).getText();
        softAssert.assertEquals(counter, "1", "Ошибка: товар из корзины не удален");
    }

    @Test
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

    @Test
    public void checkCheckout() {
        cartPage.addToCartBackpack();
        cartPage.openCart();
        cartPage.isPageOpened();
        cartPage.checkout();
        String title = driver.findElement(By.className("title")).getText();
        softAssert.assertEquals(title, "Checkout: Your Information", "Ошибка: не был осуществлен переход на страницу оформления заказа");
    }

    @Test
    public void checkCountinueShopping() {
        cartPage.addToCartBackpack();
        cartPage.openCart();
        cartPage.isPageOpened();
        cartPage.countinueShopping();
        String title = driver.findElement(By.className("title")).getText();
        softAssert.assertEquals(title, "Products", "Ошибка: не был осуществлен переход на страницу продолжения покупок");
    }
}
