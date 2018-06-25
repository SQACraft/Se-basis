package lifeCart.admin.sidebar;

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
    void openCountriesSection() {
        click(By.cssSelector("[href$=countries]"));
        validateByOuterText(By.cssSelector("#content h1")," Countries"); // Валидация заголовка
    }

    @Test(priority = 21)
    void openCurrenciesSection() {
        click(By.cssSelector("[href$=currencies]"));
        validateByOuterText(By.cssSelector("#content h1")," Currencies");
    }


}