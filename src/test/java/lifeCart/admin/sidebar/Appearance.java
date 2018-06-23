package lifeCart.admin.sidebar;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Appearance extends TestBase {

    /**
     * Проверки открытия разделов сайдбара:
     * -редирект на главную
     * - открытие раздела / подраздела
     * - проверка соответствия заголовка ожидаемому
     */

    @Test(priority = 1)
    void openAppearanceSection() {
        click(By.cssSelector("[href$=template]"));
        Assert.assertTrue(areElementsPresent(By.xpath("//h1[contains(text(), 'Template')]")));
    }

    @Test(priority = 2)
    void openTemplateSubSection() {
        click(By.cssSelector("[href$=template]"));
        click(By.cssSelector("#doc-template a"));
        Assert.assertTrue(areElementsPresent(By.xpath("//h1[contains(text(), 'Template')]")));
    }

    @Test(priority = 3)
    void openLogotypeSubSection() {
        click(By.cssSelector("[href$=template]"));
        click(By.cssSelector("#doc-logotype  a"));
        Assert.assertTrue(areElementsPresent(By.xpath("//h1[contains(text(), 'Logotype')]")));
    }

}