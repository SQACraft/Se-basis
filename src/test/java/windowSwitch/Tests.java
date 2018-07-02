package windowSwitch;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.annotations.Test;

import java.util.Set;

public class Tests extends ToolBox {

    @Test
    void windowSwitch() throws InterruptedException {

        String windowHandler = wd.getWindowHandle();   //дескриптор текущего открытого окна, уникально идентифицирующий окно для этого экземпляра драйвера.
                                                                          //  формат:   CDwindow-6498D1E2412A03630E4D0A63EC96CF82 )

        Set<String> oldWindowsSet = wd.getWindowHandles();  //набор дескрипторов окон. Сейчас в нём 1 дескриптор
                                                                          //      [CDwindow-3C23FA39040CC89365E9BC1582F74491]

        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("window.open()");                         // открываем второе окно

        String newWindowHandler = wait.until
                (new ExpectedCondition<String>() {          // искомый дескриптор второго окна после ожидания

             public String apply(WebDriver wd) {

                 Set<String> newWindowsSet = wd.getWindowHandles();   //набор дескрипторов окон после открытия второго окна
                 newWindowsSet.removeAll(oldWindowsSet);

                 return newWindowsSet.size() > 0 ?
                         newWindowsSet.iterator().next() : null;
             }
        }   );


        System.out.println(newWindowHandler);

/*

        Set<String> oldWindowsSet = wd.getWindowHandles();  //набор дескрипторов окон, для перебора всех открытых окон для данного экземпляра wd
        System.out.println(oldWindowsSet);                             // 2 окна:     [CDwindow-3C23FA39040CC89365E9BC1582F74491, CDwindow-F886659C2375F340B5FAC3393B7E5C2F]

        js.executeScript("window.open()");                           // открываем третье окно

        Set<String> newWindowsSet = wd.getWindowHandles();  // новый набор дескрипторов, включающий уже и новое окно
        System.out.println(newWindowsSet);

        newWindowsSet.removeAll(oldWindowsSet);
        String newWindowHandler = newWindowsSet.iterator().next();   // дескриптор нового (последнего) окна - исключены дескрипторы первых двух окон


        System.out.println(newWindowHandler);
*/

    }

}
