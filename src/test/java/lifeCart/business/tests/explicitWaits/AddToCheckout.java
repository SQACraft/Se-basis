package lifeCart.business.tests.explicitWaits;

import lifeCart.business.appManager.ToolBox;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

public class AddToCheckout extends ToolBox {

    @Test
    void checkExplicitWait() throws InterruptedException {

        goToSquareOne();
        click(By.cssSelector(("div #box-latest-products a.link[href*=p-2"))); // выбор первого товара
        addToCart();

        goToSquareOne();
        click(By.cssSelector(("div #box-latest-products a.link[href*=p-3"))); // выбор второго товара
        addToCart();

        goToSquareOne();
        click(By.cssSelector(("div #box-latest-products a.link[href*=p-4"))); // выбор третьего товара
        addToCart();

        goToCheckout();                                                                     // переход в чекаут
        removeFromCart();                                                                  // удаление товара
        wait.until(numberOfElementsToBe(By.cssSelector(                        // явное ожидание удаления элемента из таблицы
                "table.dataTable td.item"),2));

        removeFromCart();
        wait.until(numberOfElementsToBe(By.cssSelector(                       // явное ожидание удаления элемента из таблицы
                "table.dataTable td.item"),1));

        removeFromCart();
        wait.until(textToBePresentInElementLocated(By.cssSelector(
                "#checkout-cart-wrapper"),"There are no items in your cart."));  // явное ожидание полной очистки корзины
    }

}
