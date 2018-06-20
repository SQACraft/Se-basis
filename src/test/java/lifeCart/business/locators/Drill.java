package lifeCart.business.locators;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Drill extends TestBase{

 /**
*       1. Локатор для поиска  всех блоков (li) с информацией о товарах
*       (каждому товару соответствует свой блок)
*/
    @Test
    public void TestOne() {

        Assert.assertTrue(isOneElementPresent(By.cssSelector(("div #box-most-popular a.link[href*=p-3"))));
        Assert.assertTrue(isOneElementPresent(By.cssSelector(("div #box-most-popular a.link[href*=p-1"))));
        Assert.assertTrue(isOneElementPresent(By.cssSelector(("div #box-most-popular a.link[href*=p-5"))));
        Assert.assertTrue(isOneElementPresent(By.cssSelector(("div #box-most-popular a.link[href*=p-4"))));
    }

/**
*        2. Подберите локатор для поиска  всех ссылок (a) на страницы товаров
*        в основной части страницы  (не считая боковых блоков)
*/





}