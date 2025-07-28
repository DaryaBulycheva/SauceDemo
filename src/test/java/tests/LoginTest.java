package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test(priority = 2,
            testName = "Негативный тест без пароля",
            description = "Проверка входа в систему без пароля")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Bulycheva D.A.")
    @Link("https://www.saucedemo.com/")
    @Epic("Login Page")
    @Feature("Log in")
    @Story("Login Without Password")
    @TmsLink("ITM-4")
    @Issue("ITM-4-1")
    @Description("Проверка, что пользователь не может войти в магазин, когда вводит пустой пароль")
    public void checkLoginWithoutPassword() {
        loginPage.open();
        loginPage.login(user, "");
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Password is required",
                "Сообщение не соответствует");
    }

    @Test(priority = 2,
            testName = "Негативный тест без логина",
            description = "Проверка входа в систему без логина")
    @Description("Проверка, что пользователь не может войти в магазин, когда вводит пустой логин")
    public void checkLoginWithoutUsername() {
        loginPage.open();
        loginPage.login("", password);
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "Сообщение не соответствует");
    }

    @Test(priority = 2,
            testName = "Негативный тест с невалидными данными",
            description = "Проверка входа в систему с невалидными данными")
    @Description("Проверка, что пользователь не может войти в магазин, когда вводит невалидные данные")
    public void checkLoginWithNegativeValue() {
        loginPage.open();
        loginPage.login("test", "test");
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Сообщение не соответствует");
    }

    @Test(priority = 1,
            testName = "Позитивный тест",
            description = "Проверка входа в систему с валидными данными")
    @Description("Проверка, что пользователь может войти в магазин, когда вводит валидные данные")
    public void checkLogin() {
        loginPage.open();
        loginPage.login(user, password);
        assertTrue(productsPage.isPageOpened());
    }

    @DataProvider(name = "LoginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"standard_user", "", "Epic sadface: Password is required"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"test", "test", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test(dataProvider = "LoginData",
            priority = 3,
            testName = "Негативный тест с разными невалидными данными",
            description = "Проверка входа в систему с разными невалидными данными")
    @Description("Проверка, что пользователь не может войти в магазин, когда вводит разные невалидные данные")
    public void checkLoginWithNegativeValue1(String user, String password, String expectedMessage) {
        loginPage.open();
        loginPage.login(user, password);
        Assert.assertEquals(loginPage.getErrorMessage(),
                expectedMessage,
                "Сообщение не соответствует");
    }
}
