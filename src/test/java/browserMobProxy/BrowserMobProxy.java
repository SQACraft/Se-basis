package browserMobProxy;

import net.lightbody.bmp.core.har.Har;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserMobProxy extends TestBase {

    /**
     *  Тест прокси
     */

    @Test
    void checkProxy() {

        proxy.newHar();
        wd.get("https://selenium2.ru");
/*
        String colour = wd.findElement(By.cssSelector("div.page-header [itemprop=headline]"))
                .getCssValue("color");

        Assert.assertEquals(colour, "rgba(214, 70, 63, 1)");        // валидация значения в формате RGBa
*/

        Har har = proxy.endHar();
        har.getLog().getEntries().forEach(l -> System.out.println(l.getResponse().getStatus() + ":" + l.getRequest().getUrl()) );
    }


}

