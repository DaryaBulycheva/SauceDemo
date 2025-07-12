package tests;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FailedTest extends BaseTest {
    @Test(priority = 3,
            testName = "Тест перехода к продолжению покупок",
            description = "Проверка кнопки Continue Shopping")
    @Description("Проверка, что осуществляет переход к продолжению покупок по кнопке Continue Shopping")
    public void checkCounterDisplay() {
        cartPage.addToCartBackpack();
        cartPage.openCart();
        cartPage.isPageOpened();
        cartPage.removeBackpack();
        cartPage.countinueShopping();
        Assert.assertEquals(cartPage.checkCountinueShopping(),
                "Pducts",
                "Не был осуществлен переход к продолжению покупок");
    }
}
