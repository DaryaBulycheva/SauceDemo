package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LocatorsTest extends BaseTest {
    @Test
    public void checkLocators() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.tagName("input"));
        driver.findElement(By.className("submit-button")).click();
        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.linkText("About"));
        driver.findElement(By.partialLinkText("App"));
        driver.findElement(By.xpath("//div[@class='bm-cross-button']"));
        driver.findElement(By.xpath("//a[text()='Logout']"));
        driver.findElement(By.xpath("//div[contains(@class,'inven')]"));
        driver.findElement(By.xpath("//div[contains(text(),'Fleece')]"));
        driver.findElement(By.xpath("//*[text()='Add to cart']//ancestor::div"));
        driver.findElement(By.xpath("//div[@class='pricebar']//descendant::div"));
        driver.findElement(By.xpath("//div[@class='inventory_item_label']//following::div"));
        driver.findElement(By.xpath("//div[@class='inventory_item_label']//parent::div"));
        driver.findElement(By.xpath("//div[@class='inventory_item']//preceding::div"));
        driver.findElement(By.xpath("//button[contains(@class, 'btn_small') and text()='Add to cart']"));
        driver.findElement(By.cssSelector(".btn_small"));
        driver.findElement(By.cssSelector(".btn_primary.btn_small"));
        driver.findElement(By.cssSelector(".pricebar .inventory_item_price"));
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-bike-light"));
        driver.findElement(By.cssSelector("button"));
        driver.findElement(By.cssSelector("button.btn_small"));
        driver.findElement(By.cssSelector("[id='add-to-cart-sauce-labs-bike-light']"));
        driver.findElement(By.cssSelector("[class~='btn_small']"));
        driver.findElement(By.cssSelector("[name|='add']"));
        driver.findElement(By.cssSelector("[class^='inven']"));
        driver.findElement(By.cssSelector("[class$='item']"));
        driver.findElement(By.cssSelector("[class*='list']"));
    }
}
