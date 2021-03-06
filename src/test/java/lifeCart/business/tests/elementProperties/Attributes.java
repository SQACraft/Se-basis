package lifeCart.business.tests.elementProperties;

import lifeCart.business.appManager.ToolBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Attributes extends ToolBox {

    /**
     * Value - получение текста, введённого  в строке поиска
     */

    @Test (groups = "Attributes")
    void checkValue() {

        goToSquareOne();
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

    @Test(groups = "Attributes")
    void checkLink() {

        goToSquareOne();
        String property = wd.findElement(By.cssSelector("#breadcrumbs [href$='litecart/']"))
                .getAttribute("href");

        System.out.println("href: " + property);
    }

    /**
     * True  - проверка выбранного значения в списке Currency на форме Regional Settings
     */

    @Test(groups = "Attributes")
    void checkSelected() throws InterruptedException {

        goToSquareOne();
        wd.findElement(By.cssSelector("#region [href*=regional]")).click();      //открытие  модального окна Regional Settings (линк Change в хедере)
        validateByTextContent(By.cssSelector("#fancybox-content h1"),
                "Regional Settings");                                                    // проверка заголовка
        String property = wd.findElement(By.cssSelector(
                "#box-regional-settings [value=USD]"))                                 //получаем свойство "выбран" для элемента в списке
                .getAttribute("selected");

        System.out.println("selected: " + property);

        Thread.sleep(1000);                                                              // ожидание  отрисовки крестика
        WebElement cross = wd.findElement(By.cssSelector("#fancybox-close"));

        if (cross.isDisplayed()) {                                                                  // тренировка применения isDisplayed()
            cross.click();                                                                                // закрываем модальное окно
        }

        Thread.sleep(500);                                                          //  ожидание закрытия окна
    }


}
