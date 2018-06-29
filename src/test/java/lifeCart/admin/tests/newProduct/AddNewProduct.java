package lifeCart.admin.tests.newProduct;

import lifeCart.admin.appManager.ToolBox;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class AddNewProduct extends ToolBox {

    @Test

            void addNewProduct() {

        click(By.cssSelector("[href$=catalog]"));
        click(By.cssSelector("a.button[href$=edit_product]")); // кнопка добавления продукта
        validateByOuterText(By.cssSelector("#content h1")," Add New Product");  // Валидация заголовка

        click(By.cssSelector("input[type=radio][value='1']"));    // радиокнопка Enabled  (value=1)

        wd.findElement(By.cssSelector("input[name=code]"))
                .sendKeys("Lucky Duck" + Keys.ENTER) ;
    }
}
