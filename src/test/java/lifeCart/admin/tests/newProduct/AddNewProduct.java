package lifeCart.admin.tests.newProduct;

import lifeCart.admin.appManager.ToolBox;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class AddNewProduct extends ToolBox {

    @Test
    void addNewProduct() {

        click(By.cssSelector("[href$=catalog]"));
        click(By.cssSelector("a.button[href$=edit_product]")); // кнопка добавления продукта
        validateByOuterText(By.cssSelector("#content h1"), " Add New Product");  // Валидация заголовка

        By locator = By.cssSelector("[type=radio][value='1']");
        click(locator);    // радиокнопка Enabled  (value=1)
        wd.findElement(locator).sendKeys(Keys.TAB);

        wd.findElement(By.cssSelector("input[name='name[en]']"))    // Name
                .sendKeys("Lucky Duck" + Keys.TAB);

        wd.findElement(By.cssSelector("input[name=code]"))           // Code
                .sendKeys("Lucky Duck" + Keys.TAB);

        setCheckboxState(By.cssSelector("[type=checkbox][data-name='Rubber Ducks'"), "toSelect"); //выбираем чекбокс категории
        setCheckboxState(By.cssSelector("[type=checkbox][data-name='Subcategory'"), "toSelect");  //выбираем чекбокс подкатегории

        WebElement selectElement = wd.findElement(By.cssSelector("select[name=default_category_id]"));    // cписок выбора дефолтной категории
        Select select = new Select(selectElement);
        select.selectByVisibleText("Rubber Ducks");        // выбираем категорию

        setCheckboxState(By.cssSelector("[type=checkbox][value='1-1'"), "toSelect"); //выбираем чекбокс Product Groups - Gender - Male

        locator = By.cssSelector("[type=number][name=quantity]");
        wd.findElement(locator).clear();    // Name
        wd.findElement(locator).sendKeys("777,00" + Keys.TAB);    // Name

        selectElement = wd.findElement(By.cssSelector("select[name=quantity_unit_id]"));    // cписок выбора меры количества
        select = new Select(selectElement);
        select.selectByVisibleText("kgs");
        selectElement.sendKeys(Keys.TAB);

        selectElement = wd.findElement(By.cssSelector("select[name=delivery_status_id]"));    // cписок выбора статуса доставки
        select = new Select(selectElement);
        select.selectByVisibleText("Next day");
        selectElement.sendKeys(Keys.TAB);

        selectElement = wd.findElement(By.cssSelector("select[name=sold_out_status_id]"));    // cписок выбора статуса товара
        select = new Select(selectElement);
        select.selectByVisibleText("Ready for sale");
        selectElement.sendKeys(Keys.TAB);

        locator = By.cssSelector("[type=file][name='new_images[]']");                  // загрузка первого файла
        fileUpload(locator, "src/test/resources/сomma.png");

        wd.findElement(By.cssSelector("a#add-new-image")).click();                         // добавляем ещё одну загрузку

        List<WebElement> uploadControls = wd.findElements(locator);  // формируем список ссылок на загрузку файлов
        fileUploadTwo(uploadControls.get(1), "src/test/resources/сomma.png");   // загрузка второго файла  по индексу элемента в списке

                locator = (By.cssSelector("input[name=date_valid_from]"));
                wd.findElement(locator).click();
                wd.findElement(locator).sendKeys("13121968" + Keys.TAB);   // Code

                locator = (By.cssSelector("input[name=date_valid_to]"));
                wd.findElement(locator).click();
                wd.findElement(locator).sendKeys("30062018");

                click(By.cssSelector("button[name=save]")); // кнопка добавления продукта

                validateByOuterText(By.cssSelector("#content h1"), " Catalog");  // Валидация заголовка
                validateByTextContent(By.cssSelector(".notice.success"),
                        " Changes saved");       //валидация сообщения
            }

         }