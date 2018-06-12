package cssSelectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeMethod
    public void start() {

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);

        driver.get("https://bash.im/");
    }

    @AfterMethod
    void stop() {

     driver.quit();
     //driver = null;
    }


}


