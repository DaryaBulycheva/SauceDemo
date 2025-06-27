package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {
    @Test
    public void checkCart() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.className("submit-button")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        String name = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
        softAssert.assertEquals(name, "Sauce Labs Backpack");
        String price = driver.findElement(By.xpath("//div[@class='inventory_item_price']")).getText();
        softAssert.assertEquals(price, "$29.99");
    }
}
