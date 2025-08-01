package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static tests.AllureUtils.takeScreenshot;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By LOGIN_FIELD = By.id("user-name");
    private final By PASSWORD_FIELD = By.id("password");
    private final By LOGIN_BUTTON = By.id("login-button");
    private final By ERROR_MESSAGE = By.cssSelector("[data-test=error]");

    @Step("Открытие страницы входа в магазин")
    public void open(){
        driver.get(BASE_URL);
    }

    @Step("Вход в систему с именем пользователя: {user} и паролем: {password}")
    public void login(String user, String password){
        driver.findElement(LOGIN_FIELD).sendKeys(user);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Step("Получение текста ошибки при неудачной попытке входа")
    public String getErrorMessage(){
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
