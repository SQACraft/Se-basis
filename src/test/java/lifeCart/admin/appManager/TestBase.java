package lifeCart.admin.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestBase {


    public WebDriver wd;
    public WebDriverWait wait;
    private String login = "admin";
    private String password = "admin";

    @BeforeClass
    public void start() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-fullscreen");
        wd = new ChromeDriver(options);

        wait = new WebDriverWait(wd, 10);
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //  неявное (Implicit) ожидание
        login();  // авторизация администратором в системе и переход в админку
    }

    @AfterClass
    public void stop() {        // закрываем сессию браузера
        wd.quit();
    }

    void login() {

        wd.get("http://localhost/litecart/admin/login.php");
        wd.findElement(By.cssSelector("[name=username]")).sendKeys(login);
        wd.findElement(By.cssSelector("[name=password]")).sendKeys(password);
        click(By.cssSelector("[type=submit]"));
        Assert.assertTrue(areElementsPresent(By.cssSelector("[href*=admin]"))); // проверка, что логотип - со страницы админки
    }

    boolean areElementsPresent(By locator) {         // Проверка наличия элемента
        return wd.findElements(locator).size() > 0;
    }

    void click(By locator) {                                    // клик по элементу
        wd.findElement(locator).click();
    }

    void validateByOuterText(By locator, String expectedText) {           // проверка текста на странице

        WebElement element = wd.findElement(locator);                           // находим элемент
        String actualText = element.getAttribute("outerText");             // получаем атрибут outerText
        Assert.assertEquals(actualText, expectedText);                                  // валидация заголовка на карточке товара
    }

}
