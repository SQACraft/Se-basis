package elementProperties.elementStyle;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ElementStyle extends TestBase {

    /**
     * Получение цвета текста, фона и границы  заголовка.
     * Валидации - для CHROME
     */

    @Test
    void getColour() {

        String colour = wd.findElement(By.cssSelector("div.page-header [itemprop=headline]"))
                .getCssValue("color");

        Assert.assertEquals(colour, "rgba(214, 70, 63, 1)");        // валидация значения в формате RGBa
    }

    @Test
    void getBgColour() {

        String bgColour = wd.findElement(By.cssSelector("div.page-header [itemprop=headline]"))
                .getCssValue("background-color");

        Assert.assertEquals(bgColour, "rgba(0, 0, 0, 0)");
    }

    @Test
    void getBorderColour() {

        String borderColour = wd.findElement(By.cssSelector("div.page-header [itemprop=headline]"))
                .getCssValue("border-color");

        Assert.assertEquals(borderColour, "rgb(214, 70, 63)");          // валидация значения в формате RGB
    }

    @Test
    void getBackground() {

        String bg = wd.findElement(By.cssSelector("div.page-header [itemprop=headline]"))
                .getCssValue("background");

        Assert.assertEquals(bg, "rgba(0, 0, 0, 0) none repeat scroll 0% 0% / auto padding-box border-box");  // комбинированные стили
    }


}

