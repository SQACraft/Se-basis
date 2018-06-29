package template;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver wd;
    public WebDriverWait wait;

    @BeforeSuite
    void start() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-fullscreen");
        wd = new ChromeDriver(options);

        wait = new WebDriverWait(wd, 10);
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //  неявное (Implicit) ожидание
        wd.get("http://localhost/litecart");
    }

    @BeforeMethod
    void goToSquareOne() {                                 //  переход на главную
        click(By.cssSelector("img[title='My Store']"));
    }

    @AfterSuite
    void stop() {        // закрываем сессию браузера
        wd.quit();
    }

    /**
     * Методы
     * TODO: вынести в отдельный класс
     */

    boolean isElementPresent(By locator) {
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

    boolean isOneElementPresent(By locator) {         // Проверка наличия одного элемента
        return wd.findElements(locator).size() == 1;
    }

    boolean areElementsPresent(By locator) {         // Проверка наличия   элементов
        return wd.findElements(locator).size() > 0;
    }

    int getNumOfElementsFound(By locator) {

        int size = wd.findElements(locator).size();
        System.out.println("Найдено элементов: " + size);
        return size;
    }

    void click(By locator) {                                    // клик по элементу
        wd.findElement(locator).click();
    }

    void goToCheckout() {                                    // переход в чекаут
        click(By.cssSelector(("a.link[href$=checkout")));
    }

    void addToCart() throws InterruptedException {                                    // добавление товара в корзину
        click(By.cssSelector("button[name=add_cart_product]"));
        Thread.sleep(1000);                                                           // таймаут для добавления
    }

    String arrayListToString(ArrayList arrayName) {                                   // конвертация массиваа в строку

        StringBuilder sb = new StringBuilder();
        for (Object i : arrayName) {
            sb.append(i + "\t");
        }
        String arrayString = sb.toString();
        return arrayString;
    }

    void validateByTextContent(By locator, String expectedText) {           // проверка текста на странице

        WebElement element = wd.findElement(locator);                           // находим элемент
        String actualText = element.getAttribute("textContent");             // получаем атрибут textContent
        Assert.assertEquals(actualText, expectedText);                                  // валидация заголовка на карточке товара
    }

    void validateByOuterText(By locator, String expectedText) {           // проверка текста на странице

        WebElement element = wd.findElement(locator);                           // находим элемент
        String actualText = element.getAttribute("outerText");             // получаем атрибут outerText
        Assert.assertEquals(actualText, expectedText);                                  // валидация заголовка на карточке товара
    }

    void setCheckboxState(By locator, String action) {    // action:  "toSelect / toClear

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

    String getUniqueNumber(String prefix, String postfix) {        // генератор уникального номера с префиксом и постфиксом

        // Инициализация объекта date
        Date date = new Date();
        //  Вывод текущей даты и времени с использованием toString()
        String uniqueNumber = String.format("" + prefix + "%ts" + postfix , date);
        return (uniqueNumber);
    }

    public void fileUpload(By locator, String path) {   //загрузка файла в контрол  по абсолютному пути . Path - путь в проекте

        File file = new File(path);
        String absPath = file.getAbsolutePath();

        wd.findElement(locator) .sendKeys(absPath);     // загрузка изображения
    }
}