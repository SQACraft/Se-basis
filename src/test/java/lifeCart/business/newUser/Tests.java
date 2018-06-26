package lifeCart.business.newUser;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Tests extends TestBase {

    @Test
    void createuser() {

        click(By.cssSelector("[name=login_form] [href$=create_account]"));   // Переход в раздел Create Account
        validateByTextContent(By.cssSelector(".content h1"), "Create Account");  // валидация заголовка

        wd.findElement(By.cssSelector("[name=tax_id]"))
                .sendKeys("7773337" + Keys.TAB);                       // ввод текста + TAB

        wd.findElement(By.cssSelector("[name=company]"))
                .sendKeys("Kewl Features" + Keys.TAB);

        wd.findElement(By.cssSelector("[name=firstname]"))
                .sendKeys("Peter" + Keys.TAB);

        wd.findElement(By.cssSelector("[name=lastname]"))
                .sendKeys("Hawkins" + Keys.TAB);

        wd.findElement(By.cssSelector("[name=address1]"))
                .sendKeys("Berkeley Avenue 1" + Keys.TAB);

        wd.findElement(By.cssSelector("[name=address2]"))
                .sendKeys("Hayfield Street 2" + Keys.TAB);

        wd.findElement(By.cssSelector("[name=postcode]"))
                .sendKeys("K0C 0A4" + Keys.TAB);     // валидный индекс для Канады

        wd.findElement(By.cssSelector("[name=city]"))
                .sendKeys("London" + Keys.TAB);


        WebElement selectElement = wd.findElement(By.cssSelector("select[name=country_code]"));
        Select select = new Select(selectElement);
//        select.selectByValue("DZ")  ;                      // выбираем Algeria по атрибуту
        select.selectByVisibleText("Canada");        // выбираем Canada по тексту в списке
//        select.selectByIndex(3);                        // выбираем Algeria по индексу в списке

        selectElement.sendKeys(Keys.TAB);

        wd.findElement(By.cssSelector("[name=email]"))
                .sendKeys("1@1.1" + Keys.TAB);

        wd.findElement(By.cssSelector("[name=phone]"))
                .sendKeys("11111" + Keys.TAB);



    }

    void setCheckboxState(By locator, String action) {    // Action:  "toSelect / toClear

        switch (action) {

            case "toSelect":
                if (!wd.findElement(locator).isSelected())  // если чекбокс пустой
                {
                    wd.findElement(locator).click();  // выбрать чекбокс
                    break;
                } else {                                   // если чекбокс непустой
                    break;                                            // ничего не делать
                }

            case "toСlear":
                if (wd.findElement(locator).isSelected())  // если чекбокс выбран
                {
                    wd.findElement(locator).clear();  // очистить чекбокс
                    break;
                } else {                                   // если чекбокс не выбран
                    break;                                            // ничего не делать
                }

            default:
                System.out.println("Некорректный параметр action  (toSelect | toClear ");
        }
    }
}
