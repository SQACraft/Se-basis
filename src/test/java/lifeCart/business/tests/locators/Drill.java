package lifeCart.business.tests.locators;

import lifeCart.business.appManager.ToolBox;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Drill extends ToolBox {

    /**
     * 1. Локатор для поиска  всех блоков (li) с информацией о товарах
     * (каждому товару соответствует свой блок)
     */

    @Test (groups = "Drill")
      void productBlocks() {

        goToSquareOne();
        By locator;

        // Блок Most Popular
        locator = (By.cssSelector(("div #box-most-popular .product")));
        Assert.assertTrue(areElementsPresent(locator));
        System.out.println("Test One Results: \n*****************");    // вывод количества элементов
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

    @Test (groups = "Drill")
    void goodsLinks() {

        goToSquareOne();

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

    @Test (groups = "Drill")
    void privacyPolicyLink() {

        goToSquareOne();
        click(By.cssSelector("#footer [href*='privacy-policy']"));    // клик по ссылке
        Assert.assertTrue(isOneElementPresent(By.xpath(
                "//h1[contains(text(), 'Privacy Policy')]")));               // проверка заголовка
    }

    /**
     * 4. Подберите локатор для поиска всех элементов верхнего меню,
     * находящихся на верхнем уровне (без элементов вложенных выпадающих меню)
     */

    @Test (groups = "Drill")
    void siteMenu() {

        goToSquareOne();
        click(By.cssSelector("#site-menu [href$='ducks-c-1/']"));    // клик по ссылке
        validateByTextContent(By.cssSelector(".content h1"),
                "Rubber Ducks");                                                    // проверка заголовка
    }

    /**
     * 5. Локатор для поиска на странице /create_account
     * элемента с текстом United States из выпадающего списка стран
     * 6. локатор списка выбора штата
     */

    @Test (groups = "Drill")
    void countriesList() {

        goToSquareOne();
        click(By.cssSelector("td.account [href$='create_account']"));   // клик по ссылке
        validateByTextContent(By.cssSelector(".content h1"),
                "Create Account");                                                    // проверка заголовка

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

    @Test (groups = "Drill")

    void sortButton() {

        goToSquareOne();
        click(By.cssSelector("nav.content [href*='c-1/']"));                                                       // переход в  раздел Rubber Ducks
        validateByTextContent(By.cssSelector(".content h1"),
                "Rubber Ducks");                                                    // проверка заголовка

        click(By.cssSelector(("a[href$='sort=date']")));                                                 // кнопка сортировки по дате
    }

}