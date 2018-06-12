package cssSelectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    public WebDriver wd;
    public WebDriverWait wait;

    @BeforeMethod
    public void start() {

        wd = new ChromeDriver();
        wait = new WebDriverWait(wd, 10);

        wd.get("https://bash.im/");
    }

    @AfterMethod
    void stop() {

     wd.quit();

    }


}


