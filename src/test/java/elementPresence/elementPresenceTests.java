package elementPresence;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class elementPresenceTests extends TestBase {


    @Test
    void checkElementPresence() {
/**
 Проверка наличия элемента с использованием findElement()  + try-catch
 */
        Assert.assertTrue(isElementPresent(By.cssSelector("div #search #text")));
    }

    @Test
    void checkElementsPresence() {
/**
 Проверка наличия элемента с использованием findElements()  +size() > 0
 */
        Assert.assertTrue(areElementsPresent(By.cssSelector("div #search #text")));
    }

    @Test
    void checkElementAbsence() {
/**
 Проверка отсутствия элемента с использованием findElement()  + try-catch
 */
        Assert.assertFalse(isElementPresent(By.name("XXX")));
    }

    @Test
    void checkElementsAbsence() {

/**
 Проверка отсутствия элемента с использованием findElements()  +size() > 0
 */
        Assert.assertFalse(areElementsPresent(By.name("XXX")));
    }

    @Test
    void checkWrongXPath() {

/**
 Проверка выброса  InvalidSelectorException  как подкласса NoSuchElementException
 в случае некоректного формата XPath.
 Тест должен падать с InvalidSelectorException.
 */
        Assert.assertFalse(isElementPresent(By.xpath("div[")));
    }

}
