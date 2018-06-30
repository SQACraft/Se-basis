package template.appManager;

import org.openqa.selenium.*;
import org.testng.Assert;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public class ToolBox extends TestBase {

    /**
     * Методы
     */

    public boolean isElementPresent(By locator) {
        try {
            wait.until((WebDriver d) -> d.findElement(locator)); // явное (Explicit) ожидание
            wd.findElement(locator);
            return true;
        } catch (TimeoutException ex) {  // исключение при  явном ожидании, если не дождались
            return false;
        } catch (InvalidSelectorException ex) { //подкласс NoSuchElementException, здесь не должен подавляться
            throw ex;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isOneElementPresent(By locator) {         // Проверка наличия одного элемента
        return wd.findElements(locator).size() == 1;
    }

    public boolean areElementsPresent(By locator) {         // Проверка наличия   элементов
        return wd.findElements(locator).size() > 0;
    }

    public int getNumOfElementsFound(By locator) {

        int size = wd.findElements(locator).size();
        System.out.println("Найдено элементов: " + size);
        return size;
    }

    public void click(By locator) {                                    // клик по элементу
        wd.findElement(locator).click();
    }

    public void goToCheckout() {                                    // переход в чекаут
        click(By.cssSelector(("a.link[href$=checkout")));
    }

    public void addToCart() throws InterruptedException {                                    // добавление товара в корзину
        click(By.cssSelector("button[name=add_cart_product]"));
        Thread.sleep(1000);                                                           // таймаут для добавления
    }

    public String arrayListToString(ArrayList arrayName) {                                   // конвертация массиваа в строку

        StringBuilder sb = new StringBuilder();
        for (Object i : arrayName) {
            sb.append(i + "\t");
        }
        String arrayString = sb.toString();
        return arrayString;
    }

    public void validateByTextContent(By locator, String expectedText) {           // проверка текста на странице

        WebElement element = wd.findElement(locator);                           // находим элемент
        String actualText = element.getAttribute("textContent");             // получаем атрибут textContent
        Assert.assertEquals(actualText, expectedText);                                  // валидация текста
    }

    public void validateByOuterText(By locator, String expectedText) {           // проверка текста на странице

        WebElement element = wd.findElement(locator);                           // находим элемент
        String actualText = element.getAttribute("outerText");             // получаем атрибут outerText
        Assert.assertEquals(actualText, expectedText);                                  // валидация заголовка на карточке товара
    }

    public void setCheckboxState(By locator, String action) {    // action:  "toSelect / toClear

        switch (action) {

            case "toSelect":
                if (!wd.findElement(locator).isSelected())  // если чекбокс не выбран-
                {
                    wd.findElement(locator).click();          // выбрать чекбокс
                    break;
                } else {                                             // если чекбокс выбран -
                    break;                                           // ничего не делать
                }

            case "toClear":
                if (wd.findElement(locator).isSelected())  // если чекбокс выбран-
                {
                    wd.findElement(locator).click();         // очистить чекбокс
                    break;
                } else {                                            // если чекбокс не выбран-
                    break;                                          // ничего не делать
                }

            default:
                System.out.println("Некорректный параметр action (toSelect | toClear");
        }
    }

    public String getUniqueNumber(String prefix, String postfix) {        // генератор уникального номера

        // Инициализация объекта date
        Date date = new Date();
        //  Вывод текущей даты и времени с использованием toString()
        String uniqueNumber = String.format("" + prefix + "%ts" + postfix , date);
        return (uniqueNumber);
    }

    public void goToSquareOne() {                                 //  переход на главную
        click(By.cssSelector("img[title='My Store']"));
    }

    public void fileUpload(By locator, String path) {   //загрузка файла в контрол  по абсолютному пути . Path - путь в проекте

        File file = new File(path);
        String absPath = file.getAbsolutePath();            // получаем абсолютный путь из пути внутри проекта

        wd.findElement(locator) .sendKeys(absPath);     // загрузка изображения
    }


    public void fileUploadFromList(WebElement  filelink, String path) {
        //загрузка файла в контрол из списка контролов  по абсолютному пути . Path - путь в проекте WebElement должен идти с индексом (.get(i) )

        File file = new File(path);
        String absPath = file.getAbsolutePath();            // получаем абсолютный путь из пути внутри проекта

        filelink.sendKeys(absPath);     // загрузка изображения
    }
}
