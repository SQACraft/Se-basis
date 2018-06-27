package lifeCart.admin.tests.sidebar;

import lifeCart.admin.appManager.ToolBox;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Catalog extends ToolBox {

    /**
     * Проверки открытия разделов сайдбара:
     * -редирект на главную
     * - открытие раздела / подраздела
     * - проверка соответствия заголовка ожидаемому
     */

    @Test(priority = 4)
    void openCatalogSection() {
        click(By.cssSelector("[href$=catalog]"));
        validateByOuterText(By.cssSelector("#content h1")," Catalog");  // Валидация заголовка
    }

    @Test(priority = 5)
    void openCatalogSubSection() {
        click(By.cssSelector("[href$=catalog]"));
        click(By.cssSelector("#doc-catalog  a"));
        validateByOuterText(By.cssSelector("#content h1")," Catalog");
    }

    @Test(priority = 6)
    void openProductGroupsSubSection() {
        click(By.cssSelector("[href$=catalog]"));
        click(By.cssSelector("#doc-product_groups  a"));
        validateByOuterText(By.cssSelector("#content h1")," Product Groups");
    }

    @Test(priority = 7)
    void openOptionGroupsSubSection() {
        click(By.cssSelector("[href$=catalog]"));
        click(By.cssSelector("#doc-option_groups a"));
        validateByOuterText(By.cssSelector("#content h1")," Option Groups");
    }

    @Test(priority = 8)
    void openManufacturersSubSection() {
        click(By.cssSelector("[href$=catalog]"));
        click(By.cssSelector("#doc-manufacturers  a"));
        validateByOuterText(By.cssSelector("#content h1")," Manufacturers");
    }

    @Test(priority = 9)
    void openSuppliersSubSection() {
        click(By.cssSelector("[href$=catalog]"));
        click(By.cssSelector("#doc-suppliers  a"));
        validateByOuterText(By.cssSelector("#content h1")," Suppliers");
    }

    @Test(priority = 10)
    void openDeliveryStatusesSubSection() {
        click(By.cssSelector("[href$=catalog]"));
        click(By.cssSelector("#doc-delivery_statuses  a"));
        validateByOuterText(By.cssSelector("#content h1")," Delivery Statuses");
    }

    @Test(priority = 11)
    void openSoldOutStatusesSubSection() {
        click(By.cssSelector("[href$=catalog]"));
        click(By.cssSelector("#doc-sold_out_statuses  a"));
        validateByOuterText(By.cssSelector("#content h1")," Sold Out Statuses");
    }

    @Test(priority = 12)
    void openQuantityUnitsSubSection() {
        click(By.cssSelector("[href$=catalog]"));
        click(By.cssSelector("#doc-quantity_units  a"));
        validateByOuterText(By.cssSelector("#content h1")," Quantity Units");
    }

    @Test(priority = 13)
    void openCSVSubSection() {
        click(By.cssSelector("[href$=catalog]"));
        click(By.cssSelector("#doc-csv  a"));
        validateByOuterText(By.cssSelector("#content h1")," CSV Import/Export");
    }

    @Test(priority = 14)
    void openCountriesSection() {
        click(By.cssSelector("[href$=countries]"));
        validateByOuterText(By.cssSelector("#content h1")," Countries");
    }

    @Test(priority = 15)
    void openCurrenciesSection() {
        click(By.cssSelector("[href$=currencies]"));
        validateByOuterText(By.cssSelector("#content h1")," Currencies");
    }


}