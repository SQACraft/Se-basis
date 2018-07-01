package javascriptExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class Tests extends javascriptExecutor.ToolBox {


    @Test
    void documentRootLevelTest() {   //Executing JavaScript at the document root level

        String strJavaScript = "document.getElementsByName('language_java')[0].click();";
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript(strJavaScript);
    }


}


