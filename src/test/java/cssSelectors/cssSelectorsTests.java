package cssSelectors;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class cssSelectorsTests extends TestBase {

    @Test
    public void  navigate()  {

        wd.findElement(By.linkText("лучшие")).click(); // переход по ссылке
        wd.navigate().back();                // возврат в предыдущее окно
        wd.navigate().forward();            // возврат в предыдущее окно
        wd.navigate().refresh();           // возврат в предыдущее окно

    }
    @Test
    public void  header()  {

        String text = wd.findElement(By.cssSelector("#body #header h1")).getText();
        Assert.assertEquals(text, "bash.im — Цитатник Рунета" );
    }










}


//        wd.get("https://bash.im/");
//                // wd.findElement(By.name("text")).sendKeys(animal);
//                //wd.findElement(By.xpath(".//*[@id='search']/button")).click();
//                wd.findElement(By.cssSelector("div #search #text")).sendKeys(animal);
//                wd.findElement(By.cssSelector("div #search [type=submit]")).click();