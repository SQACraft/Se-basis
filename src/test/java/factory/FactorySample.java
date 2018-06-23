package factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.selenium.factory.WebDriverPool;

public class FactorySample {


    public WebDriver wd;
    public WebDriverWait wait;

    @BeforeMethod
    void start() {

        wd = WebDriverPool.DEFAULT.getDriver(DesiredCapabilities.chrome());
        wait = new WebDriverWait(wd, 10);
    }

    @AfterSuite
    void stop() {
        WebDriverPool.DEFAULT.dismissAll();
    }

    @Test
    void test1() {
        search("КОШКА");
    }

    @Test
    void test2() {
        search("CОБАКА");
    }

    @Test
    void test3() {
        search("ЕНОТ");
    }

    @Test
    void test4() {
        search("МЕДВЕДЬ");
    }

    @Test
    void test5() {
        search("КАБАН");
    }

    @Test
    void test6() {
        search("ЛЕМУР");
    }

    @Test
    void test7() {
        search("ПАНДА");
    }

    private void search(String animal) {
        wd.get("https://bash.im/");
        wd.findElement(By.cssSelector("div #search #text")).sendKeys(animal);
        wd.findElement(By.cssSelector("div #search [type=submit]")).click();
    }

}



