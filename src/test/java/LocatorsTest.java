import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;

public class LocatorsTest {
    @Test
    public void checkLocators() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
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
        driver.quit();
    }
}
