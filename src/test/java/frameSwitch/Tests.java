package frameSwitch;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Tests extends ToolBox {

    @Test
    void frameSwitch()   {

        wd.switchTo().frame(wd.findElement
                (By.cssSelector("#live iframe")));     // переключаемся в первый фрейм
        wd.switchTo().frame(wd.findElement
                (By.cssSelector("#sandbox-wrapper iframe"))); // переключаемся во вложенный фрейм

        wd.findElement(By.cssSelector("#test")).sendKeys("test"); // работаем с полем во вложенном фрейме

        wd.switchTo().parentFrame();  // возврат в родительский фрейм
        wd.switchTo().defaultContent(); // возврат в основную страницу, выше фреймов
    }

}
