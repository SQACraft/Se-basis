package lifeCart.business.locators;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Checkout extends TestBase {

    @Test
    public void Checkout() throws InterruptedException {

        click(By.cssSelector(("div #box-most-popular a.link[href*=p-3"))); // выбор первого товара
        Assert.assertTrue(isOneElementPresent(By.xpath
                ("//h1[contains(text(), 'Red Duck')]")));                      // проверка заголовка на карточке товара
        addToCart();                                                                       // добавление товара в корзину
        goToSquareOne();

        click(By.cssSelector(("div #box-most-popular a.link[href*=p-4")));  // выбор второго товара
        Assert.assertTrue(isOneElementPresent(By.xpath
                ("//h1[contains(text(), 'Blue Duck')]")));
        addToCart();
        goToSquareOne();

        goToCheckout();                                                   // переход в чекаут

        Assert.assertTrue(isOneElementPresent(By.xpath(
                ".//*[@id='order_confirmation-wrapper']/table/tbody/tr[7]/td[2]/strong[contains(text(), '$40.00')]")));    // проверка значения итога
    }

}
