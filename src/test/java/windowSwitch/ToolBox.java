package windowSwitch;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

public class ToolBox extends TestBase {

    /**
     * Методы
     */

    void search(String animal) {

        wd.get("https://bash.im/");
        // wd.findElement(By.name("text")).sendKeys(animal);
        //wd.findElement(By.xpath(".//*[@id='search']/button")).click();
        wd.findElement(By.cssSelector("div #search #text")).sendKeys(animal);
        wd.findElement(By.cssSelector("div #search [type=submit]")).click();
    }

    public void click(By locator) {                                    // клик по элементу
        wd.findElement(locator).click();
    }

}
