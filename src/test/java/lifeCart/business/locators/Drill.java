package lifeCart.business.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Drill extends TestBase {

    /**
     * 1. Локатор для поиска  всех блоков (li) с информацией о товарах
     * (каждому товару соответствует свой блок)
     */

    @Test(priority = 1)
    public void productBlocks() {

        By locator;

        // Блок Most Popular
        locator = (By.cssSelector(("div #box-most-popular .product")));
        Assert.assertTrue(areElementsPresent(locator));
        System.out.println("Tests One Results: \n*****************");    // вывод количества элементов
        getNumOfElementsFound(locator);

        // Блок Campaigns
        locator = (By.cssSelector(("div #box-campaigns .product")));
        Assert.assertTrue(areElementsPresent(locator));
        getNumOfElementsFound(locator);

        // Блок Latest Products
        locator = (By.cssSelector(("div #box-latest-products .product")));
        Assert.assertTrue(areElementsPresent(locator));
        getNumOfElementsFound(locator);
    }

    /**
     * 2. Локатор для поиска  всех ссылок (a) на страницы товаров
     * в основной части страницы  (не считая боковых блоков)
     */

    @Test(priority = 2)
    public void goodsLinks() {

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

    @Test(priority = 3)
    public void privacyPolicyLink() {

        click(By.cssSelector("#footer [href*='privacy-policy']"));    // клик по ссылке
        Assert.assertTrue(isOneElementPresent(By.xpath(
                "//h1[contains(text(), 'Privacy Policy')]")));               // проверка заголовка
    }

    /**
     * 4. Подберите локатор для поиска всех элементов верхнего меню,
     * находящихся на верхнем уровне (без элементов вложенных выпадающих меню)
     */

    @Test(priority = 4)
    public void siteMenu() {

        click(By.cssSelector("#site-menu [href$='ducks-c-1/']"));    // клик по ссылке
        Assert.assertTrue(isOneElementPresent(By.xpath(
                "//h1[contains(text(), 'Rubber Ducks')]")));               // проверка заголовка
    }

    /**
     * 5. Локатор для поиска на странице /create_account
     * элемента с текстом United States из выпадающего списка стран
     * 6. локатор списка выбора штата
     */

    @Test(priority = 5)
    public void countriesList() {

        click(By.cssSelector("td.account [href$='create_account']"));   // клик по ссылке
        Assert.assertTrue(isOneElementPresent(By.xpath(
                "//h1[contains(text(), 'Create Account')]")));                // проверка заголовка

        click(By.cssSelector("span.select2-selection__arrow"));          // раскрыли комбобокс

        wd.findElement(By.cssSelector("input.select2-search__field"))
                .sendKeys("United States");                                                 // ввод наименования страны в комбобоксе

        wd.findElement(By.cssSelector("span.select2-selection.select2-selection--single"))
                .sendKeys(Keys.ENTER);                                                               // выбор в комбобоксе по Enter

        wd.findElement(By.cssSelector("select[name=zone_code]"));                                 // локатор списка штатов
    }

    /**
     * 7. Локатор для поиска кнопки сортировки товаров по дате
     */

    @Test
    public void sortButton() {

        click(By.cssSelector("nav.content [href*='c-1/']"));                                                       // переход в  раздел
        Assert.assertTrue(isOneElementPresent(By.xpath
                ("//h1[contains(text(), 'Rubber Ducks')]")));                                                         // проверка заголовка раздела
        click(By.cssSelector(("a[href$='sort=date']")));                                                 // кнопка сортировки по дате
    }

}