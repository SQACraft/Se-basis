package windowSwitchAndResize;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.Set;

public class ToolBox extends TestBase {

    /**
     * Методы
     */

    /**
     *    Поиск на Башорге
     */
    void search(String animal) {

        wd.get("https://bash.im/");
        // wd.findElement(By.name("text")).sendKeys(animal);
        //wd.findElement(By.xpath(".//*[@id='search']/button")).click();
        wd.findElement(By.cssSelector("div #search #text")).sendKeys(animal);
        wd.findElement(By.cssSelector("div #search [type=submit]")).click();
    }

    /**
     *    Клик по элементу
     */

    public void click(By locator) {                                    // клик по элементу
        wd.findElement(locator).click();
    }

    /**
     *    Ожидание открытия нового  окна + получение его дескриптора
     */

    String getNewWindowHandler(Set<String> oldWindowsSet) {    // ожидание открытия нового  окна + получение его дескриптора. Параметр -
        // набор дескрипторов уже открытых окон:   Set<String> oldWindowsSet = wd.getWindowHandles();

        String newWindowHandler = wait.until                // искомый дескриптор второго окна
                (new ExpectedCondition<String>() {          // конструируем ожидание открытия окна с получением его  дескриптора

                     public String apply(WebDriver wd) {

                         Set<String> newWindowsSet = wd.getWindowHandles();   //новый набор дескрипторов окон после открытия второго окна
                         newWindowsSet.removeAll(oldWindowsSet);                   // убираем дескрипторы открытых ранее окон
                         return newWindowsSet.size() > 0 ?
                                 newWindowsSet.iterator().next() : null;
                     }
                 }
                );
        return newWindowHandler;
    }

}

