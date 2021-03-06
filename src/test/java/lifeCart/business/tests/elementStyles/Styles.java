package lifeCart.business.tests.elementStyles;

import lifeCart.business.appManager.ToolBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Styles extends ToolBox {

    @Test  (groups = "Styles")

    void checkTitle() {

        goToSquareOne();
        click(By.cssSelector(("div #box-most-popular a.link[href*=p-1")));          // выбор   товара в блоке Campaigns

        validateByTextContent(By.cssSelector("#box-product .title"),
                "Yellow Duck");                                                    // проверка заголовка на странице товара
    }

    @Test (groups = "Styles")

    void checkRegularPrice() {

        goToSquareOne();
        By locator = By.cssSelector(".price-wrapper .regular-price");
        WebElement element = wd.findElement(locator);

        validateByTextContent(locator, "$20");   // проверка цены

        String lineThrough = element.getCssValue("text-decoration");
        Assert.assertEquals(lineThrough, "line-through solid rgb(119, 119, 119)");

        String color = element.getCssValue("color");
        Assert.assertEquals(color, "rgba(119, 119, 119, 1)");

        String fontSize = element.getCssValue("font-size");
        Assert.assertEquals(fontSize, "14.4px");

        String font = element.getCssValue("font");
        Assert.assertEquals(font, "normal normal 400 normal 14.4px / normal Arial, \"Helvetica Neue\", Helvetica, sans-serif");
    }

}