package lifeCart.admin.tests.sidebar;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SingleSections extends TestBase {

    /**
     * Проверки открытия разделов сайдбара:
     * -редирект на главную
     * - открытие раздела / подраздела
     * - проверка соответствия заголовка ожидаемому
     */

    @Test(priority = 20)
    public void openCountriesSection() {
        click(By.cssSelector("[href$=countries]"));
        Assert.assertTrue(areElementsPresent(By.xpath("//h1[contains(text(), 'Countries')]")));
    }

    @Test(priority = 21)
    public void openCurrenciesSection() {
        click(By.cssSelector("[href$=currencies]"));
        Assert.assertTrue(areElementsPresent(By.xpath("//h1[contains(text(), 'Currencies')]")));
    }


}