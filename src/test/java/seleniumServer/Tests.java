package seleniumServer;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Tests extends ToolBox {

    @Test
    void testTemplate() {



            wd.get("https://bash.im/");
            wd.findElement(By.name("text")).sendKeys("котик");
            wd.findElement(By.xpath(".//*[@id='search']/button")).click();


    }

}
