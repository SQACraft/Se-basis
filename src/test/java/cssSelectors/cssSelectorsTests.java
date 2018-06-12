package cssSelectors;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class cssSelectorsTests extends TestBase {

    @Test
    public void  navigate()  {

        driver.findElement(By.linkText("лучшие")).click(); // переход по ссылке
        driver.navigate().back();                // возврат в предыдущее окно
        driver.navigate().forward();            // возврат в предыдущее окно
        driver.navigate().refresh();           // возврат в предыдущее окно

    }
    @Test
    public void  header()  {

        String text = driver.findElement(By.cssSelector("#body #header h1")).getText();
        Assert.assertEquals(text, "bash.im — Цитатник Рунета" );
    }










}


//        driver.get("https://bash.im/");
//                // driver.findElement(By.name("text")).sendKeys(animal);
//                //driver.findElement(By.xpath(".//*[@id='search']/button")).click();
//                driver.findElement(By.cssSelector("div #search #text")).sendKeys(animal);
//                driver.findElement(By.cssSelector("div #search [type=submit]")).click();