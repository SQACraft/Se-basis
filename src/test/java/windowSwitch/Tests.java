package windowSwitch;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

        String newWindowHandler = getNewWindowHandler(oldWindowsSet);  // ожидание открытия второго окна + получение его дескриптора

        wd.switchTo().window(newWindowHandler);  // переключаемся в новое окно
        search("ЛИСА");

        wd.switchTo(). window(initWindowHandler);  // переключаемся в первое окно
        click(By.cssSelector("[href$='software-testing.ru/'] .no_thumbnail"));
        System.out.println(" ");

        wd.switchTo().window(newWindowHandler);  // переключаемся в новое окно
        wd.close();                                              // закрваем новое окно

    }

}
