package cookies;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;

public class Cookies {

    private WebDriver driver;
    private WebDriverWait wait;
    private Set<Cookie> allCookies;

    @BeforeTest
    public void start() {

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void cookies() {

        driver.get("https://bash.im/");

        // Вывод всех Cookies после входа на ресурс
        getCookies();
        System.out.println("\nCookies после входа на ресурс:");
        System.out.println(allCookies + "\n");
        System.out.println("Очистка cookies:");

        // Очистка всех Cookies
        driver.manage().deleteAllCookies();
        // Повторная очистка вновь созданной куки tmr_detect, если нужно
        //driver.manage().deleteAllCookies();
        getCookies();

        cookiePresenceMessage();

        // Добавляем cookie
        driver.manage().addCookie(new Cookie("testCookieName", "testCookieValue"));
        getCookies();
        System.out.println("Все Cookies c добавленным  testCookieName:");
        System.out.println(allCookies + "\n");

        // Выводим добавленную cookie
        Cookie testCookie = driver.manage().getCookieNamed("testCookieName");
        System.out.println("Собственно Cookie  testCookieName:");
        System.out.println(testCookie + "\n");

        // Удаляем добавленную cookie
        driver.manage().deleteCookieNamed("testCookieName");
        getCookies();
        System.out.println("Все Cookies после удаления  testCookieName:");
        cookiePresenceMessage();
    }

    @AfterTest
    public void stop() {
        driver.quit();
        driver = null;
    }

    Set<Cookie> getCookies() {
        allCookies = driver.manage().getCookies();
        return this.allCookies;
    }

    void cookiePresenceMessage() {

        if (allCookies.size() == 0) {
            System.out.println("Cookies удалены.\n");
        } else {
            System.out.println("Присутствуют cookies:");
            System.out.println(getCookies() + "\n");
        }
    }
}