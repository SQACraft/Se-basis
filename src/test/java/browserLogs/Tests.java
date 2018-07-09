package browserLogs;

import org.testng.annotations.Test;

public class Tests extends TestBase {

    @Test

    public void getBrowserLogs() {

        System.out.println(wd.manage().logs().getAvailableLogTypes());  // типы логов: [performance, browser, driver, client]
        wd.manage().logs().get("browser").forEach((l -> System.out.println(l)));           // логи консоли браузера
    }

    @Test

    public void getPerformanceLogs() {

        wd.manage().logs().get("performance").forEach((l -> System.out.println(l)));  // логи  браузера : Timeline, Netwok , Page events
    }

}
