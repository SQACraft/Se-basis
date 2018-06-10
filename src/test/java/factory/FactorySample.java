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


    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeMethod
    public void start() {

        driver = WebDriverPool.DEFAULT.getDriver(DesiredCapabilities.chrome());
        wait = new WebDriverWait(driver, 10);
    }

    @AfterSuite
    public void stop() {
        WebDriverPool.DEFAULT.dismissAll();
    }

    @Test
    public void test1() {
        search("КОШКА");
    }

    @Test
    public void test2() {
        search("CОБАКА");
    }

    @Test
    public void test3() {
        search("ЕНОТ");
    }

    @Test
    public void test4() {
        search("МЕДВЕДЬ");
    }

    @Test
    public void test5() {
        search("КАБАН");
    }

    @Test
    public void test6() {
        search("ЛЕМУР");
    }

    @Test
    public void test7() {
        search("ПАНДА");
    }

    private void search(String animal) {
        driver.get("https://bash.im/");
        driver.findElement(By.name("text")).sendKeys(animal);
        driver.findElement(By.xpath(".//*[@id='search']/button")).click();
    }

}



