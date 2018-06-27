package lifeCart.admin.tests.sidebar;

import lifeCart.admin.appManager.ToolBox;
import lifeCart.admin.sidebar.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Customers extends ToolBox {

    /**
     * Проверки открытия разделов сайдбара:
     * -редирект на главную
     * - открытие раздела / подраздела
     * - проверка соответствия заголовка ожидаемому
     */

    @Test(priority = 16)
    void openCustomersSection() {
        click(By.cssSelector("[href$=customers]"));
        validateByOuterText(By.cssSelector("#content h1")," Customers"); // Валидация заголовка

    }

    @Test(priority = 17)
    void openCustomersSubSection() {
        click(By.cssSelector("[href$=customers]"));
        click(By.cssSelector("#doc-customers a"));
        validateByOuterText(By.cssSelector("#content h1")," Customers");

    }

    @Test(priority = 18)
    void openCSVSubSection() {
        click(By.cssSelector("[href$=customers]"));
        click(By.cssSelector("#doc-csv  a"));
        validateByOuterText(By.cssSelector("#content h1")," CSV Import/Export");

    }

    @Test(priority = 19)
    void openNewsletterSubSection() {
        click(By.cssSelector("[href$=customers]"));
        click(By.cssSelector("#doc-newsletter  a"));
        validateByOuterText(By.cssSelector("#content h1")," Newsletter");

    }
}