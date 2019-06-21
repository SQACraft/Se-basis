package javascriptExecutor;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$$;

public class Tests extends javascriptExecutor.ToolBox {

    @Test
    void documentRootLevelTest() {   //Executing JavaScript at the document root level

        JavascriptExecutor js = (JavascriptExecutor) wd;
        String strJavaScript = "document.getElementsByName('language_java')[0].click();";
        js.executeScript(strJavaScript);
    }

    @Test
    void elementLevelTest() {   //Executing JavaScript at the document root level

        JavascriptExecutor js = (JavascriptExecutor) wd;
        WebElement firstName = wd.findElement(By.cssSelector("#firstname"));
        js.executeScript("arguments[0].value='Oleg';", firstName);
    }

    @Test
    void elementClick() {   //Two ways of clicking element

        JavascriptExecutor js = (JavascriptExecutor) wd;

        js.executeScript("document.getElementById('firstname').click();");  //1

        WebElement firstName = wd.findElement(By.cssSelector("#firstname"));  //2
        js.executeScript("arguments[0].click();", firstName);
    }

    /** Клик по невидимому элементу со свойством displayed:false в DOM)
     * @param element
     */
        @Test
    public void clickElementWithJS(SelenideElement element ) {
        String jsClickCode = "arguments[0].scrollIntoView(true); arguments[0].click();";
        try {
            SelenideElement elementToClick =  $$(".tag__icon--delete").get(0);
            Selenide.executeJavaScript(jsClickCode, elementToClick);
        } catch(Exception e) {
            System.out.println("Element could not be clicked.. "  + e.getMessage());
        }
    }

}

