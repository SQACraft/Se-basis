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

    private WebDriver wd;
    private WebDriverWait wait;
    private Set<Cookie> allCookies;

    @BeforeTest
    public void start() {

        wd = new ChromeDriver();
        wait = new WebDriverWait(wd, 10);
    }

    @Test
    public void cookies() {

        wd.get("https://bash.im/");

        // Вывод всех Cookies после входа на ресурс
        getCookies();
        System.out.println("\nCookies после входа на ресурс:");
        System.out.println(allCookies + "\n");
        System.out.println("Очистка cookies:");

        // Очистка всех Cookies
        wd.manage().deleteAllCookies();
        // Повторная очистка вновь созданной куки tmr_detect, если нужно
        //wd.manage().deleteAllCookies();
        getCookies();

        cookiePresenceMessage();

        // Добавляем cookie
        wd.manage().addCookie(new Cookie("testCookieName", "testCookieValue"));
        getCookies();
        System.out.println("Все Cookies c добавленным  testCookieName:");
        System.out.println(allCookies + "\n");

        // Выводим добавленную cookie
        Cookie testCookie = wd.manage().getCookieNamed("testCookieName");
        System.out.println("Собственно Cookie  testCookieName:");
        System.out.println(testCookie + "\n");

        // Удаляем добавленную cookie
        wd.manage().deleteCookieNamed("testCookieName");
        getCookies();
        System.out.println("Все Cookies после удаления  testCookieName:");
        cookiePresenceMessage();
    }

    @AfterTest
    public void stop() {
        wd.quit();
        wd = null;
    }

    Set<Cookie> getCookies() {
        allCookies = wd.manage().getCookies();
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