package lifeCart.admin.countries;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class TestBase {


    public WebDriver wd;
    public WebDriverWait wait;
    private String login = "admin";
    private String password = "admin";

    @BeforeSuite
    void start() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-fullscreen");
        wd = new ChromeDriver(options);

        wait = new WebDriverWait(wd, 10);
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //  неявное (Implicit) ожидание
        login();  // авторизация администратором в системе и переход в админку
    }

    @BeforeMethod
    void goToSquareOne() {                                 //  переход в  корень меню сайдбара
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

    void login() {

        wd.get("http://localhost/litecart/admin/login.php");
        wd.findElement(By.cssSelector("[name=username]")).sendKeys(login);
        wd.findElement(By.cssSelector("[name=password]")).sendKeys(password);
        click(By.cssSelector("[type=submit]"));
        Assert.assertTrue(areElementsPresent(By.cssSelector("[href*=admin]"))); // проверка, что логотип - со страницы админки
    }

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

    String ArrayToString(ArrayList arrayName) {

        StringBuilder sb = new StringBuilder();
        for (Object i :arrayName)
        {
            sb.append(i);
            sb.append("\t");
        }
        String arrayString = sb.toString();
        return  arrayString;
    }
}