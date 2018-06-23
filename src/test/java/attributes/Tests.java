package attributes;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests extends TestBase {

    /**
     * Value - получение текста, введённого  в строке поиска
     */

    @Test
    public void checkValue() {

        wd.findElement(By.cssSelector(".search input"))
                .sendKeys("I wanna find a duck");                       // ввод текста в строку поиска
        String property = wd.findElement(By.cssSelector(".search input"))
                .getAttribute("value");                                                       // получение свойства
                                                                                                         // (здесь - введённый в строке поиска текст)
        System.out.println("value: " + property);
    }

    /**
     * href -  проверка полной ссылки, так как в html- относительная
     */

    @Test
    public void checkLink() {

        String property = wd.findElement(By.cssSelector("#breadcrumbs [href$='litecart/']"))
                .getAttribute("href");

        System.out.println("href: " + property);
    }

    /**
     * True  - проверка выбранного значения в списке Currency на форме Regional Settings
     */

    @Test
    public void checkSelected() throws InterruptedException {

        wd.findElement(By.cssSelector("#region [href*=regional]")).click();      //открытие  модального окна Regional Settings
        Assert.assertTrue(isOneElementPresent(By.xpath
                ("//h1[contains(text(), 'Regional Settings')]")));                       // валидация заголовка

        String property = wd.findElement(By.cssSelector(
                "#box-regional-settings [value=USD]"))                                 //получаем свойство "выбран" для элемента в списке
                .getAttribute("selected");

        System.out.println("selected: " + property);

        Thread.sleep(1000);                                                           // ожидание  отрисовки крестика
        wd.findElement(By.cssSelector("#fancybox-close")).click();              // закрываем модальное окно
        Thread.sleep(500);                                                          //  ожидание закрытия окна
    }


}
