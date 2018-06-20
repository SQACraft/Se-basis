package lifeCart.admin.sidebar;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Catalog extends TestBase {

    /**
     * Проверки открытия разделов сайдбара:
     * -редирект на главную
     * - открытие раздела / подраздела
     * - проверка соответствия заголовка ожидаемому
     */

    @Test(priority = 4)
    public void openCatalogSection() {
        click(By.cssSelector("[href$=catalog]"));
        Assert.assertTrue(areElementsPresent(By.xpath("//h1[contains(text(), 'Catalog')]")));
    }

    @Test(priority = 5)
    public void openCatalogSubSection() {
        click(By.cssSelector("[href$=catalog]"));
        click(By.cssSelector("#doc-catalog  a"));
        Assert.assertTrue(areElementsPresent(By.xpath("//h1[contains(text(), 'Catalog')]")));
    }

    @Test(priority = 6)
    public void openProductGroupsSubSection() {
        click(By.cssSelector("[href$=catalog]"));
        click(By.cssSelector("#doc-product_groups  a"));
        Assert.assertTrue(areElementsPresent(By.xpath("//h1[contains(text(), 'Product Groups')]")));
    }

    @Test(priority = 7)
    public void openOptionGroupsSubSection() {
        click(By.cssSelector("[href$=catalog]"));
        click(By.cssSelector("#doc-option_groups a"));
        Assert.assertTrue(areElementsPresent(By.xpath("//h1[contains(text(), 'Option Groups')]")));
    }

    @Test(priority = 8)
    public void openManufacturersSubSection() {
        click(By.cssSelector("[href$=catalog]"));
        click(By.cssSelector("#doc-manufacturers  a"));
        Assert.assertTrue(areElementsPresent(By.xpath("//h1[contains(text(), 'Manufacturers')]")));
    }

    @Test(priority = 9)
    public void openSuppliersSubSection() {
        click(By.cssSelector("[href$=catalog]"));
        click(By.cssSelector("#doc-suppliers  a"));
        Assert.assertTrue(areElementsPresent(By.xpath("//h1[contains(text(), 'Suppliers')]")));
    }

    @Test(priority = 10)
    public void openDeliveryStatusesSubSection() {
        click(By.cssSelector("[href$=catalog]"));
        click(By.cssSelector("#doc-delivery_statuses  a"));
        Assert.assertTrue(areElementsPresent(By.xpath("//h1[contains(text(), 'Delivery Statuses')]")));
    }

    @Test(priority = 11)
    public void openSoldOutStatusesSubSection() {
        click(By.cssSelector("[href$=catalog]"));
        click(By.cssSelector("#doc-sold_out_statuses  a"));
        Assert.assertTrue(areElementsPresent(By.xpath("//h1[contains(text(), 'Sold Out Statuses')]")));
    }

    @Test(priority = 12)
    public void openQuantityUnitsSubSection() {
        click(By.cssSelector("[href$=catalog]"));
        click(By.cssSelector("#doc-quantity_units  a"));
        Assert.assertTrue(areElementsPresent(By.xpath("//h1[contains(text(), 'Quantity Units')]")));
    }

    @Test(priority = 13)
    public void openCSVSubSection() {
        click(By.cssSelector("[href$=catalog]"));
        click(By.cssSelector("#doc-csv  a"));
        Assert.assertTrue(areElementsPresent(By.xpath("//h1[contains(text(), 'CSV Import/Export')]")));
    }

    @Test(priority = 14)
    public void openCountriesSection() {
        click(By.cssSelector("[href$=countries]"));
        Assert.assertTrue(areElementsPresent(By.xpath("//h1[contains(text(), 'Countries')]")));
    }

    @Test(priority = 15)
    public void openCurrenciesSection() {
        click(By.cssSelector("[href$=currencies]"));
        Assert.assertTrue(areElementsPresent(By.xpath("//h1[contains(text(), 'Currencies')]")));
    }


}