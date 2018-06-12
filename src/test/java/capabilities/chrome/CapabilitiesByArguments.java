package capabilities.chrome;


import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CapabilitiesByArguments {

    private WebDriver wd;
    private WebDriverWait wait;

    @BeforeTest
    public void start() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-fullscreen");
        wd = new ChromeDriver(options);
        System.out.println(((HasCapabilities) wd).getCapabilities()); // вывод всех capabilities после запуска браузера
        wait = new WebDriverWait (wd, 10);
    }

    @Test
    public void  search()  {
        wd.get ("https://bash.im/");
        wd.findElement(By.cssSelector("div #search #text")).sendKeys("Енот");        // ввод в строке поиска
        wd.findElement(By.cssSelector("div #search [type=submit]")).click();                                // сабмит
    }

    @AfterTest
    public void stop() {
        wd.quit();
        wd = null;
    }


}
