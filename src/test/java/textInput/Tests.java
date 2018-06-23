package textInput;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class Tests extends TestBase {

    @Test
    void keyEnter() {

        wd.findElement(By.cssSelector(".search input"))
                .sendKeys("I wanna find a duck" + Keys.ENTER);                       // ввод текста в строку поиска


    }

}
