package lifeCart.business.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class TestBase {


    public WebDriver wd;
    public WebDriverWait wait;

    @BeforeSuite
    public void start() {
        wd = new ChromeDriver();
        wait = new WebDriverWait(wd, 10);
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //  неявное (Implicit) ожидание
        wd.get("http://localhost/litecart");
    }

    @BeforeMethod
    public void goToSquareOne() {                                 //  переход на главную
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

    public boolean isOneElementPresent(By locator) {         // Проверка наличия одного элемента
        return wd.findElements(locator).size() == 1;
    }

    public boolean areElementsPresent(By locator) {         // Проверка наличия   элементов
        return wd.findElements(locator).size() > 0;
    }

    public int numberOfElementsFound(By locator) {

        int size = wd.findElements(locator).size();
        System.out.println("Найдено элементов: " + size);
        return size;
    }

    public void click(By locator) {                                    // клик по элементу
        wd.findElement(locator).click();
    }

}
