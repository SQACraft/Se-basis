package cssSelectors;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class cssSelectorsTests extends TestBase {

    @Test
    public void navigate() {

        wd.findElement(By.linkText("лучшие")).click();   // переход по ссылке
        wd.navigate().back();                                   // вернуться на предыдущую страницу
        wd.navigate().forward();                               // перейти на следующую страницу
        wd.navigate().refresh();                               //обновить страницу
    }

    @Test
    public void headers() {

        String text = wd.findElement(By.cssSelector("#body #header h1")).getText(); // текст заголовка сайта
        Assert.assertEquals(text, "bash.im — Цитатник Рунета");                      // Проверка соответствия текста

        wd.findElement(By.linkText("лучшие")).click();                           // переход по ссылке
        text = wd.findElement(By.cssSelector("#body h2")).getText();     // текст подзаголовка в разделе сайта
        Assert.assertEquals(text, "Лучшие цитаты дня");                 // Проверка соответствия текста
    }

    @Test
    public void linkSelection() {

        wd.findElement(By.linkText("комиксы")).click();              // переход по ссылке в раздел
        //wd.findElement(By.linkText("08.08.2007" )) .click();      // переход по ссылке с текстом (текст меняется, тест устареет)
        wd.findElement(By.cssSelector(".current a")).click();       // переход на последний комикс (ищем ссылку по классу current)
    }

    @Test
    public void search() {

        wd.findElement(By.cssSelector("div #search #text")).sendKeys("Енот");        // ввод в строке поиска
        wd.findElement(By.cssSelector("div #search [type=submit]")).click();                                // сабмит
    }
}
