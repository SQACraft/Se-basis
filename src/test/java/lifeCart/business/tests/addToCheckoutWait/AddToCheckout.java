package lifeCart.business.tests.addToCheckoutWait;

import lifeCart.business.appManager.ToolBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

public class AddToCheckout extends ToolBox {


    @Test
    void checkExplicitWait() throws InterruptedException {

        goToSquareOne();
        click(By.cssSelector(("div #box-most-popular a.link[href*=p-3"))); // выбор первого товара
        validateByTextContent(By.cssSelector("#box-product .title"),     // проверка заголовка на странице товара
                "Red Duck");

        addToCart();
    }


}