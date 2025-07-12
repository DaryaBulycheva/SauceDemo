package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private final By TITLE = By.className("title");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы с товарами")
    public void open() {
        driver.get(BASE_URL + "/inventory.html");
    }

    @Step("Проверка открытия страницы с товарами")
    public boolean isPageOpened() {
        return driver.findElement(TITLE).isDisplayed();
    }
}
