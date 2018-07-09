package eventFiringWD;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

public class ToolBox extends TestBase {

    /**
     * Методы
     */


    /**
     *    Проверка наличия только ОДНОГО элемента в списке
     */

    public boolean isOneElementPresent(By locator) {         // Проверка наличия одного элемента
        return wd.findElements(locator).size() == 1;
    }


    /**
     *    Клик по элементу
     */

    public void click(By locator) {                                    // клик по элементу
        wd.findElement(locator).click();
    }

    /**
     *   Переход в чекаут ( lifeCart)
     */

    public void goToCheckout() {                                    // переход в чекаут
        click(By.cssSelector("a.link[href$=checkout"));
    }

    /**
     *   Добавление в корзину с явным ожиданием ( lifeCart)
     */

    public void addToCart() {                                          // добавление товара в корзину c явным ожиданием увеличения счётчика

        String quantityParam = wd.findElement(By.cssSelector("[href$=checkout] .quantity"))
                .getAttribute("textContent");                                 // значение счётчика товаров в корзине до добавления
        int quantity = Integer.parseInt(quantityParam);

        click(By.cssSelector("button[name=add_cart_product]"));                        // добавление товара в корзину

        WebDriverWait expWait = new WebDriverWait(wd, 5);                     //  явное ожидание в 5 с (при старте браузера установлено  10)
        WebElement counter = wd.findElement(By.cssSelector("[href$=checkout].content"));
        expWait.until(textToBePresentInElement
                (counter, quantity + 1 + " item(s)"));                                          //явное ожидание инкремента счётчика товаров в корзине
    }

    /**
     *   Валидация текста на странице по атрибуту textContent
     */
    public void validateByTextContent(By locator, String expectedText) {           // валидация текста на странице

        WebElement element = wd.findElement(locator);                           // находим элемент
        String actualText = element.getAttribute("textContent");             // получаем атрибут textContent
        Assert.assertEquals(actualText, expectedText);                                  // валидация текста
    }

    /**
     *   Валидация текста на странице по атрибуту outerText
     */
    public void validateByOuterText(By locator, String expectedText) {           // проверка текста на странице

        WebElement element = wd.findElement(locator);                           // находим элемент
        String actualText = element.getAttribute("outerText");             // получаем атрибут outerText
        Assert.assertEquals(actualText, expectedText);                                  // валидация заголовка на карточке товара
    }

    /**
     *    Возврат на главную (liteCart)
     */

    public void goToSquareOne() {                                 //  переход на главную
        click(By.cssSelector("img[title='My Store']"));
    }

}
