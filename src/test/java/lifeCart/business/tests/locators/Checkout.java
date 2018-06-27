package lifeCart.business.tests.locators;

import lifeCart.business.appManager.ToolBox;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Checkout extends ToolBox {

    @Test (groups = "Locators")
    void Checkout() throws InterruptedException {

        goToSquareOne();

        click(By.cssSelector(("div #box-most-popular a.link[href*=p-3"))); // выбор первого товара

        validateByTextContent(By.cssSelector("#box-product .title"),
                "Red Duck");                                                    // проверка заголовка на странице товара

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
