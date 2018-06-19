package lifeCart.admin.tests.stickers;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SaleStickerPresence extends TestBase {

    /**
     * Проверка наличия стикера SALE на карточке товара
     */

    @Test
    public void checkSaleStickerPresence() {

        click(By.cssSelector("nav.content [href*='c-1/']"));                                                        // переход в  раздел
        Assert.assertTrue(areElementsPresent(By.xpath("//h1[contains(text(), 'Rubber Ducks')]"))); // проверка заголовка раздела
        click(By.cssSelector("nav.content [href*='c-2/']"));                                                       // переход в подраздел
        Assert.assertTrue(areElementsPresent(By.xpath("//h1[contains(text(), 'Subcategory')]")));  // проверка заголовка подраздела
        Assert.assertTrue(areElementsPresent(By.cssSelector("a.link[href*=p-1] div.sticker.sale"))); // проверка наличия стикера SALE у товара Yellow Duck

        /** TODO -  проверка наличия скидки у товара Yellow Duck
         * Assert.assertTrue(areElementsPresent(By.cssSelector("a.link[href*=p-1] div.sticker.sale"))); // проверка наличия скидки у товара Yellow Duck
         *
         * */
    }

}
