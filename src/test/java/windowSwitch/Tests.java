package windowSwitch;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.annotations.Test;

import java.util.Set;

public class Tests extends ToolBox {

    @Test
    void windowSwitch()   {

       String initWindowHandler = wd.getWindowHandle();   //дескриптор текущего открытого окна, уникально идентифицирующий окно для этого экземпляра драйвера.
                                                                          //  формат:   CDwindow-6498D1E2412A03630E4D0A63EC96CF82 )

        Set<String> oldWindowsSet = wd.getWindowHandles();  //набор дескрипторов окон. Сейчас в нём 1 дескриптор
                                                                          //      [CDwindow-3C23FA39040CC89365E9BC1582F74491]

        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("window.open()");                         // открываем второе окно

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

        wd.switchTo().window(newWindowHandler);  // переключаемся в новое окно
        search("ЛИСА");

        wd.switchTo(). window(initWindowHandler);  // переключаемся в первое окно
        click(By.cssSelector("[href$='software-testing.ru/'] .no_thumbnail"));
        System.out.println(" ");

        wd.switchTo().window(newWindowHandler);  // переключаемся в новое окно
        wd.close();                                              // закрваем новое окно

    }

}
