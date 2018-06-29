package lifeCart.admin.tests.newProduct;

import lifeCart.admin.appManager.ToolBox;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AddNewProduct extends ToolBox {

    @Test

            void addNewProduct() {

        click(By.cssSelector("[href$=catalog]"));
        click(By.cssSelector("a.button[href$=edit_product]")); // кнопка добавления продукта
        validateByOuterText(By.cssSelector("#content h1")," Add New Product");  // Валидация заголовка

        By locator = By.cssSelector("[type=radio][value='1']");
        click(locator);    // радиокнопка Enabled  (value=1)
         wd.findElement(locator).sendKeys(Keys.TAB);

        wd.findElement(By.cssSelector("input[name='name[en]']"))    // Name
                .sendKeys("Lucky Duck" + Keys.TAB) ;

        wd.findElement(By.cssSelector("input[name=code]"))           // Code
                .sendKeys("Lucky Duck" + Keys.TAB) ;

        setCheckboxState(By.cssSelector("[type=checkbox][data-name='Rubber Ducks'"), "toSelect") ; //выбираем чекбокс категории
        setCheckboxState(By.cssSelector("[type=checkbox][data-name='Subcategory'"), "toSelect") ;  //выбираем чекбокс подкатегории

        WebElement selectElement = wd.findElement(By.cssSelector("select[name=default_category_id]"));    // cписок выбора дефолтной категории
        Select select = new Select(selectElement);
        select.selectByVisibleText("Rubber Ducks");        // выбираем категорию
        selectElement.sendKeys(Keys.TAB);




        
        }
        }
