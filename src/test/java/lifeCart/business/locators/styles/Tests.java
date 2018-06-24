package lifeCart.business.locators.styles;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Tests extends TestBase {

    @Test
    void checkStyles() {

        click(By.cssSelector(("div #box-most-popular a.link[href*=p-1"))); // выбор   товара в блоке Campaigns
        Assert.assertTrue(isOneElementPresent(By.xpath
                ("//h1[contains(text(), 'Yellow Duck')]")));                      // проверка заголовка на карточке товара

        validateText(By.cssSelector("#box-product .title"), "Yellow Duck");

    }
}