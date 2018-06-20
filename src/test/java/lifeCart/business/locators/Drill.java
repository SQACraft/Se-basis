package lifeCart.business.locators;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Drill extends TestBase {

    /**
     * 1. Локатор для поиска  всех блоков (li) с информацией о товарах
     * (каждому товару соответствует свой блок)
     */
    @Test
    public void TestOne() {

        By locator;

        // Блок Most Popular
        locator = (By.cssSelector(("div #box-most-popular li.product.column")));
        Assert.assertTrue(areElementsPresent(locator));
        numberOfElementsFound(locator);

        // Блок Campaigns
        locator = (By.cssSelector(("div #box-campaigns li.product.column")));
        Assert.assertTrue(areElementsPresent(locator));
        numberOfElementsFound(locator);

        // Блок Latest Products
        locator = (By.cssSelector(("div #box-latest-products li.product.column")));
        Assert.assertTrue(areElementsPresent(locator));
        numberOfElementsFound(locator);
    }

    /**
     * 2. Локатор для поиска  всех ссылок (a) на страницы товаров
     * в основной части страницы  (не считая боковых блоков)
     */
    @Test
    public void TestTwo() {

        // Блок Most Popular
        Assert.assertTrue(isOneElementPresent(By.cssSelector(("div #box-most-popular a.link[href*=p-3"))));
        Assert.assertTrue(isOneElementPresent(By.cssSelector(("div #box-most-popular a.link[href*=p-1"))));
        Assert.assertTrue(isOneElementPresent(By.cssSelector(("div #box-most-popular a.link[href*=p-5"))));
        Assert.assertTrue(isOneElementPresent(By.cssSelector(("div #box-most-popular a.link[href*=p-4"))));

        // Блок Campaigns
        Assert.assertTrue(isOneElementPresent(By.cssSelector(("div #box-campaigns a.link[href*=p-1"))));

        // Блок Latest Products
        Assert.assertTrue(isOneElementPresent(By.cssSelector(("div #box-latest-products a.link[href*=p-1"))));
        Assert.assertTrue(isOneElementPresent(By.cssSelector(("div #box-latest-products a.link[href*=p-2"))));
        Assert.assertTrue(isOneElementPresent(By.cssSelector(("div #box-latest-products a.link[href*=p-3"))));
        Assert.assertTrue(isOneElementPresent(By.cssSelector(("div #box-latest-products a.link[href*=p-4"))));
        Assert.assertTrue(isOneElementPresent(By.cssSelector(("div #box-latest-products a.link[href*=p-5"))));
    }

    /**
     * 3. Локатор для поиска  ссылки на Privacy Policy в нижней части страницы
     */
    @Test
    public void TestThree() {

        click(By.cssSelector("td.information [href$='policy-i-3']"));
    }
}