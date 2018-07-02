package template.appManager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

public class ToolBox extends TestBase {

    /**
     * Методы
     */

    /**
     *    Проверка наличия элемента с исключениями
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

    /**
     *    Проверка наличия только ОДНОГО элемента в списке
     */

    public boolean isOneElementPresent(By locator) {         // Проверка наличия одного элемента
        return wd.findElements(locator).size() == 1;
    }

    /**
     *    Проверка наличия  элементов в списке
     */

    public boolean areElementsPresent(By locator) {         // Проверка наличия   элементов
        return wd.findElements(locator).size() > 0;
    }

    /**
     *    Количество  элементов в списке
     */

    public int getNumOfElementsFound(By locator) {

        int size = wd.findElements(locator).size();
        System.out.println("Найдено элементов: " + size);
        return size;
    }

    /**
     *    Клик по элементу
     */

    public void click(By locator) {                                    // клик по элементу
        wd.findElement(locator).click();
    }

    /**
     *   Переход в чекаут ( lifeCart)
     */

    public void goToCheckout() {                                    // переход в чекаут
        click(By.cssSelector("a.link[href$=checkout"));
    }

    /**
     *   Добавление в корзину с явным ожиданием ( lifeCart)
     */

    public void addToCart() {                                          // добавление товара в корзину c явным ожиданием увеличения счётчика

        String quantityParam = wd.findElement(By.cssSelector("[href$=checkout] .quantity"))
                .getAttribute("textContent");                                 // значение счётчика товаров в корзине до добавления
        int quantity = Integer.parseInt(quantityParam);

        click(By.cssSelector("button[name=add_cart_product]"));                        // добавление товара в корзину

        WebDriverWait expWait = new WebDriverWait(wd, 5);                     //  явное ожидание в 5 с (при старте браузера установлено  10)
        WebElement counter = wd.findElement(By.cssSelector("[href$=checkout].content"));
        expWait.until(textToBePresentInElement
                (counter, quantity + 1 + " item(s)"));                                          //явное ожидание инкремента счётчика товаров в корзине
    }

    /**
     *   Конвертация ArrayList в строку
     */

    public String arrayListToString(ArrayList arrayName) {                                   // конвертация массиваа в строку

        StringBuilder sb = new StringBuilder();
        for (Object i : arrayName) {
            sb.append(i + "\t");
        }
        String arrayString = sb.toString();
        return arrayString;
    }

    /**
     *   Валидация текста на странице по атрибуту textContent
     */
    public void validateByTextContent(By locator, String expectedText) {           // валидация текста на странице

        WebElement element = wd.findElement(locator);                           // находим элемент
        String actualText = element.getAttribute("textContent");             // получаем атрибут textContent
        Assert.assertEquals(actualText, expectedText);                                  // валидация текста
    }

    /**
     *   Валидация текста на странице по атрибуту outerText
     */
    public void validateByOuterText(By locator, String expectedText) {           // проверка текста на странице

        WebElement element = wd.findElement(locator);                           // находим элемент
        String actualText = element.getAttribute("outerText");             // получаем атрибут outerText
        Assert.assertEquals(actualText, expectedText);                                  // валидация заголовка на карточке товара
    }

    /**
     *   Выбор/снятие чекбокса в зависимости от его состояния
     */

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

    /**
     *    Генератор уникального номера с префиксом и постфиксом
     */
    public String getUniqueNumber(String prefix, String postfix) {        // генератор уникального номера

        // Инициализация объекта date
        Date date = new Date();
        //  Вывод текущей даты и времени с использованием toString()
        String uniqueNumber = String.format("" + prefix + "%ts" + postfix , date);
        return (uniqueNumber);
    }

    /**
     *    Возврат на главную (liteCart)
     */

    public void goToSquareOne() {                                 //  переход на главную
        click(By.cssSelector("img[title='My Store']"));
    }

    /**
     *    Загрузка файла в контрол  по абсолютному пути
     */

    public void fileUpload(By locator, String path) {   //загрузка файла в контрол  по абсолютному пути . Path - путь к файлу в проекте

        File file = new File(path);
        String absPath = file.getAbsolutePath();            // получаем абсолютный путь из пути внутри проекта

        wd.findElement(locator) .sendKeys(absPath);     // загрузка изображения
    }

    /**
     *    Загрузка файла в контрол из списка контролов  по абсолютному пути
     */

    public void fileUploadFromList(WebElement  filelink, String path) {
        //загрузка файла в контрол из списка контролов  по абсолютному пути .
        // Пример использования:
        //   List<WebElement> uploadControls = wd.findElements(locator);  // формируем список ссылок на загрузку файлов
       //     fileUploadFromList(uploadControls.get(1), "src/test/resources/github.png");   // загрузка второго файла  по индексу элемента в списке

        File file = new File(path);
        String absPath = file.getAbsolutePath();            // получаем абсолютный путь из пути внутри проекта

        filelink.sendKeys(absPath);     // загрузка изображения
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
