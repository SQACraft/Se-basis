package lifeCart.admin.tests.sidebar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class TestBase {


    public WebDriver wd;
    public WebDriverWait wait;
    private String login = "admin";
    private String password = "admin";

    @BeforeSuite
    public void start() {
        wd = new ChromeDriver();
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

    public boolean areElementsPresent(By locator) {         // Проверка наличия элемента
        return wd.findElements(locator).size() > 0;
    }

    public void click(By locator) {                                    // клик по элементу
        wd.findElement(locator).click();
    }


}