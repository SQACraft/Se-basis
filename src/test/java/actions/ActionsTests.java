package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class ActionsTests extends TestBase {

    @Test
    void testTemplate() {

        List <WebElement> leftList = wd.findElements(By.cssSelector("#sortable1 li"));    // список элементов - левой колонки ячеек   с кнопками

        ArrayList<String> leftArray = new ArrayList<>();

        for (WebElement i : leftList) {                                                       // перебор списка
            String caption = i.getAttribute("textContent");                          // считываем текст с кнопки
            leftArray.add(caption);                                                             //  добавляем текст в ArrayList
        }

        System.out.println( " Порядок кнопок до перемещения:      " +ArrayListToString(leftArray));

       new Actions(wd)                                  //  сценарий перетаскивания кнопки в середину набора кнопок
               .moveToElement(leftList.get(0))
               .clickAndHold()
               .moveToElement(leftList.get(3))
               .release()
               .perform();

        leftList = wd.findElements(By.cssSelector("#sortable1 li"));   //заново формируем список
        leftArray = new ArrayList<>();                                          //заново формируем ArrayList


        for (WebElement i : leftList) {
            String caption = i.getAttribute("textContent");
            leftArray.add(caption);
        }

        System.out.println( " Порядок кнопок после перемещения: " +ArrayListToString(leftArray));  // Кнопки отображены в новом порядке
    }

}
