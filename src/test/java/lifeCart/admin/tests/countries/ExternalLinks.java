package lifeCart.admin.tests.countries;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import lifeCart.admin.appManager.ToolBox;

import java.util.Set;

public class ExternalLinks extends ToolBox {

    @Test
    void checkExternalLink() {

        click(By.cssSelector("[href$=countries]"));
        validateByOuterText(By.cssSelector("#content h1"), " Countries"); // Валидация заголовка

        click(By.cssSelector("a:not([title=Edit])[href$='code=DZ']"));   // использовали :not() в локаторе сылки для редактирования страны Algeria

        String initWindowHandler = wd.getWindowHandle();   //дескриптор текущего открытого окна
        Set<String> oldWindowsSet = wd.getWindowHandles();  //набор дескрипторов окон. Сейчас в нём 1 дескриптор

        click(By.cssSelector("[href$='ISO_3166-1_alpha-2']")); // клик по внешней ссылке для открытия второго окна
        String newWindowHandler = getNewWindowHandler(oldWindowsSet);  // ожидание открытия второго окна + получение его дескриптора

        wd.switchTo().window(newWindowHandler);  // переключаемся в новое окно
        validateByTextContent(By.cssSelector(".firstHeading"), "ISO 3166-1 alpha-2");

        wd.close();
    }

}