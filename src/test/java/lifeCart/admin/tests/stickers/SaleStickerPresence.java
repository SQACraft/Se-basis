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


        click(By.cssSelector("nav.content [href*='c-1/']"));
        Assert.assertTrue(areElementsPresent(By.xpath("//h1[contains(text(), 'Rubber Ducks')]")));
        // click(By.cssSelector("[href$='subcategory-c-2/']"));
   //   Assert.assertTrue(areElementsPresent(By.xpath("//h1[contains(text(), 'Subcategory')]")));
    }

}