package elementProperties;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GetText extends TestBase {

    @Test
    void getText()  {

        WebElement button = wd.findElement(By.cssSelector(".button-set button[value=Login]"));
        String btnText= button.getText();   //                 считываем текст с кнопки

        System.out.println(btnText);
    }

    @Test
    void  getNormalizedText() {

        String input = "I wanna    find a duck";

        wd.findElement(By.cssSelector(".search input"))
                .sendKeys(input + Keys.ENTER);

         String fullInput = "Search Results for \"I wanna    find a duck\"";                                   // Ожидаемый вывод с доп.пробелами
         String output = wd.findElement(By.cssSelector("#box-search-results .title")).getText();   // Фактический нормализованный вывод

        Assert.assertNotEquals(fullInput, output);                                                                     // тест должен упасть.

        System.out.println("\nВвод в строке поиска: "+input);
        System.out.println("\nНенормализованный вывод, который ожидался: " +fullInput);
        System.out.println("\nФактический нормализованный вывод: " +output);
        System.out.println("\nПроверка не пройдена, тест завершён успешно");

    }



}
