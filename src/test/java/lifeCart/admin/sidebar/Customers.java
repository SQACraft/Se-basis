package lifeCart.admin.sidebar;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Customers extends TestBase {

    /**
     * Проверки открытия разделов сайдбара:
     * -редирект на главную
     * - открытие раздела / подраздела
     * - проверка соответствия заголовка ожидаемому
     */

    @Test(priority = 16)
    void openCustomersSection() {
        click(By.cssSelector("[href$=customers]"));
        Assert.assertTrue(areElementsPresent(By.xpath("//h1[contains(text(), 'Customers')]")));
    }

    @Test(priority = 17)
    void openCustomersSubSection() {
        click(By.cssSelector("[href$=customers]"));
        click(By.cssSelector("#doc-customers a"));
        Assert.assertTrue(areElementsPresent(By.xpath("//h1[contains(text(), 'Customers')]")));
    }

    @Test(priority = 18)
    void openCSVSubSection() {
        click(By.cssSelector("[href$=customers]"));
        click(By.cssSelector("#doc-csv  a"));
        Assert.assertTrue(areElementsPresent(By.xpath("//h1[contains(text(), 'CSV Import/Export')]")));
    }

    @Test(priority = 19)
    void openNewsletterSubSection() {
        click(By.cssSelector("[href$=customers]"));
        click(By.cssSelector("#doc-newsletter  a"));
        Assert.assertTrue(areElementsPresent(By.xpath("//h1[contains(text(), 'Newsletter')]")));
    }
}