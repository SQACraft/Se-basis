package lifeCart.business.locators;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SaleSticker extends TestBase {

    /**
     * Проверка :
     * 1. наличия стикера SALE на карточке товара в подразделе
     * 2. цены со скидкой
     * 3. зума изображения
     */

    @Test(priority = 1)
    public void checkSaleStickerPresence() throws InterruptedException {

        click(By.cssSelector("nav.content [href*='c-1/']"));                                                       // переход в  раздел Rubber Ducks

        Assert.assertTrue(isOneElementPresent(By.xpath
                ("//h1[contains(text(), 'Rubber Ducks')]")));                                                         // проверка заголовка раздела

        click(By.cssSelector("nav.content [href*='c-2/']"));                                                       // переход в подраздел Subcategory

        Assert.assertTrue(isOneElementPresent(By.xpath(
                "//h1[contains(text(), 'Subcategory')]")));                                                           // проверка заголовка подраздела

        Assert.assertTrue(isOneElementPresent(By.cssSelector(
                "a.link[href*=p-1] div.sticker.sale")));                                                                 // проверка наличия стикера SALE у товара Yellow Duck

        Assert.assertTrue(isOneElementPresent(By.cssSelector(
                "a.link[href*=p-1] strong.campaign-price")));                                                        // проверка наличия цены со скидкой

        Assert.assertTrue(isOneElementPresent(By.xpath(
                ".//*[@id='box-category']/div/ul/li[1]/a[1]/div[5]/strong[contains(text(), '$18')]")));    // проверка значения цены со скидкой

        click(By.xpath(".//*[@id='box-category']/div/ul/li[1]/a[2]/i"));                                          // клик по значку линзы для зума

        Thread.sleep(1000);                                                                                        // пауза для просмотра изображения в зуме
    }

    /**
     * Проверка :
     * 1. наличия стикера SALE на карточке товара в разделе
     * 2. отсутствия стикера на карточке товара
     */
    @Test(priority = 2)
    public void checkSaleStickerAbsence() {

        click(By.cssSelector("nav.content [href*='c-1/']"));                                                       // переход в  раздел Rubber Ducks
        Assert.assertTrue(isOneElementPresent(By.xpath
                ("//h1[contains(text(), 'Rubber Ducks')]")));                                                         // проверка заголовка раздела

        Assert.assertTrue(isOneElementPresent(By.cssSelector(
                "a.link[href*=p-1] div.sticker.sale")));                                                                 // проверка наличия стикера SALE у товара Yellow Duck
        Assert.assertFalse(isOneElementPresent(By.cssSelector(
                "a.link[href*=p-2] div.sticker.sale")));                                                                 // проверка отсутствия стикера SALE у товара Green Duck
    }


}