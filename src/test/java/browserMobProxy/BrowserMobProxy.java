package browserMobProxy;

import net.lightbody.bmp.core.har.Har;
import org.testng.annotations.Test;

public class BrowserMobProxy extends TestBase {

    /**
     * Тест прокси
     */

    @Test
    void checkProxy() {

        proxy.newHar();

        wd.get("https://selenium2.ru");

        Har har = proxy.endHar();
        har.getLog().getEntries().forEach(l -> System.out.println(l.getResponse().getStatus() + ":" + l.getRequest().getUrl()));
    }


}

