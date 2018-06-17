package elementsPresence;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class elementsPresenceTests extends TestBase {


    @Test
    public void checkElementPresence() {
/**
    Проверка наличия элемента с использованием findElement()  + try-catch
*/
        Assert.assertTrue(isElementPresent(By.cssSelector("div #search #text")));
    }

    @Test
    public void checkElementsPresence() {
/**
 Проверка наличия элемента с использованием findElements()  +size() > 0
 */
        Assert.assertTrue(areElementsPresent(By.cssSelector("div #search #text")));
    }

    @Test
    public void checkElementAbsence() {
/**
 Проверка отсутствия элемента с использованием findElement()  + try-catch
 */
        Assert.assertFalse(isElementPresent(By.name("XXX")));
    }

    @Test
    public void checkElementsAbsence() {

/**
 Проверка отсутствия элемента с использованием findElements()  +size() > 0
 */
        Assert.assertFalse(areElementsPresent(By.name("XXX")));
    }

}
