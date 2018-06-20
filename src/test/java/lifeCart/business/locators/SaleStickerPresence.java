package lifeCart.business.locators;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SaleStickerPresence extends TestBase {

    /**
     * Проверка наличия стикера SALE на карточке товара
     */

    @Test
    public void checkSaleStickerPresence() {

        click(By.cssSelector("nav.content [href*='c-1/']"));                                                       // переход в  раздел

        Assert.assertTrue(isOneElementPresent(By.xpath
                ("//h1[contains(text(), 'Rubber Ducks')]")));                                                         // проверка заголовка раздела

        click(By.cssSelector("nav.content [href*='c-2/']"));                                                       // переход в подраздел

        Assert.assertTrue(isOneElementPresent(By.xpath(
                "//h1[contains(text(), 'Subcategory')]")));                                                           // проверка заголовка подраздела

        Assert.assertTrue(isOneElementPresent(By.cssSelector(
                "a.link[href*=p-1] div.sticker.sale")));                                                                 // проверка наличия стикера SALE у товара Yellow Duck

        Assert.assertTrue(isOneElementPresent(By.cssSelector(
                "a.link[href*=p-1] strong.campaign-price")));                                                        // проверка наличия цены со скидкой

        Assert.assertTrue(isOneElementPresent(By.xpath(
                ".//*[@id='box-category']/div/ul/li[1]/a[1]/div[5]/strong[contains(text(), '$18')]")));    // проверка значения цены со скидкой
    }

}
