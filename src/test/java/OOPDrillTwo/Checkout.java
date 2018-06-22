package OOPDrillTwo;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Checkout extends TestBase {

    Methods m = new Methods(wd);

     @Test

    public void passCheckout() throws InterruptedException {

        m.click(By.cssSelector(("div #box-most-popular a.link[href*=p-3"))); // выбор  товара
        Assert.assertTrue(m.isOneElementPresent(By.xpath
                ("//h1[contains(text(), 'Red Duck')]")));                      // проверка заголовка на карточке товара
        m.addToCart();                                                                       // добавление товара в корзину
        m.goToSquareOne();
        m.goToCheckout();                                                   // переход в чекаут

        Assert.assertTrue(m.isOneElementPresent(By.xpath(
                ".//*[@id='order_confirmation-wrapper']/table/tbody/tr[7]/td[2]/strong[contains(text(), '$40.00')]")));    // проверка значения итога
    }

}
