package multithreading;


import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SecondTest extends TestBase{

    @Test
    public void  myFirstTest()  {
        driver.get ("https://bash.im/");
        driver.findElement(By.name("text")).sendKeys("КОТИК");
        driver.findElement(By.xpath(".//*[@id='search']/button")).click();
    }

    @Test
    public void  mySecondTest()  {
        driver.get ("https://bash.im/");
        driver.findElement(By.name("text")).sendKeys("CОБАКА");
        driver.findElement(By.xpath(".//*[@id='search']/button")).click();
    }

    @Test
    public void  myThirdTest()  {
        driver.get ("https://bash.im/");
        driver.findElement(By.name("text")).sendKeys("КОНЬ");
        driver.findElement(By.xpath(".//*[@id='search']/button")).click();
    }


}
